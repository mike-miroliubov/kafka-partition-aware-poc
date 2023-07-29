package com.mikemiroliubov.kafkapartitionaware.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikemiroliubov.kafkapartitionaware.vo.ResultVO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendMessage(ResultVO vo) {
        try {
            kafkaTemplate.send("results", objectMapper.writeValueAsString(vo));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
