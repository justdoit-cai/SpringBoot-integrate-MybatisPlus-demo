package com.just.controller;

import com.just.pojo.Good;
import com.just.pojo.Order;
import com.just.pojo.Shop;
import com.just.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @GetMapping("/")
    public List<Shop> selectAllShop() {
        return shopService.list();
    }
    @GetMapping("/{id}")
    public Shop selectShopById(@PathVariable Integer id) {
        return shopService.getById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteShopById(@PathVariable("id") Integer id) {
        return shopService.removeById(id);
    }
    @PostMapping("/")
    public boolean addShop(@RequestBody Shop shop) {
        return shopService.save(shop);
    }
    @PutMapping("/")
    public boolean updateShop(@RequestBody Shop shop) {
        return shopService.updateById(shop);
    }
    @GetMapping("/good/{id}")
    public List<Good> selectOwnGood(@PathVariable Integer id){
        return shopService.getOwnGoodList(id);
    }
    @GetMapping("/order/{id}")
    public List<Order> selectOwnOrder(@PathVariable Integer id){
        return shopService.getOwnOrderList(id);
    }
}
