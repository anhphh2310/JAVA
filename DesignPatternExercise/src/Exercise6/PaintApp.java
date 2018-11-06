package Exercise6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintApp extends JFrame implements ActionListener,MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8350652744354716922L;
	private JPanel buttonPanel, drawPanel;
	private int x = 50;
	private int y = 50;
	private int count = 0;
	private int start = 0;
	private Shape c;
	private int countID = 1;
	private List<Shape> list = new ArrayList<Shape>();
	private List<Shape> listRemove = new ArrayList<Shape>();

	public PaintApp(String title) {
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocation(100, 100);
		getContentPane().setLayout(new BorderLayout());
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		buttonPanel.add(createButton("Add"));
		buttonPanel.add(createButton("Remove"));
		buttonPanel.add(createButton("Undo"));
		buttonPanel.add(createButton("Redo"));
		buttonPanel.add(createButton("secondD"));
		buttonPanel.add(createButton("thirdD"));
		buttonPanel.setSize(20, 20);
		getContentPane().add(buttonPanel, BorderLayout.NORTH);
		/*
		 * listPanel = new JPanel(new GridLayout(1, list.size()+1)); for (Shape shape :
		 * list) {
		 * 
		 * }
		 */
		drawPanel = new JPanel();
		drawPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		drawPanel.setBackground(Color.WHITE);
		getContentPane().add(drawPanel, BorderLayout.CENTER);
		addMouseListener(this);

		setLocationRelativeTo(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Add") {
			start = 1;
		}
		if (e.getActionCommand() == "Remove") {
			start = 2;
		}
		if (e.getActionCommand() == "Undo") {
			start = 3;
			System.out.println(start);
		}
		if (e.getActionCommand() == "Redo") {
			start = 4;
		}
		if (e.getActionCommand() == "secondD") {
			start = 5;
		}
		if (e.getActionCommand() == "thirdD") {
			start = 6;
		}
	}

	public void paint(Graphics g) {
		if (start == 1) {
			if (count == 0) {
				g.setColor(Color.GREEN);
				g.fillOval(x, y, 50, 50);
				c = new Circle(countID, x, y, 50);
				list.add(c);
				count = 1;
				countID++;
				System.out.println(c.getCountId());
			} else {
				g.setColor(Color.GREEN);
				g.fillRect(x, y, 70, 70);
				c = new Rectangle(countID, x, y, 70, 70);
				list.add(c);
				count = 0;
				countID++;
				System.out.println(c.getCountId());
			}
		} else if (start == 2) {
			int tempX = x;
			int tempY = y;
			for (Shape shape : list) {
				if (shape instanceof Circle) {
					Circle c = (Circle) shape;
					if (tempX >= c.getX() && tempY >= c.getY() && tempX <= (c.getRadius() * 2 + c.getX())
							&& tempY <= (c.getRadius() * 2 + c.getY())) {
						g.setColor(Color.WHITE);
						g.fillOval(c.getX(), c.getY(), 50, 50);
						listRemove.add(c);
						try {
							list.remove(c);
						} catch (ArrayIndexOutOfBoundsException exception) {
							System.out.println("No more to do!");
						}
					}
				} else if (shape instanceof Rectangle) {
					Rectangle r = (Rectangle) shape;
					if (tempX >= r.getX() && tempY >= r.getY() && tempX <= (r.getX() + r.getHeight())
							&& tempY <= (r.getY() + r.getWidth())) {
						g.setColor(Color.WHITE);
						g.fillRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
						listRemove.add(r);
						try {
							list.remove(r);
						} catch (ArrayIndexOutOfBoundsException exception) {
							System.out.println("No more to do!");
						}
					}
				}
			}
		} else if (start == 3) {
			System.out.println(countID);
			try {
				Shape s = list.remove(list.size() - 1);
				listRemove.add(s);
				if (s instanceof Circle) {
					g.setColor(Color.WHITE);
					g.fillOval(s.getX(), s.getY(), 50, 50);
				} else {
					g.setColor(Color.WHITE);
					g.fillRect(s.getX(), s.getY(), ((Rectangle) s).getWidth(), ((Rectangle) s).getHeight());
				}
			} catch (ArrayIndexOutOfBoundsException exception) {
				System.out.println("No more to do!");
			}
		} else if (start == 4) {
			try {
				Shape s = listRemove.remove(listRemove.size() - 1);
				list.add(s);
				g.setColor(Color.GREEN);
				if (s instanceof Circle) {
					g.fillOval(s.getX(), s.getY(), 50, 50);
				} else {
					g.fillRect(s.getX(), s.getY(), ((Rectangle) s).getWidth(), ((Rectangle) s).getHeight());
				}
			} catch (ArrayIndexOutOfBoundsException exception) {
				System.out.println("No more to do!");
			}
		}
	}

	public JButton createButton(String title) {
		JButton jb = new JButton(title);
		jb.addActionListener(this);
		return jb;
	}

	public static void main(String[] args) {
		new PaintApp("TMA Paint");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		repaint();
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		repaint();
	}

	public void paint1(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(x, y, x, y);
	}
}
