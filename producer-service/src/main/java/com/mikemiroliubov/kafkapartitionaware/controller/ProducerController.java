package com.mikemiroliubov.kafkapartitionaware.controller;

import com.mikemiroliubov.kafkapartitionaware.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @GetMapping("/data")
    public void getData(@RequestParam List<Integer> ids, @RequestParam int partition) {
        producerService.sendData(ids, partition);
    }
}

