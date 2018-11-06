package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Model.Position;
import Model.Shape;

public class JPanelDraw extends JPanel implements MouseListener {

	private List<Shape> list = new ArrayList<>();
	private Shape shapeSelect;

	public JPanelDraw(List<Shape> list) {
		super();
		this.list = list;
		this.shapeSelect = null;
		addMouseListener(this);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		for (Shape shape : list) {
			if (shape.equals(shapeSelect)) {
				g.setColor(Color.red);
				shape.drawShape(g);
				g.setColor(Color.black);
			} else
				shape.drawShape(g);
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		Boolean flag = false;
		int x = e.getX();
		int y = e.getY();

		for (Shape shape : list) {
			if (shape.isContain(new Position(x, y))) {
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}