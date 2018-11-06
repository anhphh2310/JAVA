package Model;

public class TestFactory {

	public static void main(String[] args) {
		Shape circle = ShapeFactory.getInstanceCircle(new ShapeFactory2d(10, 10, 200, -1));
		Shape circle3d = ShapeFactory.getInstanceCircle(new ShapeFactory3d(10, 20, 30, -1));
		System.out.println("ShapeAbstract Circle config: " + circle );
	}
}
