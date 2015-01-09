package com.yogeshn.pra.revision.sgt2.question1;

import java.util.ArrayList;
import java.util.List;

public class Snippet1 {
	private static class Tester {
		private int n;

		public Tester(int n) {
			this.n = n;
		}

		public String toString() {
			return "Tester with n==" + n;
		}
	}

	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("Hello");
		System.out.println(l);
		List l2 = l;
		System.out.println(l2);
		l2.add("World");
		System.out.println(l);
		System.out.println(l2);
		System.out.println(new Tester(27));
	}
}
