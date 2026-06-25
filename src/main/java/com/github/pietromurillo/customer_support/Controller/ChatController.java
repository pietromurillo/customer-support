package com.github.pietromurillo.customer_support.Controller;

import com.github.pietromurillo.customer_support.Model.Message;
import com.github.pietromurillo.customer_support.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    // Rota para enviar mensagem: POST http://localhost:8080/chat/send?userId=1
    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestParam Long userId, @RequestBody String content) {
        try {
            Message botMessage = chatService.sendMessage(userId, content);
            return ResponseEntity.ok(botMessage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Rota para pegar o histórico: GET http://localhost:8080/chat/history?userId=1
    @GetMapping("/history")
    public ResponseEntity<?> getHistory(@RequestParam Long userId) {
        try {
            List<Message> history = chatService.getHistory(userId);
            return ResponseEntity.ok(history);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}