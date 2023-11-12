package com.just.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.just.mapper.ShopMapper;
import com.just.mapper.UserInfoMapper;
import com.just.pojo.Shop;
import com.just.pojo.UserInfo;
import com.just.service.ShopService;
import com.just.service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
}
