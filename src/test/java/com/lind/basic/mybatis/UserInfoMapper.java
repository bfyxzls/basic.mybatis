package com.lind.basic.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserInfoMapper extends BaseMapper<UserInfo> {

  @Select("select * from user_info where username=@username")
  UserInfo findByUsername(@Param("username") String username);
}
