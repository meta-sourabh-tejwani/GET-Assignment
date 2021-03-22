import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class TreeNode {
	private TreeNode previous;
	private String dirname;
	private List<TreeNode> child = new ArrayList<>();
	private Date createdate;

	TreeNode(String dirname) {

		this.dirname = dirname;
		this.previous = null;
		this.createdate = new Date();
	}

	/**
	 * @return the previous node address
	 */
	public TreeNode getPrevious() {
		return previous;
	}

	/**
	 * @return the date of created node
	 */
	public String returnDate() {
		return createdate.toString();
	}

	/**
	 * @param previous
	 *            set the value of previous node
	 */
	public void setPrevious(TreeNode previous) {
		this.previous = previous;
	}

	/**
	 * @param node
	 *            contain the child node and add them
	 */
	public void addChild(TreeNode node) {
		child.add(node);
	}

	/**
	 * @return the directory name
	 */
	public String getDirName() {
		return dirname;
	}

	/**
	 * @return child nodes
	 */
	public List<TreeNode> getChild() {
		return child;
	}
}

class VirtualCommandPrompt {
	public TreeNode root;

	VirtualCommandPrompt() {
		root = new TreeNode("R:");
		System.out.println("Welcome to the virtual command prompt");
	}

	/**
	 * The method is used to create virtual directory and return the result in
	 * string
	 * 
	 * @param dirname
	 *            contain the directory name
	 * @return the string which define error when there is error else return
	 *         blank screen
	 */
	public String createDirectory(String dirname) {
		String error = "directory created";
		List<TreeNode> l = root.getChild();
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getDirName().equals(dirname)) {
				root = l.get(i);
				error += "directory already present";
				return error;
			}
		}
		TreeNode newdir = new TreeNode(dirname);
		newdir.setPrevious(root);
		root.addChild(newdir);
		return error;
	}

	/**
	 * change the current directory to child directory if present
	 * 
	 * @param dirname
	 *            is which directory we moved
	 * @return the result of operation
	 */
	public String changeDirectory(String dirname) {
		String error = "";
		List<TreeNode> l = root.getChild();
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getDirName().equals(dirname)) {
				root = l.get(i);
				return error;
			}
		}
		error += "directory not found";
		return error;
	}

	/**
	 * change the current directory to parent directory
	 * 
	 * @return the result in string value
	 */
	public String back() {
		String error = "";
		if (root.getPrevious() == null)
			error += "already in root directory";
		else
			root = root.getPrevious();
		return error;
	}

	/**
	 * Show the data of current directory
	 * 
	 * @return list of that data
	 */
	public List<String> displayData() {
		List<String> data = new ArrayList<>();
		String datawithtime = "";
		for (int i = 0; i < root.getChild().size(); i++) {
			datawithtime += root.getChild().get(i).returnDate() + "   "
					+ root.getChild().get(i).getDirName() + "   "
					+ root.getChild().get(i).getChild().size() + " Folders";
			data.add(datawithtime);
			datawithtime = "";
		}
		return data;
	}

	/**
	 * It is used to find the location of particular directory
	 * 
	 * @param name
	 *            contain the directory name
	 * @return the list of data where the directory find
	 */
	public List<String> find(String name) {
		List<String> s = new ArrayList<>();
		int i = 0;
		checkAllFolder(name, i, root, s, 0);
		for (i = 0; i < s.size(); i++) {
			System.out.println(s.get(i));
		}
		return s;

	}

	public String getName(TreeNode current) {
		String dirname = "";
		while (current != root) {
			dirname = "\\" + current.getDirName() + dirname;
			current = current.getPrevious();
		}
		return (".." + dirname);
	}

	/**
	 * @param name
	 *            find the directory name
	 * @param index
	 *            contain the current child node index
	 * @param current
	 *            contain the current node
	 * @param s
	 *            contain the list of position where the name was found
	 * @param childindex
	 *            contain the child index of parent node
	 */
	public void checkAllFolder(String name, int index, TreeNode current,
			List<String> s, int childindex) {
		if (current.getChild().size() <= childindex) {
			return;
		} else if (current.getChild().get(childindex).getDirName().equals(name)) {
			s.add(getName(current));
		}
		checkAllFolder(name, index, current.getChild().get(childindex), s,
				childindex);
		while (index + 1 < current.getChild().size()) {
			if (current.getChild().get(index + 1).getDirName().equals(name)) {
				s.add(getName(current));
			}
			index += 1;
			checkAllFolder(name, index, current.getChild().get(index), s, 0);
		}
	}

	/**
	 * It show the tree structure of node
	 */
	public void treeCommand() {
		showTree(root, 0, 0, 0, root);
	}

	/**
	 * Show the tree representation
	 * 
	 * @param current
	 *            represent the current visit node
	 * @param index
	 *            contain the index of child node
	 * @param check
	 *            where it is repeat or not
	 * @param count
	 *            check the space in tree manner
	 * @param root
	 *            contain the root directory of current node
	 */
	public void showTree(TreeNode current, int index, int check, int count,
			TreeNode root) {
		if (check == 0) {
			System.out.println(current.getDirName());
			if (current.getChild().size() > index
					&& current.getChild().size() != 0) {
				for (int i = 0; i < 5 * count; i++)
					System.out.print(" ");
				System.out.print('\u2514');
				for (int i = 0; i < 5; i++)
					System.out.print('\u2500');
			}
		}
		if (current.getChild().size() <= index) {
			return;
		} else if (check == 1 && current == root && current != this.root) {
			for (int i = 0; i < 5 * count; i++)
				System.out.print(" ");
			System.out.print('\u2514');
			for (int i = 0; i < 5; i++)
				System.out.print('\u2500');
		} else if (current == this.root && check == 1) {
			System.out.print('\u2514');
			for (int i = 0; i < 5; i++)
				System.out.print('\u2500');
		}
		showTree(current.getChild().get(index), 0, 0, count + 1, current);
		showTree(current, index + 1, 1, count, current);
	}

	/**
	 * @return the present directory
	 */
	public String presentDirectory() {
		String dir = "";
		TreeNode reverse = root;
		while (reverse != null) {
			if (reverse.getPrevious() == null)
				dir = reverse.getDirName() + dir;
			else
				dir = ("\\" + reverse.getDirName() + dir);
			reverse = reverse.getPrevious();
		}
		return dir;
	}

}

