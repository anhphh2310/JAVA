package Model;

import java.awt.Graphics;

public class Circle extends Shape {

	private int radius;

	public Circle(int radius, Position position) {
		super(position);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public Object[] convertToObj() {
		// TODO Auto-generated method stub
		Object[] data = { "(" + this.position.getX() + "," + this.position.getY() + ")", this.radius };
		return data;
	}

	@Override
	public void drawShape(Graphics g) {

		int x = position.getX() - radius;
		int y = position.getY() - radius;
		g.drawOval(x, y, radius * 2, radius * 2);

	}

	@Override
	public Boolean isContain(Position position) {

		Boolean check = false;

		int x = position.getX();
		int y = position.getY();

		double d = Math.sqrt(Math.pow((x - this.position.getX()), 2) + Math.pow((y - this.position.getY()), 2));

		if (d <= this.radius)
			check = true;

		return check;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			return super.equals(obj) && this.radius == ((Circle) obj).radius;
		}
		return false;
	}

}