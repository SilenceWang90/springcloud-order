package com.imooc.order.dto;

import lombok.Data;

/**
 * @Classname CartDTO
 * @Description 订单中商品信息
 * @Date 2019/11/20 11:24
 * @Created by wangpeng116
 */
@Data
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品数量
     */
    private Integer productQuantity;
}
