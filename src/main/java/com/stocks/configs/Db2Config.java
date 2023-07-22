package com.stocks.configs;

import static com.mongodb.client.model.Filters.eq;

import javax.sql.DataSource;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


@Configuration
@EnableTransactionManagement
@EnableMongoRepositories(basePackages = "com.stocks.db2.repositories")
public class Db2Config {
	
	@Autowired
    private Environment env;
    
//    @Bean
//    @Primary
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory2() {
//        LocalContainerEntityManagerFactoryBean em
//          = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource2());
//        em.setPackagesToScan(
//          new String[] { "com.stocks.db2.entities" });
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

    @Bean
    public DataSource dataSource2() {
    	System.out.println("coming here for configs");
        DriverManagerDataSource dataSource
          = new DriverManagerDataSource();
        System.out.println(env.getProperty("spring.db2.datasource.uri") + "printing here man");
        dataSource.setUrl(env.getProperty("spring.db2.datasource.uri"));
//        dataSource.setUsername(env.getProperty("spring.db1.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.db1.datasource.password"));

        return dataSource;
    }
//
//    @Primary
//    @Bean
//    public PlatformTransactionManager transactionManager2() {
// 
//        JpaTransactionManager transactionManager
//          = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//        		entityManagerFactory2().getObject());
//        return transactionManager;
//    }

    @Bean
    public MongoClient mongoClient() {
    		System.out.println("coming here buddy for connection");
//        	MongoClient mongo = new MongoClient( "localhost" , 27017 );
        	MongoClient mongo = MongoClients.create("mongodb://0.0.0.0:27017/stock_league_api");
        	MongoDatabase database = mongo.getDatabase("stock_league_api");
//        	database.drop();
//        	System.out.println(+ " here");
        	MongoCollection<Document> collection = database.getCollection("stock_ticker");
        	System.out.println(collection.countDocuments());
        	Document doc = collection.find(eq("title", "Karan Jain")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
    	return mongo;
    	
    	
    }
	@Primary
    @Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "spring.db2.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
	
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
