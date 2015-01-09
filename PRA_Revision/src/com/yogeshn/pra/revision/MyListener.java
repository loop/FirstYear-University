package com.yogeshn.pra.revision;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class MyListener implements ActionListener {
	
	JTextField action;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(((JButton)arg0.getSource()).getText().equals("Yes")){
			action.setText("Yes button has been clicked");
		} else {
			action.setText("No button has been clicked");
		}

	}
	
	public MyListener(JTextField action) {
		this.action = action;
	}

}
