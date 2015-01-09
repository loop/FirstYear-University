package com.yogeshn.pra.revision;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Question22008 extends JFrame {

	
	public Question22008() {
		super("Print Document");
		JLabel choose = new JLabel("Choose Printer:");
		JTextField input = new JTextField("Test");
		JButton find = new JButton("Find Printer");
		JPanel top = new JPanel(new BorderLayout());
		top.add(choose,BorderLayout.WEST);
		top.add(input,BorderLayout.CENTER);
		top.add(find,BorderLayout.SOUTH);
		
		JCheckBox all = new JCheckBox("All pages");
		JCheckBox current = new JCheckBox("Current page");
		JCheckBox even = new JCheckBox("Even pages");
		JCheckBox uneven = new JCheckBox("Uneven pages");
		JPanel checkbox = new JPanel(new GridLayout(4,1));
		checkbox.add(all);
		checkbox.add(current);
		checkbox.add(even);
		checkbox.add(uneven);

		
		JPanel docSettings = new JPanel(new BorderLayout());
		docSettings.add(checkbox,BorderLayout.NORTH);
		
		JButton print = new JButton("Print another copy");
		JButton close = new JButton("Close form");
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(print);
		buttons.add(close);
		docSettings.add(buttons,BorderLayout.CENTER);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(top,BorderLayout.NORTH);
		c.add(docSettings,BorderLayout.CENTER);
		setSize(300,500);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	public static void main(String[] args) {
		new Question22008().setVisible(true);

	}

}
