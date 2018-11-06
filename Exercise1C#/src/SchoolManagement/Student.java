package SchoolManagement;

public class Student extends People {

	private String classNum;
	
	public Student(String classNum) {
		super();
		this.classNum = classNum;
	}


	public String getClassNum() {
		return classNum;
	}


	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	@Override
	public void getName() {
		System.out.println("Student: " + super.name);
	}

}
