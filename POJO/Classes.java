
public class Classes {
	private String id;
	private String name;
	private String falcuty;
	private String academic_year;
	private String teacher_id;
	
	public Classes(String id, String name, String falcuty, String academic_year, String teacher_id) {
		super();
		this.id = id;
		this.name = name;
		this.falcuty = falcuty;
		this.academic_year = academic_year;
		this.teacher_id = teacher_id;
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

	public String getFalcuty() {
		return falcuty;
	}

	public void setFalcuty(String falcuty) {
		this.falcuty = falcuty;
	}

	public String getAcademic_year() {
		return academic_year;
	}

	public void setAcademic_year(String academic_year) {
		this.academic_year = academic_year;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	
}
