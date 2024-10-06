package com.varc.sampleserver.controller;

import com.varc.sampleserver.domain.entity.ChatMessage;
import com.varc.sampleserver.domain.repository.ChatMessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Slf4j
@Controller
public class ChatController {
    private final ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatController(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        log.debug("sendMessage called");
        log.debug("message: {}", message);
        message.setTimestamp(LocalDateTime.now());
        chatMessageRepository.save(message);
        return message;
    }
}
