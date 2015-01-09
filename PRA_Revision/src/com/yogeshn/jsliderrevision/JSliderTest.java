package com.yogeshn.jsliderrevision;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderTest extends JFrame {

	JSlider slider;
	JTextField input;
	
	
	public JSliderTest() {
		JMenuBar bar = new JMenuBar();
		JMenu myMenu = new JMenu("File");
		JMenuItem doc = new JMenuItem("Doc");
		
		JMenu new1 = new JMenu("New");
		new1.add(doc);
		
		myMenu.add(new1);
		bar.add(myMenu);
		setJMenuBar(bar);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		slider = new JSlider(JSlider.VERTICAL,0,20,0);
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		Container c = getContentPane();
		c.setLayout(new GridLayout(2,1));
		JPanel panel1 = new JPanel(new FlowLayout());
		JPanel panel2 = new JPanel(new FlowLayout());
		panel1.add(slider);
		final JLabel label = new JLabel("Current value: 0");
		panel2.add(label);
		c.add(panel1);
		c.add(panel2);
		
		
		
		input = new JTextField(10);
		panel2.add(input);
		JButton change = new JButton("Change");
		panel2.add(change);
		change.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				slider.setValue(Integer.parseInt(input.getText()));
				
			}
			
		});
		
		pack();
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				label.setText("Current value: " + slider.getValue());
				
			}
		});
	}
	
	public static void main(String[] args) {
		new JSliderTest().setVisible(true);

	}

}
