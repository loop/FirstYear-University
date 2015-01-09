import java.util.ArrayList;
import java.util.List;

public class ex1 {
	private static class Tester {
		private int n;

		public Tester(int n) {
			this.n = n;
		}

		@Override
		public String toString() {
			return "Tester with n==" + n;
		}
	}

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("Hello");
		System.out.println(l);
		List<String> l2 = l;
		System.out.println(l2);
		l2.add("World");
		System.out.println(l);
		System.out.println(l2);
		System.out.println(new Tester(27));
	}
}