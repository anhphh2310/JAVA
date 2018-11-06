package Model;

import java.awt.Graphics;

public class Rectangle3d extends Shape {

	private int x1, y1, width, width1,height, height1;

	public Rectangle3d(int x, int y, int width, int height) {
		super(x, y);
		this.x1 = x + 10;
		this.y1 = y + 10;
		this.width = width;
		this.height = height;
		this.width1 = width + 10;
		this.height1 = height + 10;
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

	public int getWidth1() {
		return width1;
	}

	public void setWidth1(int width1) {
		this.width1 = width1;
	}

	public int getHeight1() {
		return height1;
	}

	public void setHeight1(int height1) {
		this.height1 = height1;
	}

	@Override
	public void drawShape(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(x, y, width, height);
		g.drawRect(x1, y1, width1, height1);
	}

	@Override
	public Object[] convertToObj() {
		Object[] data = { "(" + this.getX() + "," + this.getY() + ")", this.width, this.height };
		return data;
	}

	@Override
	public Boolean isContain(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
}
