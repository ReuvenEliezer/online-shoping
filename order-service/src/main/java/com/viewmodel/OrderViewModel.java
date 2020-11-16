package com.viewmodel;

import java.util.HashSet;
import java.util.Set;

public class OrderViewModel {

    private Long userId;
    private Set<Long> productIds = new HashSet<>();

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
}
