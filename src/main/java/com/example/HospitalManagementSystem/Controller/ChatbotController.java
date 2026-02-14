package com.example.HospitalManagementSystem.Controller;


import com.example.HospitalManagementSystem.DTO.ChatbotReqDTO;
import com.example.HospitalManagementSystem.DTO.ChatbotRespDTO;
import com.example.HospitalManagementSystem.service.ChatbotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatbot")
@RequiredArgsConstructor
public class ChatbotController {

    private final ChatbotService chatbotService;

    @PostMapping("/ask")
    public ResponseEntity<ChatbotRespDTO> askChatbot(@RequestBody ChatbotReqDTO requestDTO) {
        ChatbotRespDTO responseDTO = chatbotService.askChatbot(requestDTO.getMessage());
        return ResponseEntity.ok(responseDTO);
    }
}

