package com.example;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "myClient", url = "${my.client.url}")
public interface ClientForApi {

    @RequestMapping("/hello")
    String hello();
}
