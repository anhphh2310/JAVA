package Model;

import java.awt.Graphics;

public class Circle3d extends Shape {

	private int x1, y1,radius, radius1;

	public Circle3d(int x, int y, int radius) {
		super(x, y);
		this.x1 = x + 10;
		this.y1 = y + 10;
		this.radius = radius;
		this.radius1 = radius + 10;
		// TODO Auto-generated constructor stub
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getRadius1() {
		return radius1;
	}

	public void setRadius1(int radius1) {
		this.radius1 = radius1;
	}

	@Override
	public void drawShape(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval(x, y, radius*2, radius*2);
		g.drawOval(x1, y1, radius1*2, radius1*2);

	}

	@Override
	public Object[] convertToObj() {
		Object[] data = { "(" + this.getX() + "," + this.getY() + ")", this.radius };
		return data;
	}

	@Override
	public Boolean isContain(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
}
