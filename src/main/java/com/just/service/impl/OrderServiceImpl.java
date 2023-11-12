package com.just.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.just.mapper.OrderMapper;
import com.just.mapper.UserMapper;
import com.just.pojo.Order;
import com.just.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> selectAllOrder() {
        return orderMapper.selectAllOrder();
    }

    public Order selectOrderById(Integer id) {
        return orderMapper.selectOrderById(id);
    }
    @Override
    public List<Order> selectAllOrderByUserId(Integer userId) {
        return orderMapper.selectAllOrderByUserId(userId);
    }

    @Override
    public List<Order> selectAllOrderByShopId(Integer shopId) {
        return orderMapper.selectAllOrderByShopId(shopId);
    }
}
