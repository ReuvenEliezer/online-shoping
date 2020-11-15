package com.entities;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatusEnum {

    Pending(0),
    Processing(1),
    Approved(2),
    InTransit(3),
    Delivered(4),
    PickupAvailable(5),
    Returned(6);

    private final int value;

    OrderStatusEnum(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static final Map<Integer, OrderStatusEnum> intToTypeMap = new HashMap<>();

    static {
        for (OrderStatusEnum type : OrderStatusEnum.values()) {
            intToTypeMap.put(type.value, type);
        }
    }

    public static OrderStatusEnum fromInt(int i) {
        return intToTypeMap.get(Integer.valueOf(i));
    }
}
