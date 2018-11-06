package SchoolManagement;

public class Student extends People {

	private String classNum;
	private String comment;
	
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


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	@Override
	public void getName() {
		System.out.println("Student" + super.name);
	}

}
