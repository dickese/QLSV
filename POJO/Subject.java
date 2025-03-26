
public class Subject {
    private String id;
    private String name;
    private int credits;
    private String faculty;
    
    public Subject(){}

    public Subject(String id, String name, int credits, String faculty){
        this.id = (id == null || id.isEmpty()) ? new ObjectId().toHexString():id;
        this.name = name;
        this.credits = credits;
        this.faculty = faculty;
        
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + credits;
        result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Subject other = (Subject) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (credits != other.credits)
            return false;
        if (faculty == null) {
            if (other.faculty != null)
                return false;
        } else if (!faculty.equals(other.faculty))
            return false;
        return true;
    }
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", faculty='" + faculty + '\'' +
                '}';
    }
    

}
