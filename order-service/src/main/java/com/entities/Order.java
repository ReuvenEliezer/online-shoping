package com.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Column
    private LocalDateTime orderDateTime;

    @Column(name = "StatusEnumId")
    private Integer statusEnumId;

    @Column
    private Long userId;

    protected Order() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public OrderStatusEnum getOrderStatusEnum() {
        return OrderStatusEnum.fromInt(statusEnumId);
    }

    public void setStatusEnumId(OrderStatusEnum orderStatusEnum) {
        this.statusEnumId = orderStatusEnum.getValue();
    }


}
