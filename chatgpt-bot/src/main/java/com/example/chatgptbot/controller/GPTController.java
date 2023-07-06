package com.example.chatgptbot.controller;

import com.example.chatgptbot.dto.GPTRequest;
import com.example.chatgptbot.dto.GPTResponse;
import com.example.chatgptbot.services.GPTService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kelleqend")
public class GPTController {

    private final GPTService gptService;

    public GPTController(GPTService gptService) {
        this.gptService = gptService;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){
        return gptService.askGpt(prompt);
    }

}
