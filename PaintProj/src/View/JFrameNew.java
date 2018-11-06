package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Position;
import Model.Shape;
import Model.ShapeFactory;

import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFrameNew extends JFrame {

	private JPanel contentPane;
	private JTextField txtX;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JTextField txtY;
	private static JFrameMain main;

	private static int pos = 0;

	/**
	 * Create the frame.
	 */
	public JFrameNew() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 471, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		main = (JFrameMain) getParent();

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

		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);

		JLabel lblNewLabel = new JLabel("Position");
		panel_8.add(lblNewLabel);

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);

		txtX = new JTextField();
		panel_5.add(txtX);
		txtX.setColumns(3);

		txtY = new JTextField();
		panel_5.add(txtY);
		txtY.setColumns(3);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);

		JLabel lbChange = new JLabel("Radius");
		panel_9.add(lbChange);

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);

		txtWidth = new JTextField();
		panel_6.add(txtWidth);
		txtWidth.setColumns(5);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		panel_4.setVisible(false);

		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);

		JLabel lblNewLabel_2 = new JLabel("Height");
		panel_10.add(lblNewLabel_2);

		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);

		txtHeight = new JTextField();
		panel_7.add(txtHeight);
		txtHeight.setColumns(5);

		JPanel panel_11 = new JPanel();
		contentPane.add(panel_11, BorderLayout.SOUTH);

		JButton btnAdd = new JButton("Add");
		panel_11.add(btnAdd);

		// ========EVENTS===========

		cbShape.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem().equals("Rectangle")) {
					panel_4.setVisible(true);
					lbChange.setText("Width");
					pos = 1;
				} else if (e.getItem().equals("Circle")) {
					panel_4.setVisible(false);
					lbChange.setText("Radius");
					pos = 0;
				}
			}
		});

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Shape shape = null;
				Position position = null;
				if (!txtX.getText().equals("") && !txtY.getText().equals(""))
					position = new Position(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText()));
				if (pos == 0) {
					if (txtX.getText().equals("") || txtY.getText().equals("") || txtWidth.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid information", "", JOptionPane.ERROR_MESSAGE);
					else {
						shape = ShapeFactory.getShape(Integer.parseInt(txtWidth.getText()), -1, position);
						main.listShape.add(shape);
						main.loadDataTable();
						main.reLoadShape();
						setVisible(false);
					}
				} else {
					if (txtX.getText().equals("") || txtY.getText().equals("") || txtWidth.getText().equals("")
							|| txtHeight.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid information", "", JOptionPane.ERROR_MESSAGE);
					else {
						shape = ShapeFactory.getShape(Integer.parseInt(txtWidth.getText()),
								Integer.parseInt(txtHeight.getText()), position);
						main.listShape.add(shape);
						main.loadDataTable();
						main.reLoadShape();
						setVisible(false);
					}
				}

			}
		});

	}

}