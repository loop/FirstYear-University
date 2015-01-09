package com.yogeshn.lgt.week4;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class Ex3 extends JFrame {
	/**
	 * Added generated serialVersionUID
	 */
	private static final long serialVersionUID = 8585790390861487924L;
		private JTree jtTree;
		private DefaultTreeModel model;
		
		public Ex3() {
			super("Tree Sample App");
			getContentPane().setLayout(new BorderLayout());
			jtTree = new JTree();
			DefaultMutableTreeNode top = new DefaultMutableTreeNode("4CCS1PRA");
			model = new DefaultTreeModel(top);
			model.insertNodeInto (new DefaultMutableTreeNode ("Review of Basic OO Concepts"),top, 0);
			model.insertNodeInto (new DefaultMutableTreeNode ("GUI Development with Swing"),top, 1);	
			model.insertNodeInto (new DefaultMutableTreeNode ("Human COmputer Interaction"),top, 2);	
			jtTree.setModel(model);
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
			Ex3 myApp = new Ex3();

		}

	}
