public class Teachers {
	private String _id;
	private String name;
	private String email;
	private int phone;
	private String faculty;
	
	//constructor
	public Teachers() {
		super();
	}

	public Teachers(String _id, String name, String email, int phone, String faculty) {
		super();
		this._id = _id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.faculty = faculty;
	}
	
	//get
	public String get_id() {
		return _id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getPhone() {
		return phone;
	}

	public String getFaculty() {
		return faculty;
	}

	//set
	public void set_id(String _id) {
		this._id = _id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	
}
