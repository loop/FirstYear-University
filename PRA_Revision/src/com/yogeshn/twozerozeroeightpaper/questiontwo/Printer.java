package com.yogeshn.twozerozeroeightpaper.questiontwo;

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

public class Printer extends JFrame {

	public Printer() {
		super("Print Document");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel top = new JPanel(new BorderLayout());
		JPanel boxes = new JPanel(new BorderLayout());
		JPanel bottomButtons = new JPanel(new FlowLayout());
		
		JLabel choose = new JLabel("Choose Printer: ");
		JTextField input  = new JTextField(30);
		JButton find = new JButton("Find printer");
		top.add(choose,BorderLayout.WEST);
		top.add(input,BorderLayout.CENTER);
		top.add(find,BorderLayout.SOUTH);
		
		c.add(top,BorderLayout.NORTH);
		
		JCheckBox all = new JCheckBox("All pages");
		JCheckBox current = new JCheckBox("Current page");
		JCheckBox even = new JCheckBox("Even pages");
		JCheckBox odd = new JCheckBox("Odd pages");
		
		JPanel boxGrid = new JPanel(new GridLayout(4,1));
		boxGrid.add(all);
		boxGrid.add(current);
		boxGrid.add(even);
		boxGrid.add(odd);
		
		boxes.add(boxGrid,BorderLayout.NORTH);
		
		JButton printB = new JButton("Print another copy");
		JButton close = new JButton("Close form");
		
		bottomButtons.add(printB);
		bottomButtons.add(close);
		
		c.add(boxes,BorderLayout.CENTER);
		
		JPanel bottom = new JPanel(new BorderLayout());
		bottom.add(bottomButtons,BorderLayout.NORTH);
		boxes.add(bottom,BorderLayout.CENTER);
		setSize(400,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
	}
	
	public static void main(String[] args) {
		new Printer().setVisible(true);

	}

}
