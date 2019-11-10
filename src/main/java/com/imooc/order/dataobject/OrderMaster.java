package com.imooc.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "ORDER_MASTER")
public class OrderMaster {
    @Id
    private String orderId;
    //买家名字
    private String buyerName;
    //买家手机号
    private String buyerPhone;
    //买家地址
    private String buyerAddress;
    //买家微信
    private String buyerOpenid;
    //订单总额
    private BigDecimal orderAmount;
    //订单状态：默认为0新下单
    private Integer orderStatus;
    //支付状态：默认为0未支付
    private Integer payStatus;

    private Date createTime;
    private Date updateTime;
}
