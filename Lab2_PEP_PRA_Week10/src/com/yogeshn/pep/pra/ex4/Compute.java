package com.yogeshn.pep.pra.ex4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Compute extends JFrame {
	
	final int TOWNS = 5;
	
	Model tableModel;
	
	JLabel label = new JLabel("Distance: ??");
	
	JComboBox from;
	JComboBox to;
	
	public Compute(Model model) {
		this.tableModel = model;
		
		setMinimumSize(new Dimension(300,300));
		initWidgets();
	}
	
	public void initWidgets() {
		setLayout(new BorderLayout());
		JPanel top = new JPanel();
		JPanel center = new JPanel();
		
		char c = 'A';
		String[] model = new String[TOWNS];
		for (int i = 0; i < TOWNS; i++) {
		    model[i] = String.valueOf(c);
		    c++;
		}
		
		from = new JComboBox(model);
		to = new JComboBox(model);
		
		top.add(new JLabel("From:"));
		top.add(from);
		
		center.add(new JLabel("To:"));
		center.add(to);
		
		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		
		JButton find = new JButton("Find");
		find.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				from.setEnabled(false);
				to.setEnabled(false);
				
				Map m = new Map();
				
				for (int i = 0; i < tableModel.getRowCount(); i++) {
					m.addRoad(tableModel.getEdge(i));
				}
				
				int d = findTrace(from.getSelectedItem().toString().charAt(0), to.getSelectedItem().toString().charAt(0), ' ', 0, m);
				
				label.setText("Distance: " + d);
				
			
			}
		});
		
		bottom.add(find, BorderLayout.CENTER);
		bottom.add(label, BorderLayout.SOUTH);
		add(bottom, BorderLayout.SOUTH);
	}
	
	public static int findTrace(char current, char to, char last, int distance, Map map) {
		if (current == to) return distance;
		else {
			int smallest = Integer.MAX_VALUE;
			for (Edge e : map.getRoadsFrom(current)) {
				if (e.getFinish() == to) {
					if (smallest > distance + e.getDistance()) {
						smallest = distance + e.getDistance();
					}
				}
			}
			if (smallest < Integer.MAX_VALUE) return smallest;
			else {
				smallest = Integer.MAX_VALUE;
				for (Edge e : map.getRoadsFrom(current)) {
					if (e.getFinish() != last && smallest > distance + e.getDistance()) {
						int r = findTrace(e.getFinish(), to, current, distance + e.getDistance(), map);
						if (r < smallest) smallest = r;
					}
				}
			}
			return smallest;
		}
	}	
}
