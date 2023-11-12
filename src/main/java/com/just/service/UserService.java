package com.just.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.just.pojo.Order;
import com.just.pojo.User;
import com.just.pojo.UserInfo;

import java.util.List;

public interface UserService extends IService<User> {
    public boolean buyGood(Integer userId, Integer goodId, Integer number);
    public List<User> selectAllUserWithoutPass();
}
