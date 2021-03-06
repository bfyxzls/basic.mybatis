package com.lind.basic.mybatis.entity;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo extends EntityBase {
  private String name;
  private String email;
  /**
   * 目前没有找到mybatis支持复合字段的方法.
   */
  private Address address;

  @Builder(toBuilder = true)
  public UserInfo(Integer isDelete, Long id, Timestamp createdOn, Timestamp updatedOn, String name, String email, Address address) {
    super(isDelete, id, createdOn, updatedOn);
    this.name = name;
    this.email = email;
    this.address = address;
  }
}
