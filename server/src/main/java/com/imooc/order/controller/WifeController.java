package com.imooc.order.controller;

import com.imooc.order.config.ConfigProperties;
import com.imooc.order.form.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/catchRequestBody")
    public String catchRequestBody(@RequestBody OrderForm orderForm){
        return "ok";
    }
}
