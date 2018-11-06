package PaintTest;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Paint extends JFrame {

	public Paint(String title) throws IOException {
		setLayout(new GridLayout(2, 1, 5, 5));
		setSize(200,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		BufferedImage icon = ImageIO.read(new File("D:\\Eclipse\\Test\\src\\PaintTest\\sun.png"));

		JLabel jl1 = new JLabel("label text only");
		jl1.setHorizontalAlignment(JLabel.CENTER);
		JLabel jl2 = new JLabel(new ImageIcon(icon));
		JLabel jl3 = new JLabel("icon label", new ImageIcon(icon), JLabel.CENTER);
		jl3.setHorizontalTextPosition(JLabel.CENTER);
		jl3.setVerticalTextPosition(JLabel.BOTTOM);

		add(jl1);
		add(jl2);
		add(jl3);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String[] args) throws IOException {
		new Paint("Hello Guys!");
	}
}
