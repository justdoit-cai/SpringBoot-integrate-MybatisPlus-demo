package com.just.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.just.pojo.Order;

import java.util.List;

public interface OrderService extends IService<Order> {
    public List<Order> selectAllOrder();
    public Order selectOrderById(Integer id);
    public List<Order> selectAllOrderByUserId(Integer userId);
    public List<Order> selectAllOrderByShopId(Integer shopId);
}
