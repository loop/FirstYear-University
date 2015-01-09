package uk.ac.kcl.inf._4ccs1pra.spreadsheet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Yogesh Nagarur
 * 
 */
public class SpreadSheetFrame extends JFrame {
	/**
	 * Added generated serialVersionUID
	 */
	private static final long serialVersionUID = -8371730413435262982L;

	public SpreadSheetFrame() {
		super("Spread Sheet");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 700);
		initWidgets();
	}

	private void initWidgets() {
		final JTextField jtf = new JTextField();
		JButton jbEnter = new JButton("Enter");
		final Spreadsheet spreadsheet = new Spreadsheet();
		final JTable jtSpread = new JTable(spreadsheet);
		jtSpread.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jtSpread.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtSpread.setCellSelectionEnabled(true);
		jtSpread.setGridColor(Color.BLACK);
		JScrollPane jsp = new JScrollPane(jtSpread);

		setLayout(new BorderLayout());

		JPanel jpNorth = new JPanel();
		add(jpNorth, BorderLayout.NORTH);

		jpNorth.setLayout(new BorderLayout());
		jpNorth.add(jbEnter, BorderLayout.EAST);
		jpNorth.add(jtf, BorderLayout.CENTER);

		add(jsp, BorderLayout.CENTER);

		pack();

		jbEnter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1. Get the text from input field 2. Find the cell to be
				 * updated 3. Set the contents of that cell
				 */
				String text = jtf.getText();
				int colSel = jtSpread.getSelectedColumn();
				int rowSel = jtSpread.getSelectedRow();

				if ((colSel != -1) && (rowSel != -1)) {
					// set the contents of that cell
					spreadsheet.setValueAt(text, rowSel, colSel);
				}
			}
		});

	

	}
}
