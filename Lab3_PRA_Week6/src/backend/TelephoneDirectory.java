package backend;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * A directory of telephone details.
 * 
 * @author steffen
 */
public class TelephoneDirectory implements Iterable<TelephoneRecord> {

	/**
	 * The internal representation of all records in the directory.
	 */
	private Map<String, TelephoneRecord> records = new HashMap<String, TelephoneRecord>();

	/**
	 * Helper for managing events.
	 */
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	/**
	 * Add a listener to be informed of changes in this directory.
	 * 
	 * @param pcl
	 */
	public void addChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}

	/**
	 * Interactively add a record to the directory.
	 * 
	 * @throws IOException
	 */
	public void addRecord(String name, String phoneNumber) {
		TelephoneRecord tr = new TelephoneRecord(name, phoneNumber);
		records.put(name, tr);

		pcs.firePropertyChange("NEW_RECORD", null, name);
	}

	/**
	 * Return an iterator that allows to access all records in this directory.
	 * This implements a method required by {@link Iterable}.
	 * 
	 * @return an iterator of all available records. See {@link Iterator} for a
	 *         discussion of issues involved with making changes to a collection
	 *         while iterating.
	 */
	@Override
	public Iterator<TelephoneRecord> iterator() {
		return records.values().iterator();
	}

	/**
	 * Find the record associated to the name given.
	 * 
	 * @param name
	 *            the name of the person whose record should be retrieved
	 * @return the record associated with the person given or <code>null</code>
	 *         if no such record exists.
	 */
	public TelephoneRecord findRecord(String name) {
		return (TelephoneRecord) records.get(name);
	}

	/**
	 * Update the record for the given name, if any, with the new number given.
	 * @param name
	 * @param sEditedNumber
	 */
	public void update(String name, String sEditedNumber) {
		TelephoneRecord tr = findRecord(name);
		if (tr != null) {
			tr.setNumber(sEditedNumber);
			pcs.firePropertyChange("RECORD_UPDATE", "", "");
		}
	}
}