package Model;

import java.awt.Graphics;

public class Rectangle extends Shape{

	private int width;
	private int height;
	
	public Rectangle(int width, int height,Position position) {
		super(position);
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public Object[] convertToObj() {
		// TODO Auto-generated method stub
		Object[] data= {"("+this.position.getX()+","+this.position.getY()+")",this.width,this.height};
		return data;
	}
	@Override
	public void drawShape(Graphics g) {
		g.drawRect(position.getX(), position.getY(), width, height);
		
	}
	@Override
	public Boolean isContain(Position position) {
		Boolean check=false;
		
		int x=position.getX();
		int y=position.getY();
		
		if((x>=this.position.getX()&&x<=this.position.getX()+this.width)&&(y>=this.position.getY()&&y<=this.position.getY()+this.height))
			check=true;
		
		return check;
	}
	
	@Override
	public boolean equals(Object obj) {
		 if (obj instanceof Rectangle) {
	            return super.equals(obj) 
	                    && this.width == ((Rectangle) obj).width
	                    && this.height == ((Rectangle) obj).height;
	        }
	        return false;
	}
	
	
}