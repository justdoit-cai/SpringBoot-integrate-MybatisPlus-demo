package com.just.controller;

import com.just.pojo.Good;
import com.just.pojo.User;
import com.just.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodService goodService;
    @GetMapping("/")
    public List<Good> selectAllGood() {
        return goodService.list();
    }
    @GetMapping("/{id}")
    public Good selectGoodById(@PathVariable Integer id) {
        return goodService.getById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteGoodById(@PathVariable("id") Integer id) {
        return goodService.removeById(id);
    }
    @PostMapping("/")
    public boolean addGood(@RequestBody Good good) {
        return goodService.save(good);
    }
    @PutMapping("/")
    public boolean updateGood(@RequestBody Good good) {
        return goodService.updateById(good);
    }
}
