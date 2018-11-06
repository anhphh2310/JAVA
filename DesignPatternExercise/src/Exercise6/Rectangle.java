package Exercise6;

public class Rectangle extends Shape {

	private int height;
	private int width;

	public Rectangle(int countId,int x, int y, int height, int width) {
		super(countId,x, y);
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
