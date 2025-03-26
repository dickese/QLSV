package QLSV.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Subject_DAO {
    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public Subject_DAO(String connect, String dbName){
        mongoClient = MongoClient.create(connect);
        database = mongoClient.getDatabase(dbName);
        collection = database.getCollection("subject");

    }
    public void addSubject(Subject subject){
        Document doc = new Document("_id",subject.getId())
        .append("name",subject.getName())
        .append("credits", subject.getCredits())
        .append("faculty",subject.getFaculty());
        collection.insertOne(doc);
    }
    public void updateSubject(String id,Subject newSubject){
        collection.updateOne(Filters.eq("_id",id),new Document("$set",new Document("name",newSubject.getName())
        .append("credist", newSubject.getCredist())
        .append("faculty", newSubject.getFaculty())));
    }
    public void deleteSubject(String id){
        collection.deleteOne(Filters.eq("_id",id));
    }
    public List<Subject> getListSubject(){
        List<Subject> subjects = new ArrayList<>();
        for(Document doc : collection.find()){
            subjects.add(new Subject(doc.getString("_id"),
            doc.getString("name"),
            doc.getInteger("credist"),
            doc.getString("faculty")
            ));
        }
    }
    public void close() {
        mongoClient.close();
    }
}
