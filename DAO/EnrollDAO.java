package DAO;

import java.sql.Connection;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import DB.Connect;
import Enroll.Enroll;

public class EnrollDAO {
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	public EnrollDAO(String connectionString, String dbName) {
		mongoClient = MongoClients.create(connectionString);
		database = mongoClient.getDatabase(dbName);
		collection = database.getCollection("nhaHang");
	}
		
	public int insertOne(Enroll e)
	{
		Document doc = new Document("_id",e.getEnroll_id().toString());
		doc.append("student_id",e.getStudent_id().toString());
		doc.append("subject_id",e.getSubject_id().toString());
		doc.append("semester",e.getSemester().toString());
		doc.append("status",e.getStatus().toString());
		collection.insertOne(doc);
		System.out.println("Insert succes");
		return 1;
	}
	public int UpdateOne(Enroll e)
	{
		collection.updateOne(Filters.eq("_id",e.getEnroll_id().toString()),Updates.combine(
				Updates.set("student_id",e.getStudent_id().toString()),
				Updates.set("subject_id",e.getStudent_id().toString()),
				Updates.set("semester",e.getSemester().toString()),
				Updates.set("status",e.getStatus().toString())
		));
		System.out.println("Update succes");
		return 1;
	}
	public int delete(Enroll e)
	{
		collection.deleteOne(Filters.eq("_id",e.getEnroll_id().toString()));
		System.out.println("Delete succes");
		return 1;
	}
}
