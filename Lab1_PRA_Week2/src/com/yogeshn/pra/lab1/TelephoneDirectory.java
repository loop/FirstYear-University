package com.yogeshn.pra.lab1;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A directory of telephone details.
 * 
 * @author Yogesh
 */
public class TelephoneDirectory implements Iterable<Object> {
	
	/**
	 * The representation of all records in the directory.
	 */
	private List<TelephoneRecord> records = new ArrayList<TelephoneRecord>();
	
	/**
	 * Adds a record to the directory.
	 * 
	 * @param name
	 * @param phoneNumber
	 * @throws IOException
	 */
	public void addRecord(String name, String phoneNumber) {
		TelephoneRecord tr = new TelephoneRecord(name, phoneNumber);
		records.add(tr);
	}

	/**
	 * Return an iterator that allows to access all records in this directory.
	 * This implements a record required by {@link Iterable}
	 * 
	 * @return an iterator of all available records.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Iterator iterator() {
		return records.iterator();
	}

}
