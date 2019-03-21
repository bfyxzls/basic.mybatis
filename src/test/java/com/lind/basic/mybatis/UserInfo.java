package com.lind.basic.mybatis;

import com.lind.basic.mybatis.entity.EntityBase;
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
   * init.
   */
  @Builder(toBuilder = true)
  public UserInfo(Integer isDelete, Long id, Timestamp createdOn,
                  Timestamp updatedOn, String name, String email) {
    super(isDelete, id, createdOn, updatedOn);
    this.name = name;
    this.email = email;
  }
}
