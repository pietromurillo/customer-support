package com.github.pietromurillo.customer_support.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String sender; // Ex: "CLIENT" ou "BOT"

    private LocalDateTime timestamp;

    // Muitas mensagens pertencem a um único usuário (Histórico)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}