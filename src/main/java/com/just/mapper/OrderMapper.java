package com.just.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.just.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * select o.id,o.user_id,o.good_id,o.order_time,o.number,
     * u.username,
     * g.description as good_description,g.price,
     * s.id,s.name
     * from tb_order o
     * left join tb_user u on o.user_id=u.id
     * left join tb_good g on o.good_id=g.id
     * left join tb_shop s on g.shop_id=s.id;
     */
    @Select("select o.id,o.user_id,o.good_id,o.order_time,o.number," +
            "u.username,g.name as good_name, g.price as good_price," +
            "s.id,s.name " +
            "from tb_order o " +
            "left join tb_user u on o.user_id=u.id " +
            "left join tb_good g on o.good_id=g.id " +
            "left join tb_shop s on g.shop_id=s.id;")
    public List<Order> selectAllOrder();

    @Select("select o.id,o.user_id,o.good_id,o.order_time,o.number," +
            "u.username, g.name as good_name,g.price as good_price," +
            "s.id,s.name " +
            "from tb_order o " +
            "left join tb_user u on o.user_id=u.id " +
            "left join tb_good g on o.good_id=g.id " +
            "left join tb_shop s on g.shop_id=s.id " +
            "where o.id=#{id};")
    public Order selectOrderById(Integer id);

    @Select("select o.id,o.user_id,o.good_id,o.order_time,o.number," +
            "u.username,g.name as good_name,g.price as good_price," +
            "s.id,s.name " +
            "from tb_order o " +
            "left join tb_user u on o.user_id=u.id " +
            "left join tb_good g on o.good_id=g.id " +
            "left join tb_shop s on g.shop_id=s.id " +
            "where u.id=#{userId};")
    public List<Order> selectAllOrderByUserId(Integer userId);
    @Select("select o.id,o.user_id,o.good_id,o.order_time,o.number," +
            "u.username,g.name as good_name,g.price as good_price," +
            "s.id,s.name " +
            "from tb_order o " +
            "left join tb_user u on o.user_id=u.id " +
            "left join tb_good g on o.good_id=g.id " +
            "left join tb_shop s on g.shop_id=s.id " +
            "where s.id=#{shopId};")
    public List<Order> selectAllOrderByShopId(Integer shopId);
}
