// import java.io.FileInputStream;
// import java.io.IOException;
// import java.util.Properties;
// import com.mongodb.ConnectionString;
// import com.mongodb.MongoClientSettings;
// import com.mongodb.ServerApi;
// import com.mongodb.ServerApiVersion;
// import com.mongodb.client.MongoClient;
// import com.mongodb.client.MongoClients;
// import com.mongodb.client.MongoDatabase;

// public class MongoClientConnectionExample {
//     public static void main(String[] args) {
//         // Location of your config.properties file
//         String configFilePath = "src/main/resources/config.properties";

//         // Read username and password from the properties file
//         String username;
//         String password;
        
//         try (FileInputStream propsInput = new FileInputStream(configFilePath)) {
//             Properties prop = new Properties();
//             prop.load(propsInput);
//             username = prop.getProperty("username");
//             password = prop.getProperty("password");
//         } catch (IOException e) {
//             e.printStackTrace();
//             return;
//         }

//         // Construct the MongoDB connection string using username and password
//         String uri = String.format("mongodb+srv://%s:%s@watchlist.gknfv05.mongodb.net/?retryWrites=true&w=majority", username, password);

//         // Construct a ServerApi instance using the ServerApi.builder() method
//         ServerApi serverApi = ServerApi.builder()
//                 .version(ServerApiVersion.V1)
//                 .build();

//         MongoClientSettings settings = MongoClientSettings.builder()
//                 .applyConnectionString(new ConnectionString(uri))
//                 .serverApi(serverApi)
//                 .build();

//         // Create a new client and connect to the server
//         try (MongoClient mongoClient = MongoClients.create(settings)) {
//             MongoDatabase database = mongoClient.getDatabase("admin");
//             try {
//                 // Send a ping to confirm a successful connection
//                 Bson command = new BsonDocument("ping", new BsonInt64(1));
//                 database.runCommand(command);
//                 System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }
