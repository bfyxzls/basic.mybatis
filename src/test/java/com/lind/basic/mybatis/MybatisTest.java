package com.lind.basic.mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lind.basic.mybatis.entity.Address;
import com.lind.basic.mybatis.entity.UserInfo;
import com.lind.basic.mybatis.entity.UserInfoMapper;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@MapperScan("com.lind.basic.mybatis")
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
  @Autowired
  UserInfoMapper userInfoMapper;

  @Before
  public void init() {
    userInfoMapper.delete(new QueryWrapper<UserInfo>().eq("is_delete", 0));
  }

  @Test
  public void insert() {
    UserInfo userInfo = UserInfo.builder()
        .name("lind")
        .email("test@sina.com")
        .build();
    Assert.assertEquals(1, userInfoMapper.insert(userInfo));
  }

  @Test
  public void selectList() {
    UserInfo userInfo = UserInfo.builder()
        .name("zzl")
        .email("zzl@sina.com")
        .isDelete(0)
        .build();
    userInfoMapper.insert(userInfo);
    Wrapper<UserInfo> queryWrapper = new QueryWrapper<UserInfo>()
        .lambda().eq(UserInfo::getName, "zzl");
    Assert.assertEquals(1, userInfoMapper.selectList(queryWrapper).size());
  }

  @Test
  public void findPage() {
    UserInfo userInfo = UserInfo.builder()
        .name("zzl")
        .email("zzl@sina.com")
        .isDelete(0)
        .build();
    userInfoMapper.insert(userInfo);
    Wrapper<UserInfo> queryWrapper =
        new QueryWrapper<UserInfo>().lambda().eq(UserInfo::getName, "zzl");
    Assert.assertEquals(1, userInfoMapper.selectPage(
        new Page<>(1, 10),
        queryWrapper)
        .getRecords().size());
  }

  @Test
  public void update() throws Exception {
    UserInfo userInfo = UserInfo.builder()
        .name("zzl")
        .email("zzl@sina.com")
        .isDelete(0)
        .build();
    userInfoMapper.insert(userInfo);
    System.out.println("userinfo:" + userInfo.toString());
    TimeUnit.MILLISECONDS.sleep(50);
    UserInfo old = userInfoMapper.selectById(userInfo.getId());
    old = old.toBuilder().email("modify_zzl@sina.com").build();
    userInfoMapper.update(old, new QueryWrapper<UserInfo>().lambda().eq(UserInfo::getName, "zzl"));

    UserInfo userInfoLatest = userInfoMapper.selectOne(
        new QueryWrapper<UserInfo>().lambda().eq(UserInfo::getName, "zzl"));
    Assert.assertEquals("modify_zzl@sina.com", userInfoLatest.getEmail());
    System.out.println(userInfoLatest.toString());
  }
}
