package com.mikemiroliubov.kafkapartitionaware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class KafkaPartitionAwareConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPartitionAwareConsumerApplication.class, args);
	}

}
