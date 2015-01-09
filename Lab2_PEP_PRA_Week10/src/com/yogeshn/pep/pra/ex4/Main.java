package com.yogeshn.pep.pra.ex4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.jws.Oneway;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Main extends JFrame {
	
	final int TOWNS = 5;
	
	JTable table;
	JComboBox from;
	JComboBox to;
	JTextField distance = new JTextField(5);
	
	public Main() {
		setMinimumSize(new Dimension(700,300));
		initWidgets();
	}
	
	public void initWidgets() {
		setLayout(new BorderLayout());
		JPanel south = new JPanel();
		
		add(new JLabel("Number of towns: " + TOWNS),BorderLayout.NORTH);
		table = new JTable(new Model());
		JScrollPane scroll = new JScrollPane(table);
		
		add(scroll, BorderLayout.CENTER);
		
		char c = 'A';
		String[] model = new String[TOWNS];
		for (int i = 0; i < TOWNS; i++) {
		    model[i] = String.valueOf(c);
		    c++;
		}
		
		from = new JComboBox(model);
		to = new JComboBox(model);
		
		south.add(new JLabel("From:"));
		south.add(from);
		
		south.add(new JLabel("To:"));
		south.add(to);
		
		south.add(new JLabel("Distance:"));
		south.add(distance);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Model m = (Model)table.getModel();
				try {
					if (!m.addEdge(new Edge(from.getSelectedItem().toString().charAt(0), to.getSelectedItem().toString().charAt(0), Integer.valueOf(distance.getText()))))
						JOptionPane.showMessageDialog(Main.this, "Already exists!");
					table.addNotify();
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(Main.this, "Distance is not an integer!");
				}
			
			}
		});
		
		south.add(add);
		
		JButton del = new JButton("Delete");
		del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Model m = (Model)table.getModel();
				int row = table.getSelectedRow();
				System.out.println(row);
				if (row < 0) {
					JOptionPane.showMessageDialog(Main.this, "No row selected!");
				}
				else {
					m.removeEdge(row);
					table.addNotify();
				}
			
			}
		});
		
		south.add(del);
		
		
		JButton com = new JButton("Compute");
		com.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Model m = (Model)table.getModel();
				new Compute(m).setVisible(true);
			}
		});
		
		south.add(com);
		
		add(south, BorderLayout.SOUTH);
		
		
	}
	
	public static void main(String[] args) {
		new Main().setVisible(true);
	}
}
