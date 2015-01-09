package com.yogeshn.pra.revision;

import java.util.Random;
import javax.swing.JOptionPane;

public class Tester2 {
	public static void main(String[] args) {
		String num1 = JOptionPane.showInputDialog(null,
				"Please enter how many numbers you would like:");

		int r = Integer.parseInt(num1);
		Random generator = new Random();

		for (int counter = 1; counter <= r; counter++) {
			int x = generator.nextInt(100);
			System.out.println(x);
		}

	}
}
