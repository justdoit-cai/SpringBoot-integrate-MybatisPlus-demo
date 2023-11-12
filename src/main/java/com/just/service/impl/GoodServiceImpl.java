package com.just.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.just.mapper.GoodMapper;
import com.just.mapper.OrderMapper;
import com.just.pojo.Good;
import com.just.pojo.Order;
import com.just.service.GoodService;
import com.just.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements GoodService {
}
