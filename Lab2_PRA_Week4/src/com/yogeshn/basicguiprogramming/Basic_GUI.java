package com.yogeshn.basicguiprogramming;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Basic_GUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame();
		JMenuBar menubar = new JMenuBar();
		final JTextArea textArea = new JTextArea(20, 20);
		window.add(textArea);
		window.setJMenuBar(menubar);
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu insert = new JMenu("Insert");
		menubar.add(file);
		menubar.add(edit);
		menubar.add(insert);
		JMenuItem date = new JMenuItem("Date");
		final JMenuItem cut1 = new JMenuItem("Cut");
		final JMenuItem copy2 = new JMenuItem("Copy");
		JMenuItem paste = new JMenuItem("Paste");
		edit.add(cut1);

		cut1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.cut();

			}

		});
		edit.add(copy2);
		copy2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.copy();

			}

		});
		edit.add(paste);
		paste.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.paste();

			}

		});
		cut1.setEnabled(false);
		copy2.setEnabled(false);
		textArea.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent arg0) {
				int dot = arg0.getDot();
				int mark = arg0.getMark();
				if (dot == mark) {

					copy2.setEnabled(false);
					cut1.setEnabled(false);
				} else {
					cut1.setEnabled(true);
					copy2.setEnabled(true);
				}

			}
		});
		insert.add(date);
		date.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append(DateFormat.getDateInstance().format(new Date()));

			}
		});
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to close?", null,
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}

		});
		file.add(exit);

		window.setSize(640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setMinimumSize(new Dimension(640, 480));
		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}

}
