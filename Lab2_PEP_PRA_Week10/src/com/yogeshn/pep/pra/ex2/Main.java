package com.yogeshn.pep.pra.ex2;

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


	private static final long serialVersionUID = 7411816501938562982L;
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
		add(new JScrollPane(new JTable(dtmData)),BorderLayout.CENTER);
		
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
		add(jpSouth, BorderLayout.SOUTH);

		jbAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DataCheck dcCheck = new DataCheck();
				String key = jcbFrom.getSelectedItem().toString() + jcbTo.getSelectedItem().toString();
				String value = jtfDistance.getText();
				if (dcCheck.checkDistance(jtfDistance.getText())) {
					if(towns.containsKey(key)){
						JOptionPane.showMessageDialog(null, "The connection already exsist.");
					} else {
							dtmData.addRow(new String[] {
							jcbFrom.getSelectedItem().toString(),
							jcbTo.getSelectedItem().toString(),
							jtfDistance.getText() });
							towns.put(key, value);
					}
				} else {
					JOptionPane.showMessageDialog(null, "The distance can only be of type integer.");
					}
			}
		});
		pack();	

	}




	public static void main(String[] args) {
		new Main().setVisible(true);

	}
	


}
