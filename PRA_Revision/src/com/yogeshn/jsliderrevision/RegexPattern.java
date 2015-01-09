package com.yogeshn.jsliderrevision;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RegexPattern extends JFrame {
	
	private static final Pattern PAT = Pattern.compile("(\\d\\s*){1,3}");
	private JButton jb;
	String a = "24\2010";
	String regex = "(\\d{2}\\\\\\d{4})";
	Boolean b;
	
	public RegexPattern(){
		super("Regex test...");
		inWidgets();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		System.out.println(a.matches(regex));
	}
	
	public void inWidgets(){
		setLayout(new BorderLayout());
		
		JPanel jp = new JPanel(new FlowLayout());
		
		JLabel jl = new JLabel("Input Date:");
		final JTextField jtf = new JTextField(30);
		jp.add(jl);
		jp.add(jtf);
		
		add(jp, BorderLayout.CENTER);
		
		jp = new JPanel(new FlowLayout());
		
		jb = new JButton("OK");
		jb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				Matcher m = PAT.matcher(jtf.getText());
				
				if(m.matches()){
					JOptionPane.showMessageDialog(null, "Works!");
				}else{
					JOptionPane.showMessageDialog(null, "Don't work!");
				}
			}
		});
		jp.add(jb);
		
		add(jp, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args){
		new RegexPattern().setVisible(true);
	}

}