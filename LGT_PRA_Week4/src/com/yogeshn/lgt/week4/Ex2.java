package com.yogeshn.lgt.week4;

import java.awt.*;
import javax.swing.*;

public class Ex2 extends JFrame {
	/**
	 * Added generated serialVersionUID
	 */
	private static final long serialVersionUID = 37583366834331852L;
		private JTree jtTree;

		public Ex2() {
			super("Tree Sample App");
			getContentPane().setLayout(new BorderLayout());
			jtTree = new JTree();
			getContentPane().add(new JScrollPane(jtTree), BorderLayout.CENTER);
			JPanel jpBottom = new JPanel(new BorderLayout());
			getContentPane().add(jpBottom, BorderLayout.SOUTH);
			jpBottom.add(new JLabel("New node:"), BorderLayout.WEST);
			jpBottom.add(new JTextField(30), BorderLayout.CENTER);
			jpBottom.add(new JButton("Add"), BorderLayout.EAST);
			pack();
			setVisible(true);
		}

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			@SuppressWarnings("unused")
			Ex2 myApp = new Ex2();

		}

	}
