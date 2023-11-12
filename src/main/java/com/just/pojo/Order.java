package com.just.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
public class Order {
    private Integer id;
    private Integer userId;
    private Integer goodId;
    private Long orderTime;
    private Integer number;

    private String username;
    private String goodName;
    private Double goodPrice;
    private Integer shopId;
    private String shopName;

    public Order(Integer userId, Integer goodId, Long orderTime, Integer number) {
        this.userId = userId;
        this.goodId = goodId;
        this.orderTime = orderTime;
        this.number = number;
    }
}
