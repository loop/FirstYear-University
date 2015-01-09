package com.yogeshn.lgt.week4;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.tree.*;

public class Ex4 extends JFrame implements ActionListener {
	/**
	 * Added generated serialVersionUID
	 */
	private static final long serialVersionUID = 2900999791242179397L;
		private JTree jtTree;
		private DefaultTreeModel model;
		private JButton addButton;
		private JTextField textField;
		
		public Ex4() {
			
			super("Tree Sample App");
			getContentPane().setLayout(new BorderLayout());
			
			jtTree = new JTree();
			addButton = new JButton("Add: ");
			textField = new JTextField(30);
			DefaultMutableTreeNode top = new DefaultMutableTreeNode("4CCS1PRA");
			model = new DefaultTreeModel(top);
			model.insertNodeInto (new DefaultMutableTreeNode ("Review of Basic OO Concepts"),top, 0);
			model.insertNodeInto (new DefaultMutableTreeNode ("GUI Development with Swing"),top, 1);	
			model.insertNodeInto (new DefaultMutableTreeNode ("Human COmputer Interaction"),top, 2);	
			jtTree.setModel(model);
			
			jtTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			addButton.addActionListener(this);
			
			
			getContentPane().add(new JScrollPane(jtTree), BorderLayout.CENTER);
			JPanel jpBottom = new JPanel(new BorderLayout());
			getContentPane().add(jpBottom, BorderLayout.SOUTH);
			jpBottom.add(new JLabel("New node:"), BorderLayout.WEST);
			jpBottom.add(textField , BorderLayout.CENTER);
			jpBottom.add(addButton, BorderLayout.EAST);
			pack();
			setVisible(true);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			TreePath path = jtTree.getSelectionModel().getSelectionPath();
			if(path != null) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getLastPathComponent();
				String newValue = textField.getText();
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newValue);
				model.insertNodeInto(newNode, node, model.getChildCount(node));
			}
			
		}

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			@SuppressWarnings("unused")
			Ex4 myApp = new Ex4();

		}



	}
