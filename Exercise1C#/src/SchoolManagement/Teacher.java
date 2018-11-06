package SchoolManagement;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends People {

	private List<Discipline> disciplines = new ArrayList<Discipline>();
	
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

	@Override
	public void getName() {
		System.out.println("Student: " + super.name);
	}

}
