package main.java.app.kobj;

public class Quest {

	private boolean completed;
	int distance;
	char letter;
	String name;

	public String getName() {
		return name;

	}

	public char getLetter() {
		return letter;
	}

	public int getDistance() {
		return distance;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void embark() throws QuestException{
		System.out.println("Embarking on quest!");
	}

	public Object getQuestProof() {
		return "Proof.";
	}
}
