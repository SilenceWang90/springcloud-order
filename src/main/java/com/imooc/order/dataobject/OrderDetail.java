package com.imooc.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "ORDER_DETAIL")
public class OrderDetail {
    @Id
    private String detailId;
    //订单id
    private String orderid;
    //商品id
    private String productId;
    //商品名称
    private Integer productName;
    //单价
    private BigDecimal productPrice;
    //商品数量
    private Integer productQuantity;
    //小图
    private String productIcon;

    private Date createTime;
    private Date updateTime;
}
