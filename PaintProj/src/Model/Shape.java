package Model;

import java.awt.Graphics;

public abstract class Shape {
	protected Position position;

	public Shape(Position position) {
		super();
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Shape) {
            return this.position.getX() == ((Shape) obj).position.getX() && this.position.getY() == ((Shape) obj).position.getY();
        }
        return false;
	}

	public abstract Object[] convertToObj(); 
	
	public abstract void drawShape(Graphics g);
	
	public abstract Boolean isContain(Position position); 
	
}