package com.yogeshn.pep.revision.jlists;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.*;


public class MyJLists extends JFrame {
	
	private JList jlList;
	private String[] aColourNames = {"Black","Blue","Red","White"};
	private Color[] aColour = {Color.BLACK,Color.BLUE,Color.RED,Color.WHITE};
	
	public MyJLists(){
		super("My JList");
		setSize(400,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initWidets();
		
	}

	private void initWidets() {
		setLayout(new FlowLayout());
		
		jlList = new JList(aColourNames);
		jlList.setVisibleRowCount(4);
		jlList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(jlList));
		
		jlList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				getContentPane().setBackground(aColour[jlList.getSelectedIndex()]);
				System.out.println(jlList.getSelectedIndex());
			}
		});
		pack();
		
	}

}
