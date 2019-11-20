package com.imooc.order.client;

import com.imooc.order.dataobject.ProductInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Classname ProductClient
 * @Description product代理
 * @Date 2019/11/19 14:49
 * @Created by wangpeng116
 */
@FeignClient(name = "product")
public interface ProductClient {
    @RequestMapping("/server/msg")
    String msg();

    @RequestMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(List<String> productIdList);
}
