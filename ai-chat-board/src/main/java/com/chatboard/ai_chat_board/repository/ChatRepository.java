package com.chatboard.ai_chat_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chatboard.ai_chat_board.entity.ChatMessage;

public interface ChatRepository
        extends JpaRepository<ChatMessage, Long> {

}