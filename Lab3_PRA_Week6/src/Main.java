

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import backend.TelephoneDirectory;
import backend.TelephoneRecord;

/**
 * A GUI frontend for the telephone directory.
 * 
 * @author Steffen Zschaler
 */
public class Main extends JFrame {

	private static final long serialVersionUID = 2264164844229029817L;
	/**
	 * The directory for which this is the front end.
	 */
	private TelephoneDirectory tdDirectory;

	/**
	 * A list model wrapper of the telephone directory.
	 * 
	 * @author Steffen Zschaler
	 */
	@SuppressWarnings("rawtypes")
	private class TDListModel extends AbstractListModel implements
			PropertyChangeListener {

		private static final long serialVersionUID = -8741652696592746380L;
		/**
		 * We need to maintain a parallel copy of the entries because we need
		 * the ordering.
		 */
		private List<TelephoneRecord> entries;

		/**
		 * Create a new instance and register it with the directory.
		 */
		public TDListModel() {
			tdDirectory.addChangeListener(this);
		}

		@Override
		public Object getElementAt(int index) {
			updateEntries();

			return entries.get(index);
		}

		@Override
		public int getSize() {
			updateEntries();
			return entries.size();
		}

		/**
		 * Create a copy of the telephone directory contents if needed.
		 */
		@SuppressWarnings({ "unchecked" })
		private void updateEntries() {
			if (entries == null) {
				entries = new ArrayList<TelephoneRecord>();
				for (Object o : tdDirectory) {
					TelephoneRecord tr = (TelephoneRecord) o;
					entries.add(tr);
				}

				Collections.sort(entries, new Comparator() {

					@Override
					public int compare(Object o1, Object o2) {
						TelephoneRecord tr1 = (TelephoneRecord) o1;
						TelephoneRecord tr2 = (TelephoneRecord) o2;
						return tr1.getName().compareTo(tr2.getName());
					}
				});
			}
		}

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			// Force entries to be recreated.
			entries = null;
			fireContentsChanged(this, 0, getSize() - 1); // Not the most
															// efficient way,
															// but wth
		}
	}

	/**
	 * A list model that can be used to filter the underlying data.
	 * 
	 * @author Steffen Zschaler
	 */
	@SuppressWarnings("rawtypes")
	private abstract static class TDListFilter extends AbstractListModel
			implements ListDataListener {

		private static final long serialVersionUID = -8425694054245922788L;

		/**
		 * The base model. This assumes that the objects displayed are
		 * TelephoneRecords.
		 */
		private ListModel tdlm;

		private List<TelephoneRecord> filteredEntries;

		public TDListFilter(ListModel lm) {
			tdlm = lm;
			tdlm.addListDataListener(this);
		}

		@Override
		public int getSize() {
			updateEntries();
			return filteredEntries.size();
		}

		@Override
		public Object getElementAt(int index) {
			updateEntries();
			return filteredEntries.get(index);
		}

		private void updateEntries() {
			if (filteredEntries == null) {
				filteredEntries = new ArrayList<TelephoneRecord>(10);
				for (int i = 0; i < tdlm.getSize(); i++) {
					TelephoneRecord trCurrent = (TelephoneRecord) tdlm
							.getElementAt(i);
					if (pass(trCurrent)) {
						filteredEntries.add(trCurrent);
					}
				}
			}
		}

		@Override
		public void intervalAdded(ListDataEvent e) {
			update();
		}

		@Override
		public void intervalRemoved(ListDataEvent e) {
			update();
		}

		@Override
		public void contentsChanged(ListDataEvent e) {
			update();
		}

		protected void update() {
			filteredEntries = null;
			fireContentsChanged(this, 0, getSize() - 1);
		}

		protected abstract boolean pass(TelephoneRecord tr);
	}

	@SuppressWarnings("serial")
	private static class TDListNameFilter extends TDListFilter {
		private String sNameMatch = "";

		@SuppressWarnings("rawtypes")
		public TDListNameFilter(ListModel lmBase) {
			super(lmBase);
		}

		@Override
		protected boolean pass(TelephoneRecord tr) {
			return tr.getName().startsWith(sNameMatch);
		}

		public void setNameMatch(String sNameMatch) {
			this.sNameMatch = ((sNameMatch == null) ? "" : sNameMatch);
			update();
		}
	};

	/**
	 * Construct a new front end.
	 */
	public Main() {
		super("TelephoneDirectory");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tdDirectory = new TelephoneDirectory();

		initWidgets();
	}

	/**
	 * Set up the widget structure of this frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initWidgets() {
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());

		JPanel jpInputArea = new JPanel(new FlowLayout());
		pane.add(jpInputArea, BorderLayout.NORTH);

		final JTextField jtfName = new JTextField(60);
		jpInputArea.add(new JLabel("Name:"));
		jpInputArea.add(jtfName);

		final JTextField jtfNumber = new JTextField(20);
		jpInputArea.add(new JLabel("Phone Number:"));
		jpInputArea.add(jtfNumber);

		JButton jbAdd = new JButton("Add");
		jbAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tdDirectory.addRecord(jtfName.getText(), jtfNumber.getText());
				jtfName.setText("");
				jtfNumber.setText("");
			}
		});
		jpInputArea.add(jbAdd);

		TDListModel tdlmBase = new TDListModel();
		final TDListNameFilter tdlfNameFilter = new TDListNameFilter(tdlmBase);
		final JList jlEntries = new JList(tdlfNameFilter);
		jlEntries.setCellRenderer(new ListCellRenderer() {
			JLabel jlRenderer = new JLabel();
			{
				jlRenderer.setFont(jlRenderer.getFont().deriveFont(Font.PLAIN));
				jlRenderer.setOpaque(true);
			}

			@Override
			public Component getListCellRendererComponent(JList list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				TelephoneRecord tr = (TelephoneRecord) value;
				jlRenderer.setText("<html><b>" + tr.getName() + "</b> ("
						+ tr.getNumber() + ")</html>");
				jlRenderer.setBackground(isSelected ? list
						.getSelectionBackground() : list.getBackground());
				jlRenderer.setForeground(isSelected ? list
						.getSelectionForeground() : list.getForeground());
				return jlRenderer;
			}
		});
		// Handle double clicks to trigger editing
		jlEntries.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int index = jlEntries.locationToIndex(e.getPoint());
					if (jlEntries.getCellBounds(index, index).contains(e.getPoint())) {
						TelephoneRecord tr = (TelephoneRecord) jlEntries.getModel().getElementAt(index);
						editRecord (tr);
					}
				}
			}
			
		});
		pane.add(new JScrollPane(jlEntries), BorderLayout.CENTER);

		JPanel jpFilters = new JPanel();
		pane.add(jpFilters, BorderLayout.SOUTH);

		jpFilters.add(new JLabel("Filter by:"));

		final JTextField jtfFilterText = new JTextField(60);
		jtfFilterText.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateFilter();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateFilter();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateFilter();
			}

			private void updateFilter() {
				tdlfNameFilter.setNameMatch(jtfFilterText.getText());
			}
		});
		jpFilters.add(jtfFilterText);

		pack();
	}

	/**
	 * Open a modal window to edit the given record, then update the directory with the new information.
	 * 
	 * @param tr
	 */
	protected void editRecord(TelephoneRecord tr) {
		String sEditedNumber = JOptionPane.showInputDialog(this, "Edit number for " + tr.getName(), tr.getNumber());
		if (sEditedNumber != null) {
			tdDirectory.update (tr.getName(), sEditedNumber);
		}
	}

	public static void main(String[] args) {
		new Main().setVisible(true);
	}
}