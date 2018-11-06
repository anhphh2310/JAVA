package Model;

public class ShapeFactory {
	
	public static Shape getShape(int width, int height, int x, int y) {
		Shape s = null;
		if(height==-1) {
			s = new Circle(x,y,width);
		}
		else {
			s = new Rectangle(x,y,width,height);
		}
		return s;
	}

	
}
