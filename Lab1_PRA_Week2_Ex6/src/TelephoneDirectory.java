import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A directory of telephone details.
 * 
 * @author Yogesh
 */
public class TelephoneDirectory implements Iterable<Object> {
	
	/**
	 * The representation of all records in the directory.
	 */
	private Map<String, TelephoneRecord> records = new HashMap<String, TelephoneRecord>();
	
	/**
	 * Adds a record to the directory.
	 * 
	 * @param name
	 * @param phoneNumber
	 * @throws IOException
	 */
	public void addRecord(String name, String phoneNumber) {
		TelephoneRecord tr = new TelephoneRecord(name, phoneNumber);
		records.put(name, tr);
	}
	
	/**
	 * 
	 * @param name
	 * @return (TelephoneRecord)
	 */
	public TelephoneRecord findRcord(String name) {
		return (TelephoneRecord)records.get(name);
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
		return records.values().iterator();
	}

}
