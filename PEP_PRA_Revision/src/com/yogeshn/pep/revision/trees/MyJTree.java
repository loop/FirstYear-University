package com.yogeshn.pep.revision.trees;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class MyJTree extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 5274011291605970452L;
	private JTree jtTree;
	private DefaultTreeModel model;
	private JTextField input;
	
	public MyJTree() {
		super("My JTree");
		setSize(400, 400);
		initWidgets();
	}

	private void initWidgets() {
		setLayout(new BorderLayout());
		jtTree = new JTree();
		add(new JScrollPane(jtTree), BorderLayout.CENTER);
		JPanel jpBottom = new JPanel();
		input = new JTextField(30);
		jpBottom.add(new JLabel("New node: "));
		jpBottom.add(input);
		JButton jbadd = new JButton("Add");
		jpBottom.add(jbadd);
		jbadd.addActionListener(this);
		add(jpBottom,BorderLayout.SOUTH);
		jtTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		pack();
		
		DefaultMutableTreeNode pra = new DefaultMutableTreeNode("4CCS1PRA");
		model = new DefaultTreeModel(pra);
		model.insertNodeInto(new DefaultMutableTreeNode("Review of Basic OO Concepts"), pra, 0);
		model.insertNodeInto(new DefaultMutableTreeNode("GUI Development with Swing"), pra, 1);
		model.insertNodeInto(new DefaultMutableTreeNode("Human Computer Interaction"), pra, 2);
		jtTree.setModel(model);
	}
	
	public void actionPerformed(ActionEvent e) {
		TreePath path = jtTree.getSelectionModel().getSelectionPath();
		System.out.println(path);
		if(path != null) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
			String newValue = input.getText();
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newValue);
			model.insertNodeInto(newNode, node, model.getChildCount(node));
		}
	}

}
