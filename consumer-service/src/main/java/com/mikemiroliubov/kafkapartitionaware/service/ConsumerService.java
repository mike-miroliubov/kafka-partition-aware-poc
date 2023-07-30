package com.mikemiroliubov.kafkapartitionaware.service;

import com.mikemiroliubov.kafkapartitionaware.client.ProducerClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerService {
    private final ProducerClient producerClient;

    @Value("${partition}")
    private final int partition;

    @Scheduled(fixedDelay = 1000 * 60, initialDelay = 10 * 1000)
    public void requestData() {
        log.info("Requesting data into partition {}", partition);
        producerClient.getData(List.of(partition), partition);
    }

}
