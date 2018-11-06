package PaintTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Paint3 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -479365411548598412L;


	private JTextField filedTienGui, filedLaiSuat, filedThag, filedTienLai;
	private JButton tinh, xoa;

	public Paint3() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(5, 2,5,5));
		
		int size = 15;
		add(new JLabel("Tien gui"));
		filedTienGui = new JTextField(size);
		add(filedTienGui);
		
		add(new JLabel("Lai suat"));
		filedLaiSuat = new JTextField(size);
		add(filedLaiSuat);
		
		add(new JLabel("Thag"));
		filedThag = new JTextField(size);
		add(filedThag);
		
		add(new JLabel("Tien lai"));
		filedTienLai = new JTextField(size);
		filedTienLai.setEditable(false);
		add(filedTienLai);
		
		tinh = new JButton("Tinh");
		tinh.addActionListener(this);
		add(tinh);
		
		xoa = new JButton("Xoa");
		xoa.addActionListener(this);
		add(xoa);
		
		pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Tinh") {
			process();
		}
		if(e.getActionCommand() == "Xoa") {
			filedTienGui.setText("");
			filedTienGui.requestFocus();
			filedLaiSuat.setText("");
			filedThag.setText("");
			filedTienLai.setText("");
			
			
		}
	}

	public void process() {
		double tiengui,lai,thang,tienlai;
		if(filedTienGui.getText()=="" || filedLaiSuat.getText()==""|| filedThag.getText()=="") {
			filedTienGui.requestFocus();
		}
		else {
			tiengui = Double.parseDouble(filedTienGui.getText());
			lai = Double.parseDouble(filedLaiSuat.getText());
			thang = Double.parseDouble(filedThag.getText());
			tienlai = tiengui * lai * thang;
			filedTienLai.setText(String.valueOf(tienlai));
		}
	}
	public static void main(String[] args) {
		new Paint3();
	}
}
