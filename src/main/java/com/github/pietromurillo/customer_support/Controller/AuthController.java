package com.github.pietromurillo.customer_support.Controller;

import com.github.pietromurillo.customer_support.Model.User;
import com.github.pietromurillo.customer_support.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Rota de Cadastro: POST http://localhost:8080/auth/register
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            userService.register(user);
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            // Retorna a mensagem amigável de erro
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Rota de Login: POST http://localhost:8080/auth/login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
        try {
            User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
            return ResponseEntity.ok("Login successful! Welcome, " + user.getUsername());
        } catch (Exception e) {
            // Retorna o erro amigável (ex: "User not registered!")
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}