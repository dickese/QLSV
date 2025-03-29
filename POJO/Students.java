package QLSV.POJO;

public class Students {
    private String id;
    private String name;
    private String dob;
    private String classId;
    private String email;

    public Students(String id, String name, String dob, String classId, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.classId = classId;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
