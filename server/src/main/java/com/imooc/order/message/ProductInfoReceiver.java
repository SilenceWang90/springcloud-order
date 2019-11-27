package com.imooc.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @Classname ProductInfoReceiver
 * @Description TODO
 * @Date 2019/11/27 14:30
 * @Created by wangpeng116
 */
@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ProductInfoOutput> productInfoOutputList = objectMapper.readValue(message, new TypeReference<List<ProductInfoOutput>>() {
        });
        log.info("接收到的消息:{}", productInfoOutputList);
        //存储到redis中
        productInfoOutputList.forEach(productInfoOutput -> {
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getProductId()),
                    String.valueOf(productInfoOutput.getProductStock()));
        });
    }
}
