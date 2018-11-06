package PaintTest;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Paint4  {
	private JFrame mainFrame;
	
	Graphics g;
	private static int x1, x2, y1, y2;

	public Paint4() {
		prepareGUI();
	}

	private void prepareGUI() {
		
		mainFrame = new JFrame("Vi du Java Swing");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x1 = e.getX();
				y1 = e.getY();
			}
		});
		mainFrame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				x2 = e.getX();
				y2 = e.getY();
				if(g!=null) {
					g.drawLine(x1, y1, x2, y2);
					mainFrame.repaint();
					x1=x2;
					y1=y2;
				}
			}
		});


		mainFrame.setVisible(true);
	}

	public static void main(String[] args) {
		Paint4 p = new Paint4();
	}

	
}
