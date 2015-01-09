import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyClass extends JFrame {
	public MyClass() {
		super("MayExams 2010/11");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel top = new JPanel(new BorderLayout());
		JLabel make = new JLabel("Make a choice:");
		String[] list = {"Hello","World","This","Is","Fun!"};
		final JComboBox listCB = new JComboBox(list);
		JButton add = new JButton("Add");
		top.add(make,BorderLayout.WEST);
		top.add(listCB,BorderLayout.CENTER);
		top.add(add,BorderLayout.EAST);
		
		c.add(top,BorderLayout.NORTH);
		final JTextArea text = new JTextArea(5,70);
		JScrollPane jsp = new JScrollPane(text);
		c.add(jsp,BorderLayout.CENTER);
		
		JPanel bottom = new JPanel(new FlowLayout());
		JButton ok = new JButton("OK");
		JButton cancel = new JButton("Cancel");
		bottom.add(ok);
		bottom.add(cancel);
		c.add(bottom,BorderLayout.SOUTH);
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.setText(text.getText() + listCB.getSelectedItem().toString() + "\n");
			}
		});
		pack();
	}

	public static void main(String[] args) {
		new MyClass().setVisible(true);
	}
}