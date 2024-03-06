package com.infosys.chatGPTdemo.controller;

import com.infosys.chatGPTdemo.model.SearchRequest;
import com.infosys.chatGPTdemo.service.ChatGPTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@Slf4j
@RequestMapping("/api")
public class ChatGPTController {

    private ChatGPTService chatGPTService;

    public ChatGPTController(ChatGPTService chatGPTService){
        this.chatGPTService = chatGPTService;
    }

    @PostMapping("/askChatGPT")
    public String askChatGPT(@RequestBody SearchRequest searchRequest) throws UnsupportedEncodingException {
        log.info("search started: " + searchRequest.getQuery());
        return this.chatGPTService.search(searchRequest.getQuery());
    }
}
