package com.mikemiroliubov.kafkapartitionaware.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ConsumerAwareRebalanceListener;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Configuration
public class KafkaConfig {
    @Bean
    public AtomicReference<List<TopicPartition>> currentPartitions() {
        return new AtomicReference<>();
    }

    @Bean
    public ConsumerAwareRebalanceListener rebalanceListener(AtomicReference<List<TopicPartition>> currentPartitions) {
        return new ConsumerAwareRebalanceListener() {
            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
                log.info("Setting partitions for application: {}", partitions);
                currentPartitions.set(partitions.stream().toList());
            }
        };
    }
}
