package com.yogeshn.pra.revision;

public class Question2 {

	public static int interP(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return 1;
		} else {
			int current = 1;
			int previous1 = 1;
			int previous2 = 1;
			int next;

			for (int i = 3; i <= n; i++) {
				next = (previous2 * current) + 1;
				previous2 = previous1;
				previous1 = current;
				current = next;
			}
			return current;
		}
	}

	public static void main(String[] args) {
		System.out.println(interP(6));

	}

}
