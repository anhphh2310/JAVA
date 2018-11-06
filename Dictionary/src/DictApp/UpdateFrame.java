package DictApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

public class UpdateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static DictionaryApp dictionaryApp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame frame = new UpdateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 361, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		dictionaryApp = (DictionaryApp) getParent();
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Update");
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("Key");
		panel_2.add(lblNewLabel_1);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);

		JLabel lblNewLabel_2 = new JLabel("Value");
		panel_3.add(lblNewLabel_2);

		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("OK");
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String key = textField.getText();
				String value = textField_1.getText();

				if (key.equals("") || value.equals("")) {
					JOptionPane.showMessageDialog(null, "Khong co thong tin", "", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						boolean a = dictionaryApp.reFile.updateMap(key, value);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				setVisible(false);
			}
		});
	}

}
