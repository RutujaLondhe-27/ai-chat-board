package com.chatboard.ai_chat_board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatboard.ai_chat_board.entity.ChatMessage;
import com.chatboard.ai_chat_board.service.ChatService;

@RestController
@RequestMapping("/chat")
@CrossOrigin("*")
public class ChatController {

    @Autowired
    private ChatService service;

    @PostMapping
    public ChatMessage sendMessage(
            @RequestParam String message) {

        return service.saveChat(message);
    }

    @GetMapping
    public List<ChatMessage> getChats() {

        return service.getAllChats();
    }
}