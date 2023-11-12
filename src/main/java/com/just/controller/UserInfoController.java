package com.just.controller;

import com.just.pojo.UserInfo;
import com.just.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @GetMapping("/")
    public List<UserInfo> selectAllUserInfo() {
        return userInfoService.list();
    }
    @GetMapping("/{id}")
    public UserInfo selectUserInfoById(@PathVariable Integer id) {
        return userInfoService.getById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUserInfoById(@PathVariable("id") Integer id) {
        return userInfoService.removeById(id);
    }
    @PostMapping("/")
    public boolean addUserInfo(@RequestBody UserInfo userInfo) {
        return userInfoService.save(userInfo);
    }
    @PutMapping("/")
    public boolean updateUserInfo(@RequestBody UserInfo userInfo) {
        return userInfoService.updateById(userInfo);
    }
}
