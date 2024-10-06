package com.varc.sampleserver.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "chatMessages")
public class ChatMessage {
    @Id
    private String id;
    private String content;
    private String sender;
    private LocalDateTime timestamp;
}
