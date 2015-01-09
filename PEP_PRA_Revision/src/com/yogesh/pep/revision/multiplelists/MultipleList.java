package com.yogesh.pep.revision.multiplelists;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MultipleList extends JFrame {
	
	private JList jlLeft;
	private JList jlRight;
	private JButton jbAdd;
	private String[] foods = {"Bacon","Wings","Ham","Beef","More Bacon"};
	
	public MultipleList() {
		super("Mutiple Lists");
		setSize(300,200);
		initWidgets();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initWidgets() {
		setLayout(new FlowLayout());
		jlLeft = new JList(foods);
		jlLeft.setVisibleRowCount(3);
		jlLeft.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(jlLeft));
		jbAdd = new JButton("Move -->");
		jbAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jlRight.setListData(jlLeft.getSelectedValues());
				
			}
		});
		add(jbAdd);
		jlRight = new JList();
		jlRight.setVisibleRowCount(3);
		jlRight.setFixedCellHeight(20);
		jlRight.setFixedCellWidth(60);
		jlRight.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(jlRight));
		pack();
		
	}
	
	

}
