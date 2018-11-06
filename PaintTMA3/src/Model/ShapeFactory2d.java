package Model;

public class ShapeFactory2d implements ShapeAbstractFactory {

	private int x;
	private int y;
	private int width;
	private int height;

	public ShapeFactory2d(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public Shape createCircle() {
		// TODO Auto-generated method stub
		if (height == -1)
			return new Circle(x, y, width);
		return null;
	}

	@Override
	public Shape createRectangle() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, width, height);
	}

}
