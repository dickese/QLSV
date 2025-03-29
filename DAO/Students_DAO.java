package Students;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
public class Students_DAO {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<org.bson.Document> collection;

    public Students_DAO(String connectionString, String dbName) {
        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase(dbName);
        collection = database.getCollection("students");
    }
    public void ThemSV(Student student) {
        Document doc = new Document("_id", student.getId())
                .append("name", student.getName())
                .append("dob", student.getDob())
                .append("classId", student.getClassId())
                .append("email", student.getEmail());
        collection.insertOne((org.bson.Document) doc);
    }
    public void CapNhatSV(Student student) {
        Document filter = new Document("_id", student.getId());
        Document update = new Document("$set", new Document("name", student.getName())
                .append("dob", student.getDob())
                .append("classId", student.getClassId())
                .append("email", student.getEmail()));
        collection.updateMany(filter, update);
    }
    public void XoaSV(String id) {
        collection.deleteOne((Bson) new Document("_id", id));
    }
    public Student TimSVTheoMaSV(String id) {
        Bson filter = Filters.eq("_id", id);
        Document doc = collection.find(filter).first();

        if (doc != null) {
            return new Student(
                doc.getString("_id"),
                doc.getString("name"),
                doc.getString("dob"),
                doc.getString("classId"),
                doc.getString("email")
            );
        }
        return null; 
    }
    public void closeConnection() {
        mongoClient.close();
    }
}
