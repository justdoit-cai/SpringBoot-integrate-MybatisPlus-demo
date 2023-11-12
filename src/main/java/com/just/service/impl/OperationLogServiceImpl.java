package com.just.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.just.mapper.OperationLogMapper;
import com.just.mapper.OrderMapper;
import com.just.pojo.OperationLog;
import com.just.pojo.Order;
import com.just.service.OperationLogService;
import com.just.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {
}
