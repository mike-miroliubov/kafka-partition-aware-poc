package com.mikemiroliubov.kafkapartitionaware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class KafkaPartitionAwareProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPartitionAwareProducerApplication.class, args);
	}

}
