package SchoolManagement;

public class Discipline extends Comment {

	private String name;
	private int numLectures;
	private int numExcers;
	
	public Discipline(String name, int numLectures, int numExcers) {
		super();
		this.name = name;
		this.numLectures = numLectures;
		this.numExcers = numExcers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumLectures() {
		return numLectures;
	}

	public void setNumLectures(int numLectures) {
		this.numLectures = numLectures;
	}

	public int getNumExcers() {
		return numExcers;
	}

	public void setNumExcers(int numExcers) {
		this.numExcers = numExcers;
	}

}
