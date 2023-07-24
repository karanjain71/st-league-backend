package com.stocks.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@Configuration
@EnableTransactionManagement
@EnableMongoRepositories(
    basePackages = "com.stocks.db2.repositories"
)
public class Db2Config {
	
	@Autowired
    private Environment env;
 

    //@Primary
    @Bean
    public DataSource dataSource2() {
 
    	System.out.println("DB2 DATA SOURCE");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring.db2.datasource.uri"));

        return dataSource;
    }


  //@Primary
  @Bean
    public MongoClient mongoClient() {
		System.out.println("DB2 MONGO CLIENT");
    	MongoClient mongo = MongoClients.create("mongodb://127.0.0.1:27017/stock_league_api");
    	MongoDatabase database = mongo.getDatabase("stock_league_api");
    	System.out.println(" ------ "+database.getName());
    	MongoCursor<String> collectionNames = database.listCollectionNames().iterator();
        while (collectionNames.hasNext()) {
            System.out.println("********* - "+collectionNames.next());
        }
    	
        return mongo;
    }	

}
