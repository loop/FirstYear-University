package com.yogeshn.pep.revision.tables;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyTable extends JFrame {
	
	JTable jtTable;
	
	public MyTable(){
		super("My Table");
		initWidgets();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initWidgets() {
		setLayout(new FlowLayout());
		
		String[] columnNames = {"Name","Eye-Colour","Gender"};
		Object[][] data = {
				{"Bill","Hazel","Male"},
				{"Mary","Black","Female"},
				{"Rick","Red","Male"},
				{"Janice","Yellow","Female"},
		};
		
		jtTable = new JTable(data,columnNames);
		jtTable.setPreferredScrollableViewportSize(new Dimension(500, 50));
		jtTable.setFillsViewportHeight(true);
		
		JScrollPane jpScroll = new JScrollPane(jtTable);
		add(jpScroll);
		pack();
		
	}

}
