package com.stocks.configs;

import java.util.HashMap;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
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
)
public class Db1Config {

	@Autowired
    private Environment env;
    
//    @Bean
//    @Primary
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory1() {
//        LocalContainerEntityManagerFactoryBean em
//          = new LocalContainerEntityManagerFactoryBean();
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
 
        DriverManagerDataSource dataSource
          = new DriverManagerDataSource();
        dataSource.setDriverClassName(
          env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.db1.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.db1.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.db1.datasource.password"));

        return dataSource;
    }
//
//    @Primary
//    @Bean
//    public PlatformTransactionManager transactionManager1() {
// 
//        JpaTransactionManager transactionManager
//          = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//        		entityManagerFactory1().getObject());
//        return transactionManager;
//    }
//	@Primary
//    @Bean(name = "dataSource1")
//	@ConfigurationProperties(prefix = "spring.db1.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//	
//	@Primary
//    @Bean(name = "entityManagerFactory1")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
//			@Qualifier("dataSource1") DataSource dataSource) {
//        HashMap<String, Object>properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", "update");
//
//        return builder.dataSource(dataSource)
//        		.properties(properties)
//        		.packages("com.stocks.db1.entities")
//        		.persistenceUnit("db1")
//        		.build();
//    }
//	
//	@Primary
//    @Bean(name = "transactionManager1")
//    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory1") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//        
////    }
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//    Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
//           
//        return properties;
//    }
}
