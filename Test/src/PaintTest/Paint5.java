package PaintTest;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Paint5 extends JFrame implements MouseListener , MouseMotionListener{

	private JLabel lbel;
	private Graphics g;
	private int x1,x2,y1,y2;
	public Paint5() {
		setTitle("Ve");
		g.drawLine(0, 0, 20, 20);
		JPanel panel = new JPanel();
		lbel = new JLabel("This paint");
		panel.add(lbel);
		setSize(500, 400);
		add(panel);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Paint5();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
		g.drawLine(x1, y1, x1+10, y1+10);
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
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
		g.drawLine(x1, y1, x2, y2);
		repaint();
		x1 = x2;
		y1 = y2;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		lbel.setText("Mouse move " + e.getX() + "," + e.getY() +"!");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		lbel.setText("Mouse move " + e.getX() + "," + e.getY() +"!");
	}

}
