package Exercise6;

public class Circle extends Shape {

	private int radius;
	
	public Circle(int countId,int x, int y, int radius) {
		super(countId,x, y);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
