package com.mikemiroliubov.kafkapartitionaware.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikemiroliubov.kafkapartitionaware.vo.ResultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendData(List<Integer> ids, int partition) {
        log.info("Publishing data into partition {}", partition);
        ids.stream()
            .flatMap(id -> IntStream.range(0, 100).mapToObj(i -> new ResultVO(id, i)))
            .forEach(vo -> {
                try {
                    kafkaTemplate.send("results", partition, "" , objectMapper.writeValueAsString(vo));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
    }
}
