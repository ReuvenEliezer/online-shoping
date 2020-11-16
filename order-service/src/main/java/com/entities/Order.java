package com.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime orderDateTime;

    @Column(name = "StatusEnumId")
    private Integer statusEnumId;

    @Column(nullable = false, name = "user_id")
    private Long userId;

    @ElementCollection(targetClass = Long.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "productId")
    private Set<Long> productIds = new HashSet<>();

    protected Order() {
    }

    public Order(Long userId) {
        this.userId = userId;
        this.setOrderDateTime(LocalDateTime.now());
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(Set<Long> productIds) {
        this.productIds = productIds;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDateTime=" + orderDateTime +
                ", statusEnumId=" + statusEnumId +
                ", userId=" + userId +
                ", productIds=" + productIds +
                '}';
    }
}
