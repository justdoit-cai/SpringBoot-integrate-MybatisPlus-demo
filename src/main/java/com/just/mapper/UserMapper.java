package com.just.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.just.pojo.Order;
import com.just.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Update("update tb_user set balance = #{balance} where id = #{userId}")
    public int updateBalance(Integer userId, Double balance);
    @Select("select * from tb_user_view")
    public List<User> selectAllUserWithoutPass();
}
