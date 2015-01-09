import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test extends JFrame {
	public Test() {
		super("MayExams 2010/11");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel jpTop = new JPanel(new BorderLayout());
		c.add(jpTop, BorderLayout.NORTH);
		jpTop.add(new JLabel("Make a choice: "), BorderLayout.WEST);
		JComboBox jcbChoices = new JComboBox(new String[] { "Hello", "World",
				"This", "Is", "Fun!" });
		jpTop.add(jcbChoices, BorderLayout.CENTER);
		JButton jbAdd = new JButton("Add");
		jpTop.add(jbAdd, BorderLayout.EAST);
		JTextArea jta = new JTextArea(5, 70);
		c.add(new JScrollPane(jta), BorderLayout.CENTER);
		JPanel jpBottom = new JPanel(new FlowLayout());
		c.add(jpBottom, BorderLayout.SOUTH);
		jpBottom.add(new JButton("OK"));
		jpBottom.add(new JButton("Cancel"));
		pack();

	}

	public static void main(String[] args) {
		new Test().setVisible(true);
	}
}