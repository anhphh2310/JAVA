package SchoolManagement;

import java.util.ArrayList;
import java.util.List;

public class Class {

	private List<Student> students = new ArrayList<Student>();
	private List<Teacher> teachers = new ArrayList<Teacher>();
	private String ID;

	public Class(List<Student> students, List<Teacher> teachers, String iD) {
		super();
		this.students = students;
		this.teachers = teachers;
		ID = iD;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public Student getStudent(String classNum) {
		for (Student student : students) {
			if(student.getClassNum().equals(classNum)) {
				return student;
			}
		}
		return null;
	}
	

}
