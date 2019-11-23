package com.imooc.order.controller;

import com.imooc.order.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wife")
public class WifeController {
    @Autowired
    private ConfigProperties configProperties;

    @RequestMapping("/print")
    public String print(){
        return configProperties.toString();
    }
}
