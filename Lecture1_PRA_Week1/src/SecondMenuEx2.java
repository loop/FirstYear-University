import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class SecondMenuEx2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem new1 = new JMenuItem("New");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");
		window.setTitle("My Application");
		menu.add(file);
		file.add(new1);
		file.add(open);
		file.add(save);
		file.add(exit);
		window.setSize(400,500);
		window.setJMenuBar(menu);
		window.setVisible(true);


	}

}
