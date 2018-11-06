package View;

import java.awt.AWTException;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.Circle;
import Model.Shape;
import Model.ShapeAbstractFactory;
import Model.ShapeFactory2d;
import Model.ShapeFactory3d;

import javax.swing.BoxLayout;

import javax.swing.Box;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table;
	private static JTable table_1;
	private static JPanel panel_6;
	public static ShapeAbstractFactory saf2d = new ShapeFactory2d();
	public static ShapeAbstractFactory saf3d = new ShapeFactory3d();
	public static List<Shape> listShape = new ArrayList<>();
	public static List<Shape> list3D = new ArrayList<>();

	private Shape shapeSelected = null;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

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
		JScrollPane scrollPane_2 = new JScrollPane(table_1);

		Dimension d_1 = table_1.getPreferredSize();
		scrollPane_2.setPreferredSize(new Dimension(d_1.width, table.getRowHeight() * 6));

		panel_4.add(scrollPane_2);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 6, 0, 0));

		JButton btnNewButton = new JButton("Add");
		panel_5.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Remove");
		panel_5.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Undo");
		panel_5.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Redo");
		panel_5.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("2D");
		panel_5.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("3D");
		panel_5.add(btnNewButton_5);

		panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		DrawFrame panel_draw = new DrawFrame(listShape, list3D);
		panel_draw.setBackground(Color.white);
		shapeSelected = panel_draw.getShapeSelect();
		panel_6.add(panel_draw);

		panel_2.add(Box.createRigidArea(new Dimension(0, 10)));

		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NewFrame newFrame = new NewFrame();
				newFrame.setVisible(true);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeShape();
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NewFrame newFrame = new NewFrame();
				newFrame.setVisible(true);
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				NewFrame3D newframe = new NewFrame3D();
				newframe.setVisible(true);
			}
		});
	}

	public void removeShape() {
		int rowCircle = table.getSelectedRow();
		System.out.println(rowCircle);
		if (rowCircle > -1) {
			int i = -1;
			for (Shape shape : listShape) {
				if (shape.convertToObj().length == 2) {
					i++;
				}
				if (i == rowCircle) {
					listShape.remove(shape);
					break;
				}
			}
			for (Shape shape : list3D) {
				if (shape.convertToObj().length == 2) {
					i++;
				}
				if (i == rowCircle) {
					listShape.remove(shape);
					break;
				}
			}
		}
		int rowRectangle = table_1.getSelectedRow();
		if (rowRectangle > -1) {
			int i = -1;
			for (Shape shape : listShape) {
				if (shape.convertToObj().length == 3) {
					i++;
				}
				if (i == rowRectangle) {
					listShape.remove(shape);
					break;
				}
			}
			for (Shape shape : list3D) {
				if (shape.convertToObj().length == 3) {
					i++;
				}
				if (i == rowRectangle) {
					listShape.remove(shape);
					break;
				}
			}
		}
		loadDataTable();
		reloadShape();
	}

	public static void initShape() {
		listShape.add(saf2d.createCircle(20, 50, 20));
		listShape.add(saf2d.createCircle(50, 200, 100));

		listShape.add(saf2d.createRectangle(50, 20, 100, 200));
		listShape.add(saf2d.createRectangle(60, 30, 200, 200));
		listShape.add(saf2d.createRectangle(90, 60, 300, 200));

//		listShape.add(ShapeFactory.getShape(20, -1, 350, 250));
//		listShape.add(ShapeFactory.getShape(50, -1, 200, 100));
//		listShape.add(ShapeFactory.getShape(50, 20, 100, 200));
//		listShape.add(ShapeFactory.getShape(60, 30, 200, 200));
//		listShape.add(ShapeFactory.getShape(90, 60, 300, 200));

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
		for (Shape shape : list3D) {
			int length = shape.convertToObj().length;
			if (length == 2)
				model.addRow(shape.convertToObj());
			else
				model_1.addRow(shape.convertToObj());
		}
	}

	public static void reloadShape() {
		panel_6.removeAll();
		DrawFrame panel_draw = new DrawFrame(listShape, list3D);
		panel_draw.setBackground(Color.white);
		panel_6.add(panel_draw);
		panel_6.revalidate();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
				initShape();
				loadDataTable();
			}
		});
	}
}
