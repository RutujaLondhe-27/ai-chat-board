package com.chatboard.ai_chat_board.service;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatboard.ai_chat_board.entity.ChatMessage;
import com.chatboard.ai_chat_board.repository.ChatRepository;

@Service
public class ChatService {

    @Autowired
    private ChatRepository repository;

    public ChatMessage saveChat(String message) {

        String response =
                "Hello, you said: " + message;

        ChatMessage chat =
                new ChatMessage();

        chat.setUserMessage(message);
        chat.setAiResponse(response);
        chat.setCreatedAt(LocalDateTime.now());
        return repository.save(chat);
       
    }

    public List<ChatMessage> getAllChats() {

        return repository.findAll();
    }
}