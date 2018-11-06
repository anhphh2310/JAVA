package DictApp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class DictionaryApp extends JFrame {
	private JPanel contentPane;
	public static JTextField txtSearch;
	public static ReadFile reFile;
	private static JPanel panel_1;
	private static JTextArea textArea;
	private static int count = 0;

	public DictionaryApp() throws IOException {
		reFile = new ReadFile();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(10, 10));

		txtSearch = new JTextField();
		panel_1.add(txtSearch, BorderLayout.NORTH);
		txtSearch.setColumns(10);

		textArea = new JTextArea();
		panel_1.add(textArea, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.EAST);

		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = txtSearch.getText();
				textArea.setText(reFile.getArr(reFile.search2(text)));
			}
		});
		panel_2.add(btnFind);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = "";
				if (count == 0) {
					try {
						textArea.setText(reFile.getArr(reFile.find(text)));
						count = 1;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					try {
						textArea.setText(reFile.getArr(reFile.find2(text)));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					System.out.println("ok");
				}
			}
		});
		panel_2.add(btnRefresh);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				UpdateFrame up = new UpdateFrame();
				up.setVisible(true);
				
			}
		});
		panel_2.add(btnUpdate);
		
		JButton bbtnFile = new JButton("File");
		bbtnFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileFrame ff = new FileFrame();
				ff.setVisible(true);
				
			}
		});
		panel_2.add(bbtnFile);
		setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		DictionaryApp dict = new DictionaryApp();
	}
}
