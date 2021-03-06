package Model;

import java.awt.Graphics;

public class Rectangle extends Shape {

	protected int width;
	protected int height;

	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public Object[] convertToObj() {
		// TODO Auto-generated method stub
		Object[] data = { "(" + this.getX() + "," + this.getY() + ")", this.width, this.height };
		return data;
	}

	@Override
	public void drawShape(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(x, y, width, height);
	}

	@Override
	public Boolean isContain(int tempX, int tempY) {
		Boolean check = false;

		if ((tempX >= this.getX() && tempX <= this.getX() + this.width)
				&& (tempY >= this.getY() && tempY <= this.getY() + this.height))
			check = true;

		return check;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			return super.equals(obj) && this.width == ((Rectangle) obj).width
					&& this.height == ((Rectangle) obj).height;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Rectangle [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}

	
}
