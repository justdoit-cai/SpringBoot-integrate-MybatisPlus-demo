package com.just.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.just.pojo.Good;
import com.just.pojo.Order;
import com.just.pojo.Shop;

import java.util.List;

public interface ShopService extends IService<Shop> {
    public List<Good> getOwnGoodList(Integer shopId);
    public List<Order> getOwnOrderList(Integer shopId);
}
