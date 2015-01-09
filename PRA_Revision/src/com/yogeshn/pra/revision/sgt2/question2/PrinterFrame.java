package com.yogeshn.pra.revision.sgt2.question2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrinterFrame extends JFrame {
	public PrinterFrame() {
		Container pane = getContentPane();
		
		pane.setLayout(new BorderLayout());
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new GridLayout(4,1));
		buttonPane.add(new JButton("OK"));
		buttonPane.add(new JButton("Cancel"));
		buttonPane.add(new JButton("Setup.."));
		buttonPane.add(new JButton("Help"));
		pane.add(buttonPane,BorderLayout.EAST);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(new JLabel("Printer: MyPrinter"),BorderLayout.NORTH);
		
		JPanel selectionBox = new JPanel();
		selectionBox.setLayout(new GridLayout(4,1));
		selectionBox.add(new JCheckBox("Text"));
		selectionBox.add(new JCheckBox("Line Drawing"));
		selectionBox.add(new JCheckBox("Photograph"));
		selectionBox.add(new JCheckBox("Code"));
		mainPanel.add(selectionBox,BorderLayout.CENTER);
		
		JPanel qualityPanel = new JPanel();
		qualityPanel.setLayout(new FlowLayout());
		qualityPanel.add(new JLabel("Quality"));
		JComboBox qualityBox = new JComboBox();
		qualityBox.addItem("High");
		qualityBox.addItem("Medium");
		qualityBox.addItem("Low");
		qualityPanel.add(qualityBox);
		mainPanel.add(qualityPanel,BorderLayout.SOUTH);
		
		pane.add(mainPanel,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		PrinterFrame frame = new PrinterFrame();
		frame.setSize(300,200);
		frame.setTitle("Printer");
		frame.setVisible(true);
	}

}
