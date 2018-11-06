package PaintTest;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Paint2 extends JFrame implements ActionListener{
	JLabel jl1;

	public Paint2(String title) throws IOException {
		setLayout(new GridLayout(3, 1, 5, 5));
		setSize(200, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jl1 = new JLabel("Background defualt");
		jl1.setHorizontalAlignment(JLabel.CENTER);
		jl1.setOpaque(true);
		add(jl1);

		add(createJbutton("Green"));
		add(createJbutton("Blue"));

		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public JButton createJbutton(String title) {
		JButton jb = new JButton(title);
		jb.addActionListener(this);
		return jb;
	}

	public static void main(String[] args) throws IOException {
		new Paint2("Hello Guys!");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "Green") {
			changeBackground(Color.green, "Green");
		}
		if (e.getActionCommand() == "Blue") {
			changeBackground(Color.blue, "Blue");
		}
	}

	private void changeBackground(Color color, String string) {
		// TODO Auto-generated method stub
		jl1.setBackground(color);
		jl1.setText(string);
	}
}
