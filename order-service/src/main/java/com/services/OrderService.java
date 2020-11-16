package com.services;

import com.entities.OrderStatusEnum;

public interface OrderService {

    OrderStatusEnum calcStatus(long orderId);
}
