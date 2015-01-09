import java.awt.*;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Exercise");
		myFrame.setSize(300, 200);
		JLabel jlName = new JLabel("Name:");
		JLabel jlPwd = new JLabel("Password:");
		JLabel jlMessage = new JLabel("Message:");
		JTextField jtfName = new JTextField("Steffen Zschaler");
		JPasswordField jpwPwd = new JPasswordField(20);
		JTextArea jtaMessage = new JTextArea(20, 3);
		JRadioButton jrbPublic = new JRadioButton("Public Computer");
		JRadioButton jrbPrivate = new JRadioButton("Private Computer");
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbPublic);
		bg.add(jrbPrivate);
		jrbPublic.setSelected(true);
		JButton jbOK = new JButton("OK");
		JButton jbCancel = new JButton("Cancel");
		myFrame.getContentPane().setLayout(new BorderLayout());
		JPanel jpTop = new JPanel(new GridLayout(4, 2));
		myFrame.getContentPane().add(jpTop, BorderLayout.CENTER);
		jpTop.add(jlName);
		jpTop.add(jtfName);
		jpTop.add(jlPwd);
		jpTop.add(jpwPwd);
		jpTop.add(jrbPublic);
		jpTop.add(jrbPrivate);
		jpTop.add(jlMessage);
		jpTop.add(jtaMessage);
		JPanel jpBottom = new JPanel(new FlowLayout());
		myFrame.getContentPane().add(jpBottom, BorderLayout.SOUTH);
		jpBottom.add(jbOK);
		jpBottom.add(jbCancel);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}