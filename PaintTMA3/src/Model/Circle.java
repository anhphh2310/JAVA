package Model;

import java.awt.Graphics;

public class Circle extends Shape {

	protected int radius;
	
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
		// TODO Auto-generated constructor stub
	}

	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		this.radius = radius;
	}


	@Override
	public Object[] convertToObj() {
		Object[] data = { "(" + this.getX() + "," + this.getY() + ")", this.radius };
		return data;	}

	@Override
	public void drawShape(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval(x, y, radius*2, radius*2);
	}

	@Override
	public Boolean isContain(int tempX, int tempY) {
		Boolean check = false;
		int x = tempX;
		int y = tempY;

		double d = Math.sqrt(Math.pow((x - this.getX()), 2) + Math.pow((y - this.getY()), 2));

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

	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", radius=" + radius + "]";
	}

	
}
