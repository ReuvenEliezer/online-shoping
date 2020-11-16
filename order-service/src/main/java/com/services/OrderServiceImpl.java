package com.services;

import com.entities.OrderStatusEnum;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderStatusEnum calcStatus(long orderId) {
        //TODO impl
        return OrderStatusEnum.Approved;
    }
}
