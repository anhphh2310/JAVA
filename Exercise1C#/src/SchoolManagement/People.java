package SchoolManagement;

public abstract class People extends Comment{
	protected String name;
	
	
	public void getName() {
		System.out.println("People: " +name);
	};
}
