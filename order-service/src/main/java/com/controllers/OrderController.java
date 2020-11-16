package com.controllers;

import com.entities.Order;
import com.entities.OrderStatusEnum;
import com.repositories.OrderDao;
import com.services.OrderService;
import com.utils.WsAddressConstants;
import com.viewmodel.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(WsAddressConstants.orderLogicUrl)
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "createOrder")
    public Order createOrder(@RequestBody OrderViewModel orderViewModel) {
        Order order = new Order(orderViewModel.getUserId());
        order.setProductIds(orderViewModel.getProductIds());
        OrderStatusEnum orderStatusEnum = orderService.calcStatus(order.getUserId());
        order.setStatusEnumId(orderStatusEnum);
        return orderDao.save(order);
    }

    @GetMapping(value = "getAllByUserId/{userId}")
    public List<Order> getAllByUserId(@PathVariable Long userId) {
        return orderDao.getByUserId(userId);
    }
}