public class VirtualCommand {
	public static void main(String... k) {
		Scanner sc = new Scanner(System.in);
		VirtualCommandPrompt v = new VirtualCommandPrompt();
		String command[];
		while (true) {
			System.out.print(v.presentDirectory() + "> ");
			command = sc.nextLine().split(" ");
			if (command[0].equals("mkdir")) {
				if (command.length == 1) {
					System.out
							.println("The syntax of the command is incorrect.");
				} else {
					System.out.println(v.createDirectory(command[1]));
				}
			} else if (command[0].equals("cd")) {
				if (command.length == 1) {
					System.out
							.println("The syntax of the command is incorrect.");
				} else {
					System.out.println(v.changeDirectory(command[1]));
				}
			} else if (command[0].equals("ls") && command.length == 1) {
				List<String> data = v.displayData();
				for (int i = 0; i < data.size(); i++) {
					System.out.println(data.get(i));
				}
			} else if (command[0].equals("bk") && command.length == 1) {
				System.out.println(v.back());
			} else if (command[0].equals("find") && command.length == 2) {
				v.find(command[1]);
			} else if (command[0].equals("tree") && command.length == 1) {
				v.treeCommand();
			} else if (command[0].equals("exit") && command.length == 1) {
				break;
			} else {
				System.out.println("command not found..");
			}
		}
		sc.close();
	}
}
