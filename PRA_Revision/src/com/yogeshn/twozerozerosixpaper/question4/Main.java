package com.yogeshn.twozerozerosixpaper.question4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main extends JFrame {
	
	final static String SERIALNUMBER = ("\\d{3}(\\-|/)(\\d{2}|\\d{4})");
	JTextArea output;

	public Main() {
		super("Serial number validator");
		initWidets();
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initWidets() {
		setLayout(new BorderLayout());
		JLabel text = new JLabel("Enter a serial number:");
		final JTextField input = new JTextField(20);
		JPanel top = new JPanel(new GridLayout(1,2));
		top.add(text);
		top.add(input);
		add(top,BorderLayout.NORTH);
		
		output = new JTextArea(200,400);
		add(output,BorderLayout.CENTER);
		
		JButton checkbutton = new JButton("Syntax check");
		add(checkbutton,BorderLayout.SOUTH);
		checkbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				check(input.getText());
			}
		});
		
	}
	
	public void check(String input){
		if(input.matches(SERIALNUMBER)){
		output.append(input + " is a valid serial number" + "\n");
		} else {
		output.append(input + " is invalid" + "\n");
		}
	}
	
	

	public static void main(String[] args) {
		new Main().setVisible(true);

	}

}
