package com.just.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.just.mapper.GoodMapper;
import com.just.mapper.OrderMapper;
import com.just.mapper.UserMapper;
import com.just.pojo.Good;
import com.just.pojo.Order;
import com.just.pojo.User;
import com.just.pojo.UserInfo;
import com.just.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodMapper goodMapper;

    @Transactional
    @Override
    public boolean buyGood(Integer userId, Integer goodId, Integer number) {
        System.out.println("userId = " + userId);
        System.out.println("goodId = " + goodId);
        System.out.println("number = " + number);
        Good good = goodMapper.selectById(goodId);
        User user = userMapper.selectById(userId);
        double balance = user.getBalance() - good.getPrice() * number;
        if (balance < 0) {
            System.out.println("余额不足");
            return false;
        } else {
            long now = new Date().getTime() / 1000;
            userMapper.updateBalance(userId, balance);
            orderMapper.insert(new Order(userId, goodId, now, number));
            System.out.println("购买成功");
            System.out.println("balance = " + balance);
        }
        return true;
    }

    public List<User> selectAllUserWithoutPass() {
        return userMapper.selectAllUserWithoutPass();
    }
}
