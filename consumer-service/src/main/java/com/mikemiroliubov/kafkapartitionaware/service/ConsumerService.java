package com.mikemiroliubov.kafkapartitionaware.service;

import com.mikemiroliubov.kafkapartitionaware.client.ProducerClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.TopicPartition;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerService {
    private final AtomicReference<List<TopicPartition>> currentPartitions;

    private final ProducerClient producerClient;

    @Scheduled(fixedDelay = 1000 * 60, initialDelay = 10 * 1000)
    public void requestData() {
        List<TopicPartition> partitions = currentPartitions.get();
        int randomPartition = new Random().nextInt(partitions.size());
        log.info("Requesting data into partition {}", randomPartition);
        producerClient.getData(List.of(1, 2, 3), partitions.get(randomPartition).partition());
    }

}
