package com.just.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.just.pojo.Good;
import com.just.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodMapper extends BaseMapper<Good> {
    @Select("select * from tb_good where shop_id = #{shopId}")
    public List<Good> selectAllGoodByShopId(Integer shopId);

}
