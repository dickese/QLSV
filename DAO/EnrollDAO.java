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
	private MongoCollection<Document> col;
	public static EnrollDAO getInstance(){
		return new EnrollDAO();
	}
	
	public int insertOne(Enroll e)
	{
		Connect c = new Connect();
		c.getDatabase();
		col = c.getCollection();
		Document doc = new Document("_id",e.getEnroll_id().toString());
		doc.append("student_id",e.getStudent_id().toString());
		doc.append("subject_id",e.getSubject_id().toString());
		doc.append("semester",e.getSemester().toString());
		doc.append("status",e.getStatus().toString());
		col.insertOne(doc);
		System.out.println("Insert succes");
		return 1;
	}
	public int UpdateOne(Enroll e)
	{
		Connect c = new Connect();
		c.getDatabase();
		col = c.getCollection();
		col.updateOne(Filters.eq("_id",e.getEnroll_id().toString()),Updates.combine(
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
		Connect c = new Connect();
		c.getDatabase();
		col = c.getCollection();
		col.deleteOne(Filters.eq("_id",e.getEnroll_id().toString()));
		System.out.println("Delete succes");
		return 1;
	}
}
