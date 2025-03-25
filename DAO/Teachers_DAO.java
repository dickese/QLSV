package teacher;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Teachers_DAO {
	
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	public Teachers_DAO(String connectionString, String dbName) {
		mongoClient = MongoClients.create(connectionString);
		database = mongoClient.getDatabase(dbName);
		collection = database.getCollection("tearchers");
	}
	
	public void addTearchers(Teachers teachers) {
		Document doc = new Document("_id",teachers.getId())
				 .append("name", teachers.getName())
	                .append("email", teachers.getEmail())
	                .append("phone", teachers.getPhone())
	                .append("faculty", teachers.getFaculty());
	        collection.insertOne(doc);
		
	}
	
    public List<Teachers> getAllTeachers() {
        List<Teachers> teacherList = new ArrayList<>();
        for (Document doc : collection.find()) {
            teacherList.add(new Teachers(
                doc.getString("_id"),
                doc.getString("name"),
                doc.getString("email"),
                doc.getString("phone"),
                doc.getString("faculty")
            ));
        }
        return teacherList;
    }
	
    public void updateTeacher(Teachers teachers) {
        Document filter = new Document("_id", teachers.getId());
        Document update = new Document("$set", new Document("name", teachers.getName())
                .append("email", teachers.getEmail())
                .append("phone", teachers.getPhone())
                .append("faculty", teachers.getFaculty()));
        collection.updateOne(filter, update);
    }
	
	public void deleteTearcher(String id) {
		collection.deleteOne(new Document("_id", id));
	}
	
	public void closeConnection() {
        mongoClient.close();
    }
}
