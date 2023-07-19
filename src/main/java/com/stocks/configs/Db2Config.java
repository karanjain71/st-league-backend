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

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "com.stocks.db2.repositories", 
    entityManagerFactoryRef = "entityManagerFactory2",
    transactionManagerRef = "transactionManager2"
)
public class Db2Config {
	
	@Autowired
    private Environment env;
    
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory2() {
        LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource2());
        em.setPackagesToScan(
          new String[] { "com.stocks.db2.entities" });

        HibernateJpaVendorAdapter vendorAdapter
          = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
          env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
          env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean
    public DataSource dataSource2() {
 
        DriverManagerDataSource dataSource
          = new DriverManagerDataSource();
//        dataSource.setDriverClassName(
//          env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.db2.datasource.uri"));
//        dataSource.setUsername(env.getProperty("spring.db1.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.db1.datasource.password"));

        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager transactionManager2() {
 
        JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
        		entityManagerFactory2().getObject());
        return transactionManager;
    }

    public @Bean MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }
//	@Primary
//    @Bean(name = "dataSource2")
//	@ConfigurationProperties(prefix = "spring.db2.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//	
//	@Primary
//    @Bean(name = "entityManagerFactory2")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
//			@Qualifier("dataSource2") DataSource dataSource) {
//        HashMap<String, Object>properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", "update");
//
//        return builder.dataSource(dataSource)
//        		.properties(properties)
//        		.packages("com.stocks.db2.entities")
//        		.persistenceUnit("db2")
//        		.build();
//    }
//	
//	@Primary
//    @Bean(name = "transactionManager2")
//    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory2") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//        
//    }
}
