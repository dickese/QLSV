package temp;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Accounts_DAO {
	
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	public Accounts_DAO(String connectionString, String dbName) {
		mongoClient = MongoClients.create(connectionString);
		database = mongoClient.getDatabase(dbName);
		collection = database.getCollection("accounts");
	}
	
	public void addAccounts(Accounts accounts) {
		Document doc = new Document()
			.append("username", accounts.getUsername())
			.append("password", accounts.getPassword())
			.append("role", accounts.getRole());
		collection.insertOne(doc);
		
	}
	
	public List<Accounts> getAllAccounts(){
		List<Accounts> accList = new ArrayList<>();
		for(Document doc:collection.find()) {
			accList.add(new Accounts(
				doc.getObjectId("_id").toString(),
				doc.getString("username"),
				doc.getString("password"),
				Integer.parseInt(doc.getString("role"))
			));
		}
		return accList;
	}
	
	public void updateAccounts(String id, String username, String password, int role) {
		collection.updateOne(Filters.eq("_id", id),
			Updates.combine(
					Updates.set("username", username),
					 Updates.set("password", password),
                     Updates.set("role", role)
			));
	}
	
	public void deleteAccounts(String id) {
		collection.deleteOne(Filters.eq("_id", id));
	}
	
	public void closeConnection() {
        mongoClient.close();
    }

}
