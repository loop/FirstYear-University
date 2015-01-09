package com.yogeshn.pep.pra.ex3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {


	private static final long serialVersionUID = 1L;
	private static final int NUM_TOWNS = 5;
	private HashMap<String, String> towns = new HashMap<String,String>();


	public Main() {
		super("Connected Towns");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initWidgets();
	}
	
	
	
	
	private void initWidgets() {
		setLayout(new BorderLayout());
		
		add(new JLabel("Number of town: " + NUM_TOWNS ), BorderLayout.NORTH);
		
		final DefaultTableModel dtmData = new DefaultTableModel(
			new String[] {"From", "To", "Distance" }, 0);
		final JTable jtData = new JTable(dtmData);
		add(new JScrollPane(jtData),BorderLayout.CENTER);
		
		String[] saTowns = new String[NUM_TOWNS];
		for(int i = 0; i < NUM_TOWNS; i++) {
			saTowns[i] = Character.toString((char) ('A' + i));
		}
		
		JPanel jpSouth = new JPanel();
		jpSouth.add(new JLabel("From: "));
		final JComboBox jcbFrom = new JComboBox(saTowns);
		jpSouth.add(jcbFrom);
		jpSouth.add(new JLabel("To: "));
		final JComboBox jcbTo = new JComboBox(saTowns);
		jpSouth.add(jcbTo);
		final JTextField jtfDistance = new JTextField(5);
		jpSouth.add(jtfDistance);
		JButton jbAdd = new JButton("Add");
		jpSouth.add(jbAdd);
		JButton jbRemove = new JButton("Remove");
		jpSouth.add(jbRemove);
		add(jpSouth, BorderLayout.SOUTH);
		
		jbAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DataCheck dcCheck = new DataCheck();
				String key = jcbFrom.getSelectedItem().toString() + jcbTo.getSelectedItem().toString();
				String value = jtfDistance.getText();
				String from = jcbFrom.getSelectedItem().toString();
				String to = jcbTo.getSelectedItem().toString();
				String distance = jtfDistance.getText();
				if (dcCheck.checkDistance(jtfDistance.getText())) {
					if(towns.containsKey(key)){
						JOptionPane.showMessageDialog(null, "The connection already exsist.");
					} else {
							dtmData.addRow(new String[] {
							from,
							to,
							distance });
							towns.put(key, value);
					}
				} else {
					JOptionPane.showMessageDialog(null, "The distance can only be of type integer.");
					}
			}
		});
		
		jbRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					int nSelRow = jtData.getSelectedRow();
					String key = jtData.getValueAt(nSelRow, 0).toString() + jtData.getValueAt(nSelRow, 1).toString();
					if (nSelRow != -1) {
					dtmData.removeRow(nSelRow);		
					towns.remove(key);
					}

			}
		});

		pack();

	}




	public static void main(String[] args) {
		new Main().setVisible(true);

	}
	


}
