package uk.ac.kcl.inf._4ccs1pra.spreadsheet;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * @author Yogesh Nagarur
 * 
 * This is a table model that holds the data for a single spreadsheet.
 */
public class Spreadsheet extends AbstractTableModel
						 implements TableModel {
	
	/**
	 * Added generated serialVersionUID
	 */
	private static final long serialVersionUID = 9121876659468455883L;
	private Map<Dimension, Object> data = new HashMap<Dimension, Object>();

	public Spreadsheet() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return 27*26;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return 250;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int row, int col) {
		return data.get(new Dimension (row,col));
	}
	
	@Override
	public void setValueAt (Object data, int row, int col){
		Dimension coord = new Dimension (row,col);
		this.data.put(coord,data);
		//fireTableCellUpdated(row, col);
		
	}

}
