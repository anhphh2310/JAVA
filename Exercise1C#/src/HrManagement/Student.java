package HrManagement;

public class Student extends Human implements Comparable<Student> {

	private int grade;

	public Student(String firstNameSt, String lastNameSt, int grade) {
		firstName = firstNameSt;
		lastName = lastNameSt;
		this.grade = grade;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		if (grade < 0 || grade > 10) {
			System.out.println("Khong thoa diem");
		} else {
			this.grade = grade;
		}
	}

	@Override
	public int compareTo(Student o) {
		if (this.getGrade() > o.getGrade()) {
			return -1;
		}
		if (this.getGrade() < o.getGrade()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Student [ Name : " + firstName + " " + lastName + "grade=" + grade + "]";
	}

}
