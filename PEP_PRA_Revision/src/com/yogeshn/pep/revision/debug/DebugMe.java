package com.yogeshn.pep.revision.debug;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DebugMe extends JFrame {
	public static void main(String[] args) {
		new DebugMe();
	}

	private JLabel[] labels;
	private JButton randomButton;
	private JButton shuffleButton;
	private JButton sortButton;
	private JButton exitButton;
	private int[] values;

	public DebugMe() {
		super("Debug me!");
		createComponents();
		createLayout();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setResizable(false);
		setLocationByPlatform(true);
		setVisible(true);
	}

	private void createLayout() {
		JPanel center = new JPanel(new GridLayout(1, 10));
		for (int i = 0; i < labels.length; i++) {
			center.add(labels[i]);
		}
		JPanel bottom = new JPanel(new FlowLayout());
		bottom.add(randomButton);
		bottom.add(shuffleButton);
		bottom.add(sortButton);
		bottom.add(Box.createHorizontalStrut(50));
		bottom.add(exitButton);
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(center, BorderLayout.CENTER);
		contentPane.add(bottom, BorderLayout.SOUTH);
		setContentPane(contentPane);
	}

	private void createComponents() {
		labels = new JLabel[10];
		values = new int[10];
		for (int i = 0; i < labels.length; i++) {
			values[i] = new Random().nextInt(20) + 1;
			labels[i] = new JLabel("" + values[i]);
			labels[i].setHorizontalAlignment(JLabel.CENTER);
			labels[i].setPreferredSize(new Dimension(50, 50));
		}
		randomButton = new JButton("Random numbers");
		shuffleButton = new JButton("Shuffle");
		sortButton = new JButton("Sort");
		exitButton = new JButton("Exit");
		ActionListener randomListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				random();
			}
		};
		randomButton.addActionListener(randomListener);
		ActionListener shuffleListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shuffle();
			}
		};
		shuffleButton.addActionListener(shuffleListener);
		ActionListener sortListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sort();
			}
		};
		sortButton.addActionListener(sortListener);
		ActionListener exitListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		exitButton.addActionListener(exitListener);
	}

	private void random() {
		Random r = new Random();
		for (int i = 0; i < labels.length; i++) {
			values[i] = r.nextInt(20) + 1;
		}
		refresh();
	}

	private void shuffle() {
		int temp;
		Random r = new Random();
		int randomIndex;
		for (int i = 0; i < values.length; i++) {
			randomIndex = r.nextInt(values.length - i) + i;
			temp = values[randomIndex];
			values[randomIndex] = values[i];
			values[i] = temp;
		}
		refresh();
	}

	private void sort() {
		int indexOfMin, temp;
		for (int i = 0; i < values.length; i++) {
			indexOfMin = i;
			for (int j = i; j < values.length; j++) {
				if (values[j] < values[indexOfMin]) {
					indexOfMin = j;
				}
			}
			temp = values[indexOfMin];
			values[indexOfMin] = values[i];
			values[i] = temp;
		}
		
		//Arrays.sort;
		refresh();
	}

	private void refresh() {
		for (int i = 0; i < labels.length; i++) {
			labels[i].setText("" + values[i]);
		}
	}
}