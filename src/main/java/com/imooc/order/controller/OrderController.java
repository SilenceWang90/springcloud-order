package com.imooc.order.controller;

import com.google.common.collect.Maps;
import com.imooc.order.VO.ResultVO;
import com.imooc.order.converter.Orderform2OrderDTOConverter;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.ResultEnum;
import com.imooc.order.exception.OrderException;
import com.imooc.order.form.OrderForm;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 1、参数校验
     * 2、查询商品信息（调用商品服务）
     * 3、计算总价
     * 4、扣库存（调用商品服务）
     * 5、订单入库
     *
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @RequestMapping("/create")
    public ResultVO<Map<String, String>> create(@RequestBody @Valid OrderForm orderForm, BindingResult bindingResult) {
        //1、参数校验
        if (bindingResult.hasErrors()) {
            log.error("创建订单参数不正确，orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = Orderform2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("创建订单购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        //2、保存订单
        OrderDTO result = orderService.create(orderDTO);
        Map<String, String> map = Maps.newHashMap();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }



}
