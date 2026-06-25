package com.github.pietromurillo.customer_support.Service;

import com.github.pietromurillo.customer_support.Model.Message;
import com.github.pietromurillo.customer_support.Model.User;
import com.github.pietromurillo.customer_support.Repository.MessageRepository;
import com.github.pietromurillo.customer_support.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    // Envia mensagem do cliente e gera resposta do Bot
    public Message sendMessage(Long userId, String content) {
        // 1. Validar se o texto não está em branco (Tratamento de erro)
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Message content cannot be empty!");
        }

        // 2. Buscar o usuário no banco
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        // 3. Salvar a mensagem do Cliente
        Message clientMessage = new Message();
        clientMessage.setContent(content);
        clientMessage.setSender("CLIENT");
        clientMessage.setTimestamp(LocalDateTime.now());
        clientMessage.setUser(user);
        messageRepository.save(clientMessage);

        // 4. Lógica do Chatbot (Respostas automáticas simples baseadas em palavras-chave)
        String botResponse = generateBotResponse(content);

        // 5. Salvar a resposta do Bot no banco (Histórico)
        Message botMessage = new Message();
        botMessage.setContent(botResponse);
        botMessage.setSender("BOT");
        botMessage.setTimestamp(LocalDateTime.now());
        botMessage.setUser(user);

        return messageRepository.save(botMessage); // Retorna a resposta do bot para o controller
    }

    // Busca o histórico de conversas do usuário
    public List<Message> getHistory(Long userId) {
        return messageRepository.findByUserId(userId);
    }

    // Regra simples do Chatbot
    private String generateBotResponse(String message) {
        String msgLower = message.toLowerCase();

        if (msgLower.contains("olá") || msgLower.contains("oi")) {
            return "Olá! Como posso ajudar você hoje com o nosso sistema?";
        } else if (msgLower.contains("senha") || msgLower.contains("acesso")) {
            return "Para problemas com senha, clique em 'Esqueci minha senha' na tela inicial ou fale com o Admin.";
        } else if (msgLower.contains("erro") || msgLower.contains("bug")) {
            return "Poxa, lamento por isso. Poderia me enviar o print ou o código do erro para eu analisar?";
        } else if (msgLower.contains("obrigado") || msgLower.contains("valeu")) {
            return "De nada! Se precisar de algo mais, é só chamar.";
        } else {
            return "Desculpe, não entendi muito bem. Você poderia tentar explicar de outra forma?";
        }
    }
}