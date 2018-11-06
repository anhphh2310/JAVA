package Model;

public class ShapeFactory {
	public static Shape getShape(int width, int height, Position position)
	{
		Shape shape=null;
		if(height==-1)
			shape= new Circle(width, position);
		else
			shape=new Rectangle(width, height, position);
		return shape;
	}

}
