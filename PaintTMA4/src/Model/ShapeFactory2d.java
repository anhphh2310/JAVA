package Model;

public class ShapeFactory2d implements ShapeAbstractFactory {

	@Override
	public Shape createCircle(int x, int y, int width) {
		// TODO Auto-generated method stub
		
			return new Circle(x,y,width);
	}

	@Override
	public Shape createRectangle(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, width, height);
	}

}
