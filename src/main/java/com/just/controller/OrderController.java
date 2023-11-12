package com.just.controller;

import com.just.pojo.Order;
import com.just.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/")
    public List<Order> selectAllOrder() {
        return orderService.selectAllOrder();
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.selectOrderById(id);
    }
    @DeleteMapping("/{id}")
    public boolean deleteOrderById(@PathVariable Integer id) {
        return orderService.removeById(id);
    }
}
