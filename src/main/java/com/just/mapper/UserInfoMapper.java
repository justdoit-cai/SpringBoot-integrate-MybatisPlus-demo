package com.just.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.just.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
