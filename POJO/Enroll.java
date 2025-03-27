package Enroll;

import javax.swing.text.Document;

public class Enroll {
	private String Enroll_id;
	@Override
	public String toString() {
		return "Enroll [Enroll_id=" + Enroll_id + ", Student_id=" + Student_id + ", Subject_id=" + Subject_id
				+ ", semester=" + semester + ", status=" + status + "]";
	}
	private String Student_id;
	private String Subject_id;
	private String semester;
	public String getEnroll_id() {
		return Enroll_id;
	}
	public void setEnroll_id(String enroll_id) {
		Enroll_id = enroll_id;
	}
	public String getStudent_id() {
		return Student_id;
	}
	public void setStudent_id(String student_id) {
		Student_id = student_id;
	}
	public String getSubject_id() {
		return Subject_id;
	}
	public void setSubject_id(String subject_id) {
		Subject_id = subject_id;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String status;
	public Enroll(String Enroll_id,String Student_id,String Subject_id,String semester, String status)
	{
		this.setEnroll_id(Enroll_id);
		this.setSemester(semester);
		this.setStatus(status);
		this.setStudent_id(Student_id);
		this.setSubject_id(Subject_id);
	}
	
}
