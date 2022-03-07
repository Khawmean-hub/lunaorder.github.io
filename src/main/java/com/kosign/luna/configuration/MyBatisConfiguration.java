// package com.kosign.luna.configuration;

// import org.mybatis.spring.SqlSessionFactoryBean;
// import org.mybatis.spring.annotation.MapperScan;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.datasource.DataSourceTransactionManager;

// import javax.sql.DataSource;

// @Configuration
// @MapperScan("com.kosign.luna.repository")
// public class MyBatisConfiguration {

//     private DataSource dataSource;
//     @Autowired
//     public void setDataSource(DataSource dataSource) {
//         this.dataSource = dataSource;
//     }
//     @Bean(name="transactionManager")
//     public DataSourceTransactionManager dataSourceTransactionManager() {
//         return new DataSourceTransactionManager(dataSource);
//     }
//     @Bean
//     public SqlSessionFactoryBean sqlSessionFactorcyBean() {
//         SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//         sqlSessionFactoryBean.setDataSource(dataSource);
//         return sqlSessionFactoryBean;
//     }


// }
