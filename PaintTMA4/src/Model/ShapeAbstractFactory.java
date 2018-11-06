package Model;

public interface ShapeAbstractFactory {

	public Shape createCircle(int x, int y, int width);
	
	public Shape createRectangle(int x, int y, int width, int height);
}
