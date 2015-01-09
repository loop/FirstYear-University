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


public class GUIWindow extends JFrame {
	
	private static final long serialVersionUID = -4156984126105636689L;

	public GUIWindow() {
		super("Flesch’s Reading Index");
		setSize(515,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initWidgets();
	}

	private void initWidgets() {
		final JTextArea jtInputText = new JTextArea(30, 40);
		JButton jbEnter = new JButton("Flesch It");
		JScrollPane jspInputText = new JScrollPane(jtInputText);
		setLayout(new BorderLayout());
		final JPanel jpSouth = new JPanel();
		jpSouth.setLayout(new GridLayout(1,2));
		add(jspInputText,BorderLayout.CENTER);
		add(jpSouth, BorderLayout.SOUTH);
		jpSouth.add(jbEnter);
		final JLabel jlIndex = new JLabel();
		jpSouth.add(jlIndex);
		jtInputText.setLineWrap(true);
		
		
		jbEnter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Document d = new Document();
				Word w = new Word();
				String text = jtInputText.getText();
				StringTokenizer st = new StringTokenizer(text," ");
				while ( st.hasMoreTokens() )
				{
				  String token = (String)st.nextToken();
				  w.addWord( token );		  
	     		}
				d.add( w );
	     	     jlIndex.setText(d.getIndex() + "");
	     	     
				
			}
		});
		pack();
		
		
		
	}
	
	

}
