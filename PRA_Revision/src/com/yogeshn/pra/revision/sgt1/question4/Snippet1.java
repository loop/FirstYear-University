package com.yogeshn.pra.revision.sgt1.question4;

public class Snippet1 {

	public static class AnApplication {
		int x = 0;

		AnApplication(int x) {
			super();
			x = this.x;
		}

		public int output() {
			System.out.println(x + 1);
			return (x + 2);
		}

		public static void main(String[] args) {
			AnApplication app = new AnApplication(10);
			System.out.println(app.output());
		}
	}
}
