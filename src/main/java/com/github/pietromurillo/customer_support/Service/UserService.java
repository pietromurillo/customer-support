package com.github.pietromurillo.customer_support.Service;

import com.github.pietromurillo.customer_support.Model.User;
import com.github.pietromurillo.customer_support.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Lógica de Cadastro
    public User register(User user) {
        // Validação simples de dados em branco (Tratamento de erro)
        if (user.getUsername() == null || user.getUsername().trim().isEmpty() ||
                user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Username and password cannot be empty!");
        }

        // Verifica se o usuário já existe
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken!");
        }

        user.setRole("CLIENT"); // Padrão
        return userRepository.save(user);
    }

    // Lógica de Login
    public User login(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);

        // Tratamento de erro pedido no requisito: "Usuário não cadastrado"
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not registered!");
        }

        User user = userOpt.get();

        // Verifica a senha (em um sistema real usaríamos criptografia, aqui faremos direto para simplificar)
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password!");
        }

        return user; // Retorna o usuário logado
    }
}