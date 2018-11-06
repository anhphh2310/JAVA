package Model;

public class ShapeFactory3d implements ShapeAbstractFactory {

	@Override
	public Shape createCircle(int x, int y, int width) {
			return new Circle3d(x, y, width);

	}

	@Override
	public Shape createRectangle(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return new Rectangle3d(x, y, width, height);
	}

}
