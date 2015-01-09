package com.yogeshn.pra.revision;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuestionTwo_2009 extends JFrame{
	boolean status;
	JButton yes;
	JButton no;
	JLabel msg;
	JTextField action;

	public QuestionTwo_2009(String msg) {
		this.msg = new JLabel(msg);
		action = new JTextField();
		action.setEditable(false);
		yes = new JButton("Yes");
		no = new JButton("No");
		yes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				action.setText("Yes was pressed.");
			}
		});
		no.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				action.setText("No was pressed.");
			}
		});
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(yes);
		buttons.add(no);
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(3, 1));
		content.add(this.msg);
		content.add(action);
		content.add(buttons);
		setContentPane(content);
		setSize(300, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new QuestionTwo_2009(
				"<html><b>Are you sure you wish to continue</b></html>");
	}
}
