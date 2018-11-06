package main.java.app.kobj;

public class BraveKnight {

	private Quest quest;
	private boolean motivated;
	private boolean embarkedOnQuest;
	
	public BraveKnight(Quest quest) {
		this.quest = quest;
	}

	public String getQuestName() {
		return quest.getName();
	}
	
	public char tellQuestLetter() {
		return quest.getLetter();
	}
	public boolean isQuestDone() {
		return embarkedOnQuest && quest.isCompleted();
	}
	public void embarkOnQuest() throws QuestException{
		if(motivated)
			quest.embark();
	}
	
	public void setMotivated(boolean motivated) {
		this.motivated = motivated;
	}

	public int getMilesTravelled() {
		return quest.getDistance();
	}
	
	public Quest getQuest() {
		return quest;
	}
	
	public Object getQuestProof() {
		return quest.getQuestProof();
	}
}
