package com.imooc.order.controller;

import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Classname HystrixController
 * @Description 服务熔断降级
 * @Date 2019/12/18 11:43
 * @Created by wangpeng116
 */
@RestController
@RequestMapping("/hystrix")
@DefaultProperties(defaultFallback = "defaultFallback")
@Slf4j
public class HystrixController {

    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @GetMapping("/getProductInfoList")
    public String getProductInfoList() {
        RestTemplate restTemplate = new RestTemplate();
        List<String> paramters = Lists.newArrayList("157875196366160022");
        return restTemplate.postForObject("http://127.0.0.1:8080/product/listForOrder", paramters, String.class);
    }

    @HystrixCommand(threadPoolKey = "WPThreadPool", ignoreExceptions = NullPointerException.class, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "1"),
            @HystrixProperty(name = "maxQueueSize", value = "1"),
    })
    @GetMapping("/productInfoList")
    public String productInfoList() {
        RestTemplate restTemplate = new RestTemplate();
        List<String> paramters = Lists.newArrayList("157875196366160022");
        log.info("我再运行");
        return restTemplate.postForObject("http://127.0.0.1:8080/product/listForOrder", paramters, String.class);
    }

    private String fallback() {
        return "服务拥挤，请稍后再试";
    }

    private String defaultFallback() {
        return "默认提示：服务拥挤，请稍后再试";
    }
}
