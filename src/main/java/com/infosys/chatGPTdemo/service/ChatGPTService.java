package com.infosys.chatGPTdemo.service;

import com.google.gson.Gson;
import com.infosys.chatGPTdemo.model.ChatGPTRequest;
import com.infosys.chatGPTdemo.model.ChatGPTResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatGPTService {

    private String OPEN_AI_URL = "https://api.openai.com/v1/completions"; // URL for OpenAI API
    private String OPEN_AI_KEY = "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"; // API key for accessing OpenAI API

    public String search(String query) {

        ChatGPTRequest chatGPTRequest = new ChatGPTRequest();
        chatGPTRequest.setPrompt(query);

        String url = OPEN_AI_URL; // Assigning the URL for OpenAI API

        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json"); // Setting content type as JSON
        httpPost.addHeader("Authorization", "Bearer " + OPEN_AI_KEY); // Adding API key to authorization header

        Gson gson = new Gson();
        String body = gson.toJson(chatGPTRequest);
        log.info("body: " + body);

        try {
            final StringEntity entity = new StringEntity(body);
            httpPost.setEntity(entity);

            try (CloseableHttpClient httpClient = HttpClients.custom().build();
                 CloseableHttpResponse response = httpClient.execute(httpPost)) {

                String responseBody = EntityUtils.toString(response.getEntity());

                log.info("response body: " + responseBody);

                ChatGPTResponse chatGPTResponse = gson.fromJson(responseBody, ChatGPTResponse.class);

                return chatGPTResponse.getChoices().get(0).getText();
            } catch (Exception e) {
                return "failed";
            }
        } catch (Exception e) {
            return "failed";
        }
    }
}
