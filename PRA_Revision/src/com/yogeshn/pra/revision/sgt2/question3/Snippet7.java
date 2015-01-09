package com.yogeshn.pra.revision.sgt2.question3;

public class Snippet7 {
	interface I {
		public Object doSomething(String x);
	}

	class MyType implements I {

		@Override
		public String doSomething(String x) {
			System.out.println(x);
			return ("");
		}

	}

}
