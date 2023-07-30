package com.mikemiroliubov.kafkapartitionaware.client;

import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface ProducerClient {
    @RequestLine("GET /data?ids={ids}&partition={partition}")
    void getData(@Param("ids") List<Integer> ids, @Param("partition") int partition);
}
