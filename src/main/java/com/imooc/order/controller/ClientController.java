package com.imooc.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getProductMsg")
    public String getProductMsg() {
        /**1、第一种方式（直接使用restTemplate，url写死）*/
        /**缺陷，ip写死，无法负载均衡*/
        /*RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8080/server/msg", String.class);*/

        /**2、第二种方式（利用loadBalanceClient通过应用名获取url，然后再使用restTemplate）*/
        /**好处是可以达到负载均衡，但是每次都要拼接url信息*/
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/server/msg";
        log.info("url是：{}",url);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        /**3、第三种方式（通过bean和注解的方式，@LoadBalanced）*/
        /*String response = restTemplate.getForObject("http://PRODUCT/server/msg",String.class);
        log.info("response={}", response);*/
        return response;
    }
}
