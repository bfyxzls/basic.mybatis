package com.lind.basic.mybatis.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;

/**
 * 值对象-区域.
 */
@Data
@Builder(toBuilder = true)
public class Address {
  @TableField("city_code")
  private int cityCode;
  @TableField("province_code")
  private int provinceCode;
  @TableField("district_code")
  private int districtCode;
  @TableField("city_name")
  private String cityName;
  @TableField("province_name")
  private String provinceName;
  @TableField("district_name")
  private String districtName;
}