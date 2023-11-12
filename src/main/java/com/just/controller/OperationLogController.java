package com.just.controller;

import com.just.pojo.OperationLog;
import com.just.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
public class OperationLogController {
    @Autowired
    private OperationLogService operationLogService;
    @GetMapping("/")
    public List<OperationLog> getAllLog() {
        return operationLogService.list();
    }
}
