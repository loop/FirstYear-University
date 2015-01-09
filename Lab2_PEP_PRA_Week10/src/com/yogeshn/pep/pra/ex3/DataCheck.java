package com.yogeshn.pep.pra.ex3;


public class DataCheck {
	
	public DataCheck() {
		
	}
	
	public boolean checkDistance(String distance) {
		try {
			Integer.parseInt(distance);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}

}
