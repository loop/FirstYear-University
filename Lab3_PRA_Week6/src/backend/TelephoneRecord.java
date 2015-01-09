package backend;

/**
 * A record containing telephone contact details for a single person.
 * 
 * @author steffen
 */
public class TelephoneRecord {

	private String name;
	private String number;

	/**
	 * Create a new record associating the given name and the given number.
	 * 
	 * @param name
	 * @param number
	 */
	public TelephoneRecord(String name, String number) {
		this.name = name;
		this.number = number;
	}

	/**
	 * Get the name element of this record.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name element of this record.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Set the number element of this record.
	 * 
	 * @param number
	 */
	public void setNumber (String number) {
		this.number = number;
	}
	
	/**
	 * Produce a human-readable string representation of this record. 
	 */
	@Override
	public String toString() {
		return "The phone number of " + name + " is " + number + ".";
	}
}