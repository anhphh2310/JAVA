package Model;

import java.awt.Graphics;

public abstract class Shape {
	protected int x;
	protected int y;

	public Shape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Shape) {
			return this.x == ((Shape) obj).getX() && this.y == ((Shape) obj).getY();
		}
		return false;
	}

	public abstract Object[] convertToObj();

	public abstract void drawShape(Graphics g);

	public abstract Boolean isContain(int x, int y);
}
