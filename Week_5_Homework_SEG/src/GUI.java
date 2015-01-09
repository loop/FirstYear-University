import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4882782370471106400L;
	private JButton generateBoolean, generateInteger;
	private JLabel displayText;

	public GUI() {
		super("Random Boolean and Integer Generator");
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initWidgets();

	}

	private void initWidgets() {
		setLayout(new GridLayout(3, 1));
		generateBoolean = new JButton("Generate Boolean");
		generateInteger = new JButton("Generate Integer");
		displayText = new JLabel();
		add(displayText);
		add(generateBoolean);
		add(generateInteger);

		generateBoolean.addActionListener(this);
		generateInteger.addActionListener(this);

		pack();

	}

	protected void generateInteger() {
		Random r = new Random();
		int randomInt = r.nextInt(100);
		displayText.setText(Integer.toString(randomInt));
	}

	private void generateBoolean() {
		Random r = new Random();
		boolean randomBoolean = r.nextBoolean();
		displayText.setText(Boolean.toString(randomBoolean));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == generateBoolean) {
			generateBoolean();
		} else if (e.getSource() == generateInteger) {
			generateInteger();
		}

	}

}
