package com.just.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.just.pojo.Good;
import com.just.pojo.Order;
import com.just.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper extends BaseMapper<Shop> {

}
