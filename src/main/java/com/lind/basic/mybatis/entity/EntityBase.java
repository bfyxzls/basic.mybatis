package com.lind.basic.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 实体基类.
 * 子类使用@Builder时需要重写全参构造方法.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class EntityBase {
  /**
   * 逻辑删除.
   */
  @TableLogic
  protected Integer isDelete;
  /**
   * 主键.
   */
  @TableId(value = "id", type = IdType.ID_WORKER)
  protected Long id;
  /**
   * 添加时间自动填充.
   */
  @CreateTimeFunction
  protected Timestamp createdOn;
  /**
   * 更新时间自动填充.
   */
  @UpdatedTimeFunction
  protected Timestamp updatedOn;
}
