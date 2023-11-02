// package com.cbfacademy.apiassessment;

// import java.util.Arrays;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
// import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
// import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

// import com.mongodb.client.MongoClient;
// import com.mongodb.client.MongoClients;
// import com.mongodb.MongoClientSettings;
// import com.mongodb.MongoCredential;
// import com.mongodb.ServerAddress;

// @Configuration
// @EnableReactiveMongoRepositories
// // @EnableMongoRepositories //(basePackages = "com.cbfacademy.apiassessment") // Replace with your repository package
// public class MongoConfig extends AbstractMongoClientConfiguration {

//     @Override
//     protected String getDatabaseName() {
//         return "e-store";
//     }

   
//     // @Override
//     // public MongoClient mongoClient() {
//     //     // Replace with your MongoDB server configuration
//     //     ServerAddress serverAddress = new ServerAddress("localhost", 27017);
//     //     MongoCredential credential = MongoCredential.createCredential("yourUsername", "yourDatabase", "yourPassword".toCharArray());

//     //     MongoClientSettings settings = MongoClientSettings.builder()
//     //             .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(serverAddress)))
//     //             .credential(credential)
//     //             .build();

//     //     return com.mongodb.client.MongoClients.create(settings);
//     // }

    
//   // @Override
//   // public MongoClient reactiveMongoClient() {
//   //   return MongoClients.create();
//   // }

//   // @Override
//   // protected String getMappingBasePackage() {
//   //   return "com.oreilly.springdata.mongodb";
//   // }
    
// }
