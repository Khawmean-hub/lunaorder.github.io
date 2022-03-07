package com.kosign.luna.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

   @Bean
   public DataSource myPostgresDb() {
       DataSourceBuilder dataSource = DataSourceBuilder.create();
       dataSource.driverClassName("org.postgresql.Driver");
       dataSource.url("jdbc:postgresql://ec2-3-226-59-11.compute-1.amazonaws.com:5432/da4lct4b4m7tke");
       dataSource.username("xiyejchdaukcvk");
       dataSource.password("92d016d67835e21f6a1b71b026fca74405a27dbcce306e1ee0fef55f6f80144d");
       return dataSource.build();
   }

    // @Bean
    // public DataSource myPostgresDb() {
    //     DataSourceBuilder dataSource = DataSourceBuilder.create();
    //     dataSource.driverClassName("org.postgresql.Driver");
    //     dataSource.url("jdbc:postgresql://postgres:5432/register_8th");
    //     dataSource.username("register");
    //     dataSource.password("register!@#");
    //     return dataSource.build();
    // }

}
