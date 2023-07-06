package com.example.chatgptbot.services;

import com.example.chatgptbot.dto.GPTRequest;
import com.example.chatgptbot.dto.GPTResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GPTService {

    Logger logger = LoggerFactory.getLogger(GPTService.class);
    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String url;

    private final RestTemplate restTemplate;

    public GPTService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String askGpt(String prompt){
        GPTRequest request=new GPTRequest(model, prompt);
        GPTResponse chatGptResponse = restTemplate.postForObject(url, request, GPTResponse.class);
        logger.info("ASKED QUESTION :" + request.getMessages().get(0).getContent());
        String answer = chatGptResponse.getChoices().get(0).getMessage().getContent();
        logger.info("ANSWERED :" +answer);
        return answer;
    }
}
