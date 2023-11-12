package com.just.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.just.mapper.GoodMapper;
import com.just.mapper.OrderMapper;
import com.just.mapper.ShopMapper;
import com.just.pojo.Good;
import com.just.pojo.Order;
import com.just.pojo.Shop;
import com.just.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService {
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private GoodMapper goodMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Good> getOwnGoodList(Integer shopId) {
        return goodMapper.selectAllGoodByShopId(shopId);
    }

    @Override
    public List<Order> getOwnOrderList(Integer shopId) {
        return orderMapper.selectAllOrderByShopId(shopId);
    }
}
