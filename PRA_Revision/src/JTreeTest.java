import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;


public class JTreeTest extends JFrame {

	public JTreeTest(){
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("The Begining");
		JTree tree = new JTree(root);
		getContentPane().add(tree);
		DefaultMutableTreeNode Part1 = new DefaultMutableTreeNode("Part 1.1");
		DefaultMutableTreeNode Part2 = new DefaultMutableTreeNode("Part 1.2");
		DefaultMutableTreeNode Part3 = new DefaultMutableTreeNode("Part 1.3");
		DefaultMutableTreeNode Part4 = new DefaultMutableTreeNode("Part 1.4");

		root.add(Part1);
		root.add(Part2);
		root.add(Part3);
		root.add(Part4);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	public static void main(String[] args) {
		new JTreeTest().setVisible(true);

	}

}
