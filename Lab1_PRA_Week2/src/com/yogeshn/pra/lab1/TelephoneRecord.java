package com.yogeshn.pra.lab1;

/**
 * A record containing telephone contact details for one person
 * 
 * @author Yogesh
 */
public class TelephoneRecord {
	
	private String name;
	private String number;
	
	/**
	 * Creates a new record with given name and number.
	 * 
	 * @param name
	 * @param number
	 */
	public TelephoneRecord(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	/**
	 * Set the name element of this record.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set the number element of this record.
	 * 
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Get the name element of the this record.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the number element of this record.
	 * 
	 * @return
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Generates a human readable string representation of this record.
	 */
	@Override
	public String toString() {
		return "The phone number of " + name + " is " + number + "."; 
	}

}
