package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class Classes_DAO {
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	public Classes_DAO(String connectionString, String dbName){
		mongoClient = MongoClients.create(connectionString);
		database = mongoClient.getDatabase(dbName);
		collection = database.getCollection("classes");
	}
	public void addClass(Classes classes) {
		Document doc = new Document("_id",classes.getId())
				 .append("name", classes.getName())
	                .append("falcuty", classes.getFalcuty())
	                .append("academic_year", classes.getAcademic_year())
	                .append("teacher_id", classes.getTeacher_id());
	        collection.insertOne(doc);
		
	}
	
    public void updateClass(Classes classes) {
        Document filter = new Document("_id", classes.getId());
        Document update = new Document("$set", new Document("name", classes.getName())
                .append("falcuty", classes.getFalcuty())
                .append("academic_year", classes.getAcademic_year())
                .append("teacher_id", classes.getTeacher_id()));
        collection.updateOne(filter, update);
    }
	
	public void deleteClass(String id) {
		collection.deleteOne(new Document("_id", id));
	}
	
	public void closeConnection() {
        mongoClient.close();
    }
}
