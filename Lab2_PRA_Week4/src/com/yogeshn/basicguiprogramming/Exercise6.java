package com.yogeshn.basicguiprogramming;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Exercise6 extends JFrame implements ActionListener, CaretListener {
	JTextArea area;
	JMenuItem cut;
	JMenuItem copy;

	private void updateMenu() {
		if (area.getSelectedText() == null) {
			cut.setEnabled(false);
			copy.setEnabled(false);
		} else {
			cut.setEnabled(true);
			copy.setEnabled(true);
		}
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("exit")) {
			int response = JOptionPane.showConfirmDialog(this,
					"Are you sure you wish to exit?", "Confirm exit",
					JOptionPane.YES_NO_OPTION);
			if (response == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if (event.getActionCommand().equals("insert_date")) {
			this.area.append(DateFormat.getDateInstance().format(new Date()));
		} else if (event.getActionCommand().equals("edit_cut")) {
			this.area.cut();
		} else if (event.getActionCommand().equals("edit_copy")) {
			this.area.copy();
		} else if (event.getActionCommand().equals("edit_paste")) {
			this.area.paste();
		}
	}


	public void caretUpdate(CaretListener e) {
		updateMenu();
	}

	public Exercise6() {
		JMenuBar bar = new JMenuBar();
		this.setJMenuBar(bar);
		JMenu menu = new JMenu("File");
		bar.add(menu);
		JMenuItem item = new JMenuItem("Exit");
		item.setActionCommand("exit");
		item.addActionListener(this);
		menu.add(item);
		menu = new JMenu("Edit");
		bar.add(menu);
		cut = new JMenuItem("Cut");
		cut.setActionCommand("edit_cut");
		cut.addActionListener(this);
		menu.add(cut);
		copy = new JMenuItem("Copy");
		copy.setActionCommand("edit_copy");
		copy.addActionListener(this);
		menu.add(copy);
		item = new JMenuItem("Paste");
		item.setActionCommand("edit_paste");
		item.addActionListener(this);
		menu.add(item);
		area = new JTextArea();
		area.addCaretListener(this);
		setContentPane(area);
		menu = new JMenu("Insert");
		bar.add(menu);
		item = new JMenuItem("Date");
		item.setActionCommand("insert_date");
		item.addActionListener(this);
		menu.add(item);
		this.setSize(640, 480);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		updateMenu();
	}

	public static void main(String[] args) {
		new Exercise6();
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		// TODO Auto-generated method stub
		
	}

}