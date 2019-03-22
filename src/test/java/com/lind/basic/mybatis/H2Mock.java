package com.lind.basic.mybatis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactoryBean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ActiveProfiles;

/**
 * H2数据库初始化.
 */
@Configuration
@ActiveProfiles("test")
public class H2Mock {
  @Value("${h2.dbName:test}")
  String dbName;
  @Value("${h2.dbSchema:db/schema.sql}")
  String dbSchema;

  @Bean
  EmbeddedDatabaseFactoryBean dataSource() {
    EmbeddedDatabaseFactoryBean factoryBean = new EmbeddedDatabaseFactoryBean();
    factoryBean.setDatabaseType(EmbeddedDatabaseType.H2);
    factoryBean.setDatabaseName(dbName);
    factoryBean.setDatabasePopulator(new ResourceDatabasePopulator(
        new ClassPathResource(dbSchema)
    ));

    return factoryBean;

  }
}
