import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class Action implements ActionListener {
	
	private JLabel total;
	private JTextField number1;
	private JTextField number2;
	
	public Action(JLabel total, JTextField number1, JTextField number2)
	{
		this.total = total;
		this.number1 = number1;
		this.number2 = number2;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		float n1,n2;
		n1 = Float.parseFloat(number1.getText());
		n2 = Float.parseFloat(number2.getText());
		total.setText("" + (n1 + n2));
	}

}
