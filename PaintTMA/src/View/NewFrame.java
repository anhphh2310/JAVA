package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Model.Shape;
import Model.ShapeFactory;

public class NewFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private static MainFrame main;

	private int pos = 0;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textWidth;
	private JTextField textFieldHeight;

	public NewFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(150, 150, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		main = (MainFrame) getParent();

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JComboBox cbShape = new JComboBox();
		cbShape.addItem("Circle");
		cbShape.addItem("Rectangle");
		panel.add(cbShape);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);

		JLabel lblNewLabel = new JLabel("Position");
		panel_5.add(lblNewLabel);

		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);

		textFieldX = new JTextField();
		panel_6.add(textFieldX);
		textFieldX.setColumns(5);

		textFieldY = new JTextField();
		panel_6.add(textFieldY);
		textFieldY.setColumns(5);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);

		JLabel lblNewLabel_change = new JLabel("Radius");
		panel_7.add(lblNewLabel_change);

		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8);

		textWidth = new JTextField();
		panel_8.add(textWidth);
		textWidth.setColumns(6);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		panel_4.setVisible(false);

		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);

		JLabel lblHeight = new JLabel("Height");
		panel_9.add(lblHeight);

		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);

		textFieldHeight = new JTextField();
		panel_10.add(textFieldHeight);
		textFieldHeight.setColumns(4);

		JPanel panel_11 = new JPanel();
		contentPane.add(panel_11, BorderLayout.SOUTH);

		JButton btnInsert = new JButton("Insert");
		panel_11.add(btnInsert);

		cbShape.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem().equals("Rectangle")) {
					panel_4.setVisible(true);
					lblNewLabel_change.setText("Width");
					pos = 1;
				} else {
					panel_4.setVisible(false);
					lblNewLabel_change.setText("Radius");
					pos = 0;
				}
			}
		});
		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Shape s = null;
				int x = 0;
				int y = 0;
				if (!textFieldX.getText().equals("") && !textFieldY.getText().equals("")) {
					x = Integer.parseInt(textFieldX.getText());
					y = Integer.parseInt(textFieldY.getText());
				}
				// Circle
				if (pos == 0) {
					if (textFieldX.getText().equals("") || textFieldY.getText().equals("")
							|| textWidth.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Khong co thong tin", "", JOptionPane.ERROR_MESSAGE);
					} else {
						s = ShapeFactory.getShape(Integer.parseInt(textWidth.getText()), -1, x, y);
						main.listShape.add(s);
						main.loadDataTable();
						main.reloadShape();
						setVisible(false);
					}
				}
				// Rectangle
				else {
					if (textFieldX.getText().equals("") || textFieldY.getText().equals("")
							|| textFieldHeight.getText().equals("") || textWidth.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Khong co thong tin", "", JOptionPane.ERROR_MESSAGE);
					} else {
						s = ShapeFactory.getShape(Integer.parseInt(textWidth.getText()),
								Integer.parseInt(textFieldHeight.getText()), x, y);
						main.listShape.add(s);
						main.loadDataTable();
						main.reloadShape();
						setVisible(false);
					}
				}
			}
		});
	}

}
