package com.just.controller;

import com.just.pojo.Order;
import com.just.pojo.User;
import com.just.pojo.UserInfo;
import com.just.service.OrderService;
import com.just.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;
    @GetMapping("/")
    public List<User> getAllUser() {
        return userService.list();
    }
    @GetMapping("/safe")
    public List<User> getAllUserWithoutPass() {
        return userService.selectAllUserWithoutPass();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }
    @DeleteMapping("/{id}")
    public boolean deleteUserById(@PathVariable("id") Integer id) {
        return userService.removeById(id);
    }
    @PostMapping("/")
    public boolean addUser(@RequestBody User user) {
        user.setId(null);
        user.setBalance(null);
        return userService.save(user);
    }
    @PutMapping("/")
    public boolean updateUser(@RequestBody User user) {
        return userService.updateById(user);
    }

    @PostMapping("/buy/{userId}/{goodId}/{number}")
    public boolean buyGood(@PathVariable Integer userId, @PathVariable Integer goodId, @PathVariable Integer number) {
        return userService.buyGood(userId, goodId, number);
    }
    @GetMapping("/order/{id}")
    public List<Order> getAllOrder(@PathVariable Integer id) {
        return orderService.selectAllOrderByUserId(id);
    }
}
