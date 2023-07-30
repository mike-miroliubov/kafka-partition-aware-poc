package com.mikemiroliubov.kafkapartitionaware.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Listener {
    @KafkaListener(topicPartitions = {
            @TopicPartition(topic = "results", partitions = "${partition}")
    })
    public void receiveMessage(String data) {
        log.info("{}", data);
    }
}
