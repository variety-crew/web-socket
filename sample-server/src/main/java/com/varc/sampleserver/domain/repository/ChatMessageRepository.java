package com.varc.sampleserver.domain.repository;

import com.varc.sampleserver.domain.entity.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
}
