import java.awt.*;
//import java.awt.event.*;

import javax.swing.*;

public class AdderApp extends JFrame { //implements ActionListener {
	/**
	 * Random generated serialVersionUID
	 */
	private static final long serialVersionUID = -3412804118119844685L;
	JTextField number1;
	JTextField number2;
	JLabel num1Label;
	JLabel num2Label;
	JLabel total;
	JButton adder;

	public AdderApp() {
		super("My Application");
		
		number1 = new JTextField();
		number2 = new JTextField();
		
		num1Label = new JLabel("Number 1:");
		num2Label = new JLabel("Number 2:");
		
		total = new JLabel("0");
		
		adder = new JButton("Add");
		
		this.setSize(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		
		panel.add(new JLabel("Number 1:"));
		panel.add(number1);
		panel.add(new JLabel("Number 2:"));
		panel.add(number2);
		panel.add(adder);
		panel.add(total);
		
		//adder.addActionListener(new Action(total, number1, number2));
		//adder.addActionListener(this);
		
		Action listener = new Action (total, number1, number2);
		adder.addActionListener(listener);
		
		
		this.setContentPane(panel);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		JFrame frame = new AdderApp();
	}
	
//	public void actionPerformed(ActionEvent arg0) {
//		float n1,n2;
//		n1 = Float.parseFloat(number1.getText());
//		n2 = Float.parseFloat(number2.getText());
//		total.setText("" + (n1 + n2));
//	
//	}
}