import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GUIWindow extends JFrame {
	final JTextArea jtInputText = new JTextArea(30, 40);
	final JLabel jlIndex = new JLabel();

	private static final long serialVersionUID = -4156984126105636689L;

	public GUIWindow() {
		super("Flesch's Reading Index");
		setSize(515, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initWidgets();
	}

	private void initWidgets() {
		JButton jbEnter = new JButton("Flesch It");
		JScrollPane jspInputText = new JScrollPane(jtInputText);
		setLayout(new BorderLayout());
		final JPanel jpSouth = new JPanel();
		jpSouth.setLayout(new GridLayout(1, 2));
		add(jspInputText, BorderLayout.CENTER);
		add(jpSouth, BorderLayout.SOUTH);
		jpSouth.add(jbEnter);
		jpSouth.add(jlIndex);
		jtInputText.setLineWrap(true);
		jtInputText.getDocument().addDocumentListener(new FleschChanged());
		jtInputText.putClientProperty("name", "Text Area");

		jbEnter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		pack();

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
			for(String line : lines) {
				StringTokenizer st = new StringTokenizer(line, " ");
				
				while(st.hasMoreTokens()){
					String token = (String)st.nextToken();
					w.addWord(token);
				}
			}
			
			d.add(w);
			double index = d.getIndex();
			if(index == Double.NEGATIVE_INFINITY || index == Double.POSITIVE_INFINITY || index == Double.NaN) {
				index = 0;
			}
			jlIndex.setText(index + "");
			
		}
		
	}

}
