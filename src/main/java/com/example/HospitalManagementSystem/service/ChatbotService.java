package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.DTO.ChatbotRespDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChatbotService {

    private final RestTemplate restTemplate;

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    public ChatbotRespDTO askChatbot(String userMessage) {

        try {
            // Build the message payload
            Map<String, Object> message = Map.of(
                    "role", "user",
                    "content", userMessage
            );

            Map<String, Object> requestBody = Map.of(
                    "model", "gpt-3.5-turbo",
                    "messages", List.of(message)
            );

            // Set headers with Bearer token
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

            // Call OpenAI API
            Map response = restTemplate.postForObject(apiUrl, entity, Map.class);

            // Log the raw response for debugging
            System.out.println("OpenAI Response: " + response);

            // Check if response is null
            if (response == null) {
                return new ChatbotRespDTO("No response from OpenAI.");
            }

            // Handle OpenAI API errors
            if (response.containsKey("error")) {
                Map error = (Map) response.get("error");
                String errorMessage = (String) error.get("message");
                return new ChatbotRespDTO("OpenAI error: " + errorMessage);
            }

            // Extract chatbot reply
            List choices = (List) response.get("choices");
            if (choices == null || choices.isEmpty()) {
                return new ChatbotRespDTO("Sorry, AI returned no choices.");
            }

            Map firstChoice = (Map) choices.get(0);
            Map messageResp = (Map) firstChoice.get("message");
            String botReply = (String) messageResp.get("content");

            return new ChatbotRespDTO(botReply != null ? botReply.trim() : "No content from AI.");

        } catch (HttpClientErrorException.TooManyRequests e) {
            // Handle 429 / quota exceeded
            return new ChatbotRespDTO("quota exceeded. Please try again later.");
        } catch (Exception e) {
            // Catch any other exceptions
            e.printStackTrace();
            return new ChatbotRespDTO("Sorry, something went wrong. Please try again later.");
        }
    }
}
