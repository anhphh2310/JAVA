package main.java.app.kobj;

public class QuestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	public QuestException(String name) {
		super();
		this.name = name;
	}
	
	
}
