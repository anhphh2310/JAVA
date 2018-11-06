package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Position;
import Model.Shape;
import Model.ShapeFactory;
import Print.PrintObject;
import Print.Printer;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

public class JFrameMain extends JFrame implements Printer {
	private JPanel contentPane;
	private static JTable table;
	private static JTable table_1;
	private static JPanel panel_6;

	public static List<Shape> listShape = new ArrayList<>();
	private Shape shapeSelected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMain frame = new JFrameMain();
					frame.setVisible(true);
					// frame.pack();
					initShape();
					loadDataTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameMain() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Border lineBorder = BorderFactory.createLineBorder(Color.black);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		JLabel lblNewLabel = new JLabel("Circle");
		panel_3.add(lblNewLabel);

		table = new JTable() {

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Position", "Radius" }));

		JScrollPane scrollPane = new JScrollPane(table);

		Dimension d = table.getPreferredSize();
		scrollPane.setPreferredSize(new Dimension(d.width, table.getRowHeight() * 6));

		panel_3.add(scrollPane);

		panel_3.add(Box.createRigidArea(new Dimension(0, 10)));

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));

		JLabel lblNewLabel_1 = new JLabel("Rectangle");
		panel_4.add(lblNewLabel_1);

		table_1 = new JTable() {

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table_1.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Position", "Width", "Height" }));
		JScrollPane scrollPane_1 = new JScrollPane(table_1);

		Dimension d_1 = table_1.getPreferredSize();
		scrollPane_1.setPreferredSize(new Dimension(d_1.width, table.getRowHeight() * 6));

		panel_4.add(scrollPane_1);

		panel.add(Box.createRigidArea(new Dimension(20, 0)));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

		JButton btnAdd = new JButton("Add");
		panel_5.add(btnAdd);

		JButton btnRemove = new JButton("Remove");
		panel_5.add(btnRemove);

		JButton btnUndo = new JButton("Undo");
		panel_5.add(btnUndo);

		JButton btnRedo = new JButton("Redo");
		panel_5.add(btnRedo);

		JButton btnPrint = new JButton("Print");
		panel_5.add(btnPrint);

		JButton btn2D = new JButton("2D");
		panel_5.add(btn2D);

		JButton btn3D = new JButton("3D");
		panel_5.add(btn3D);

		panel_2.add(Box.createRigidArea(new Dimension(0, 10)));

		panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		JPanelDraw panel_draw = new JPanelDraw(listShape);
		panel_draw.setBackground(Color.white);
		panel_6.add(panel_draw);

		panel_2.add(Box.createRigidArea(new Dimension(0, 10)));

		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		// ===============EVETNS=================

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrameNew jFrameNew = new JFrameNew();
				jFrameNew.setVisible(true);
			}
		});

		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				removeShape();

			}
		});
	}

	protected void removeShape() {
		int rowCir = table.getSelectedRow();
		int rowRec = table_1.getSelectedRow();

		if (rowCir > -1) {
			int i = -1;
			for (Shape shape : listShape) {
				if (shape.convertToObj().length == 2)
					i++;
				if (i == rowCir) {
					listShape.remove(shape);
					break;
				}
			}

		}

		if (rowRec > -1) {
			int i = -1;
			for (Shape shape : listShape) {
				if (shape.convertToObj().length == 3)
					i++;
				if (i == rowRec) {
					listShape.remove(shape);
					break;
				}
			}
		}

		loadDataTable();
		reLoadShape();

	}

	protected static void initShape() {
		// TODO Auto-generated method stub
		listShape.add(ShapeFactory.getShape(20, -1, new Position(350, 250)));
		listShape.add(ShapeFactory.getShape(50, -1, new Position(200, 100)));
		listShape.add(ShapeFactory.getShape(30, -1, new Position(300, 100)));

		listShape.add(ShapeFactory.getShape(50, 20, new Position(100, 200)));
		listShape.add(ShapeFactory.getShape(60, 30, new Position(200, 200)));
		listShape.add(ShapeFactory.getShape(90, 60, new Position(300, 200)));

	}

	public static void loadDataTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		DefaultTableModel model_1 = (DefaultTableModel) table_1.getModel();

		model.setRowCount(0);
		model_1.setRowCount(0);

		for (Shape shape : listShape) {
			int length = shape.convertToObj().length;
			if (length == 2)
				model.addRow(shape.convertToObj());
			else
				model_1.addRow(shape.convertToObj());
		}
	}

	public static void reLoadShape() {

		panel_6.removeAll();
		panel_6.revalidate();
		JPanelDraw panel_draw = new JPanelDraw(listShape);
		panel_draw.setBackground(Color.white);
		panel_6.add(panel_draw);

		panel_6.revalidate();
	}

	@Override
	public void print(PrintObject object) {

		System.out.println("start up the physical device");
		System.out.println("load paper");

		// object.print(g);

		System.out.println("stop the physical device");

	}

}
