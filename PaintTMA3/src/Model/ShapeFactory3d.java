package Model;

public class ShapeFactory3d implements ShapeAbstractFactory {

	private int x;
	private int y;
	private int width;
	private int height;

	public ShapeFactory3d(int x, int y, int width, int height) {
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
			return new Circle3d(x, y, width);
		return null;
	}

	@Override
	public Shape createRectangle() {
		// TODO Auto-generated method stub
		return new Rectangle3d(x, y, width, height);
	}

}
