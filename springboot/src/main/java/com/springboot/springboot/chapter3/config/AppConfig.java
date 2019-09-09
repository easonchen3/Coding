package com.springboot.springboot.chapter3.config;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-10 13:26
 * @Version 1.0
 */
/*@Configuration
@ComponentScan(basePackages = "com.springboot.springboot.chapter3.*",lazyInit = true,
        excludeFilters = {@ComponentScan.Filter(classes = {Service.class})})*/
public class AppConfig {

    /*@Bean(name = "dataSource")
    public DataSource getDataSource(){
        Properties properties = new Properties();
        properties.setProperty("driver","com.mysql.jdbc.Driver");
        properties.setProperty("url","jdbc:msql://localhost:3306/chapter3");
        properties.setProperty("username","root");
        properties.setProperty("password","admin");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return  dataSource;
    }*/

}
