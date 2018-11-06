package PaintTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class DrawCircle extends JFrame implements MouseListener, ActionListener {

	private int x; // leftmost pixel in circle has this x-coordinate
	private int y; // topmost pixel in circle has this y-coordinate
	private int count = 0;

	public DrawCircle() {
		setSize(800, 800);
		setLocation(100, 100);
		setLayout(new BorderLayout());
		JButton jb1 = new JButton("Circle");
		jb1.addActionListener(this);
		JButton jb2 = new JButton("Rectangle");
		jb2.addActionListener(this);
		JButton jb3 = new JButton("Erase");
		jb3.addActionListener(this);
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		add(jp, BorderLayout.NORTH);
		JPanel jp2 = new JPanel();
		jp2.setBorder(BorderFactory.createLineBorder(Color.black));
		add(jp2, BorderLayout.CENTER);
		addMouseListener(this);
		setVisible(true);
	}

	// paint is called automatically when program begins, when window is
	// refreshed and when repaint() is invoked
	public void paint(Graphics g) {
		if (count == 0) {
			g.setColor(Color.yellow);
			g.fillOval(x, y, 100, 100);
		} else if (count == 2) {
			g.setColor(Color.white);
			g.fillRect(x, y, 200, 100);
		} else {
			g.setColor(Color.yellow);
			g.fillRect(x, y, 200, 100);
		}

	}

	// The next 4 methods must be defined, but you won't use them.
	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		x = e.getX(); // x-coordinate of the mouse click
		y = e.getY(); // y-coordinate of the mouse click
		repaint(); // calls paint()
	}

	public static void main(String argv[]) {
		DrawCircle c = new DrawCircle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "Circle") {
			count = 0;
		} else if (e.getActionCommand() == "Erase") {
			count = 2;
		} else {
			count = 1;
		}
	}

}
