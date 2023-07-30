package com.mikemiroliubov.kafkapartitionaware.config;

import com.mikemiroliubov.kafkapartitionaware.client.ProducerClient;
import feign.Feign;
import feign.Logger;
import feign.http2client.Http2Client;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public ProducerClient producerClient() {
        return Feign.builder()
                .client(new Http2Client())
                .logger(new Slf4jLogger())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logLevel(Logger.Level.FULL)
                .target(ProducerClient.class, "http://localhost:8080");
    }
}
