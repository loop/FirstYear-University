import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JOptionPane;

public class GUIWindow extends JFrame {
	final JTextArea jtInputText = new JTextArea(30, 40);
	final JLabel jlIndex = new JLabel();
	JFileChooser chooser = new JFileChooser();

	private static final long serialVersionUID = -4156984126105636689L;

	public GUIWindow() {
		super("Flesch's Reading Index");
		setSize(515, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initWidgets();
	}

	private void initWidgets() {
		JMenuBar menubar = new JMenuBar();
		JScrollPane jspInputText = new JScrollPane(jtInputText);
		setLayout(new BorderLayout());
		final JPanel jpSouth = new JPanel();
		jpSouth.setLayout(new GridLayout(1, 2));
		add(jspInputText, BorderLayout.CENTER);
		add(jpSouth, BorderLayout.SOUTH);
		jpSouth.add(jlIndex);
		menubar.setVisible(true);

		setJMenuBar(menubar);

		JMenu jmFile = new JMenu("File");
		menubar.add(jmFile);

		JMenuItem jmiopen = new JMenuItem("Open");
		jmiopen.addActionListener(new OpenFileListener());
		jmFile.add(jmiopen);

		jtInputText.setLineWrap(true);
		jtInputText.getDocument().addDocumentListener(new FleschChanged());
		jtInputText.putClientProperty("name", "Text Area");
		pack();

	}

	class OpenFileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			chooser.setDialogTitle("Open");

			int state = chooser.showOpenDialog(null);
			File file = chooser.getSelectedFile();

			if (file != null && state == JFileChooser.APPROVE_OPTION) {
				Scanner in;
				try {
					in = new Scanner(file);
					String line;
					while (in.hasNextLine()) {
						line = in.nextLine();
						String old = jtInputText.getText();
						if (!old.equals(""))
							jtInputText.setText(old + "\n" + line);
						else
							jtInputText.setText(line);
					}
					in.close();
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Cant read the file!");
				}
			}

		}

	}

	class FleschChanged implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent e) {
			updateFlesch();

		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			updateFlesch();

		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			updateFlesch();

		}

		private void updateFlesch() {
			Document d = new Document();
			Word w = new Word();

			String input = jtInputText.getText();
			String[] lines = input.split("\n");
			for (String line : lines) {
				StringTokenizer st = new StringTokenizer(line, " ");

				while (st.hasMoreTokens()) {
					String token = (String) st.nextToken();
					w.addWord(token);
				}
			}

			d.add(w);
			double index = d.getIndex();
			if (index == Double.NEGATIVE_INFINITY
					|| index == Double.POSITIVE_INFINITY || index == Double.NaN) {
				index = 0;
			}
			jlIndex.setText(index + "");

		}

	}

}
