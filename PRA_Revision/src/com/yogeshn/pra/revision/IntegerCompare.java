package com.yogeshn.pra.revision;

import java.util.Comparator;

public class IntegerCompare implements Comparator<Integer> {

	private int countBits(Integer a) {
		if (a < 0) {
			throw new RuntimeException("Number is smaller than 0");
		}
		int numOnes = 0;
		int tmp = ((Integer) a).intValue();
		while (tmp != 0) {
			int bit = tmp & 1;
			if (bit == 1)
				numOnes++;
			tmp = tmp >> 1;
		}
		return numOnes;
	}

	public int compare(Integer i, Integer j) {
		if (Integer.bitCount(i) < Integer.bitCount(j)) {
			return -1;
		}
		if (Integer.bitCount(i) > Integer.bitCount(j)) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		IntegerCompare test = new IntegerCompare();
		System.out.println(test.compare(7,15));
		System.out.println(test.compare(7,9));
		System.out.println(test.compare(7,13));

	}
}