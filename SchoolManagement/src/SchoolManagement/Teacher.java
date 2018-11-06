package SchoolManagement;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends People {

	private List<Discipline> disciplines = new ArrayList<Discipline>();
	private String comment;
	
	public Teacher(List<Discipline> disciplines) {
		super();
		this.disciplines = disciplines;
	}


	public List<Discipline> getDisciplines() {
		return disciplines;
	}


	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
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
