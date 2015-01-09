package com.yogeshn.pra.revision;

public class InterfaceTester extends TesterAbstract implements Test, Hello {

	@Override
	public void run() {
		System.out.println("Wrooooooom!");

	}

	@Override
	public int fuel() {
		// TODO Auto-generated method stub
		return 123;
	}
	
	public String helloWorld(){
		return ("Hello, world");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InterfaceTester tester = new InterfaceTester();
		tester.run();
		System.out.println(tester.fuel());
		System.out.println(tester.helloWorld());
		

	}

	@Override
	public void run2() {
		// TODO Auto-generated method stub
		
	}

}
