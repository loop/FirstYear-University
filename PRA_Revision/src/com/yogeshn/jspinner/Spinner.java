package com.yogeshn.jspinner;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Spinner extends JFrame {

	JSpinner spinner;
	String[] months;
	
	public Spinner() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		months = new String[12];
		for(int i = 0; i < 12; i++) {
			months[i] = (i + 1) + "";
		}
		
		final JLabel label = new JLabel("Select a month please.");
		
		SpinnerListModel monthModel = new SpinnerListModel(months);
		spinner = new JSpinner(monthModel);
		getContentPane().setLayout(new BorderLayout());
		JPanel panel1 = new JPanel(new FlowLayout());
		panel1.add(spinner);
		add(panel1,BorderLayout.CENTER);
		add(label,BorderLayout.SOUTH);
		pack();
		
		spinner.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				label.setText(spinner.getValue().toString());
			}
		});
		
	}
	
	public static void main(String[] args) {
		new Spinner().setVisible(true);

	}

}
