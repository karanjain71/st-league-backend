package com.stocks.configs;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "com.stocks.db1.repositories"
//    entityManagerFactoryRef = "entityManagerFactory1",
//    transactionManagerRef = "transactionManager1"

)
public class Db1Config {

	@Autowired
    private Environment env;
    
//    @Bean
//    @Primary
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory1() {
//    	
//    	System.out.println("DB1 ENTITY MANAGER");
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource1());
//        em.setPackagesToScan(
//          new String[] { "com.stocks.db1.entities" });
//
//        HibernateJpaVendorAdapter vendorAdapter
//          = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto",
//          env.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect",
//          env.getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }

    @Primary
    @Bean
    public DataSource dataSource1() {
 
    	System.out.println("DB1 DATA SOURCE");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(
          env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.db1.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.db1.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.db1.datasource.password"));

        return dataSource;
    }

//    @Primary
//    @Bean
//    public PlatformTransactionManager transactionManager1() {
// 
//    	System.out.println("DB1 TRANSACTION MANAGER");
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//        		entityManagerFactory1().getObject());
//        return transactionManager;
//    }

}
