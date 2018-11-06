package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Model.Shape;

public class DrawFrame extends JPanel implements MouseListener {
	private List<Shape> list = new ArrayList<Shape>();
	private List<Shape> list3D = new ArrayList<>();
	private Shape shapeSelect;

	public DrawFrame(List<Shape> list) {
		super();
		this.list = list;
		this.shapeSelect = null;
		addMouseListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		for (Shape shape : list) {
			if (shape.equals(shapeSelect)) {
				g.setColor(Color.red);
				shape.drawShape(g);
				g.setColor(Color.black);
			} else {
				shape.drawShape(g);
			}
		}
		
	}

	public List<Shape> getList() {
		return list;
	}

	public void setList(List<Shape> list) {
		this.list = list;
	}

	public Shape getShapeSelect() {
		return shapeSelect;
	}

	public void setShapeSelect(Shape shapeSelect) {
		this.shapeSelect = shapeSelect;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Boolean flag = false;
		int x = e.getX();
		int y = e.getY();

		for (Shape shape : list) {
			if (shape.isContain(x, y)) {
				this.shapeSelect = shape;
				repaint();
				flag = true;
			}
		}
		if (!flag) {
			this.shapeSelect = null;
			repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
