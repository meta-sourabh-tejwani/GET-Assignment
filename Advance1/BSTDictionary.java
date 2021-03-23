import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

class KeyValue {
	private int key;
	private String value;

	KeyValue(int key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the key of KeyValue pair
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @return the value of KeyValue pair
	 */
	public String getValue() {
		return value;
	}
}

class TreeNode {
	private KeyValue keyvalue;
	private TreeNode left;
	private TreeNode right;

	TreeNode(KeyValue key) {
		this.keyvalue = key;
		this.setLeft(null);
		this.setRight(null);
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public void setKeyValue(KeyValue keyvalue) {
		this.keyvalue = keyvalue;
	}

	public KeyValue getKeyValue() {
		return keyvalue;
	}

}

class BinarySearchTree {
	private TreeNode root;

	BinarySearchTree() {
		this.root = null;
	}

	BinarySearchTree(List<KeyValue> keys) {
		this();
		for (int i = 0; i < keys.size(); i++) {
			add(keys.get(i));
		}
	}

	/**
	 * Add The KeyValue pair in Binary Search Tree Format
	 * 
	 * @param keyvalue
	 *            contain the Key Value pair to add In BST
	 */
	public void add(KeyValue keyvalue) {
		TreeNode newnode = new TreeNode(keyvalue);
		if (root == null) {
			root = newnode;
		} else {
			TreeNode current = root;
			while (true) {
				if (current.getKeyValue().getKey() > newnode.getKeyValue()
						.getKey() && current.getLeft() == null) {
					current.setLeft(newnode);
					break;
				} else if (current.getKeyValue().getKey() < newnode
						.getKeyValue().getKey() && current.getRight() == null) {
					current.setRight(newnode);
					break;
				} else if (current.getKeyValue().getKey() > newnode
						.getKeyValue().getKey()) {
					current = current.getLeft();
				} else {
					current = current.getRight();
				}

			}
		}
	}

	/**
	 * Find the value of Key And Return the value
	 * 
	 * @param key
	 *            Contain the key of KeyValue Pair
	 * @return the Value of the key
	 */
	public String getValue(int key) {
		String value = "";
		TreeNode current = root;
		while (current != null) {
			if (key < current.getKeyValue().getKey()) {
				current = current.getLeft();
			} else if (key > current.getKeyValue().getKey()) {
				current = current.getRight();
			} else {
				value = current.getKeyValue().getValue();
				break;
			}
		}
		return value;
	}

	/**
	 * Add the keyValue in inorder traversal
	 * 
	 * @param current
	 *            show the current node of BST
	 * @param pair
	 *            contain list of KeyValue pait
	 */
	private void inOrder(TreeNode current, List<KeyValue> pair) {
		if (current == null)
			return;
		inOrder(current.getLeft(), pair);
		pair.add(current.getKeyValue());
		inOrder(current.getRight(), pair);
	}

	/**
	 * Sort the list of key value
	 * 
	 * @return keyValue in sorted form of key
	 */
	public List<KeyValue> sorted() {
		List<KeyValue> pair = new ArrayList<>();
		inOrder(root, pair);
		return pair;
	}

	/**
	 * Traverse The tree and add Value from k1 to k2
	 * 
	 * @param current
	 *            show the current node
	 * @param pair
	 *            contain the list of key pair
	 * @param key1
	 *            contain the key1
	 * @param key2
	 *            contain the key2
	 */
	private void inOrder(TreeNode current, List<KeyValue> pair, int key1,
			int key2) {
		if (current == null)
			return;
		inOrder(current.getLeft(), pair, key1, key2);
		if (current.getKeyValue().getKey() >= key1
				&& current.getKeyValue().getKey() <= key2) {
			pair.add(current.getKeyValue());
		}
		inOrder(current.getRight(), pair, key1, key2);
	}

	public List<KeyValue> sorted(int key1, int key2) {
		List<KeyValue> pair = new ArrayList<>();
		inOrder(root, pair, key1, key2);
		return pair;
	}

	/**
	 * Delete The KeyValue pair
	 * 
	 * @param key
	 *            represent which keypair is deleted
	 */
	public void delete(int key) {
		root = deletenode(root, key);
	}

	/**
	 * Delete the KeyValue and return root
	 * 
	 * @param current
	 *            show the current KeyValue pair in BST
	 * @param key
	 *            represent the key is deleted
	 * @return node after deleting that node
	 */
	private TreeNode deletenode(TreeNode current, int key) {
		if (current == null)
			return current;
		if (key < current.getKeyValue().getKey()) {
			current.setLeft(deletenode(current.getLeft(), key));
		} else if (key > current.getKeyValue().getKey()) {
			current.setRight(deletenode(current.getRight(), key));
		} else {
			if (current.getLeft() == null) {
				return current.getRight();
			} else if (current.getRight() == null) {
				return current.getLeft();
			} else {
				current.setKeyValue(minnext(current.getRight()));
				current.setRight(deletenode(current.getRight(), current
						.getKeyValue().getKey()));
			}
		}
		return current;
	}

	private KeyValue minnext(TreeNode current) {
		KeyValue min = current.getKeyValue();
		while (current.getLeft() != null) {
			min = current.getLeft().getKeyValue();
			current = current.getLeft();
		}
		return min;
	}

	public void inOrder(TreeNode current) {
		if (current == null)
			return;
		inOrder(current.getLeft());
		System.out.println(current.getKeyValue().getKey() + " "
				+ current.getKeyValue().getValue());
		inOrder(current.getRight());
	}

	/**
	 * Display the data in In Order traversal
	 */
	public void display() {
		inOrder(root);
	}
}

public class BSTDictionary {
	public static void main(String... k) {
		List<KeyValue> result = new ArrayList<>();

		/**
		 * Accept the data from json file in the list
		 */
		try {
			String text = new String(
					Files.readAllBytes(Paths
							.get("C:\\Users\\sourabh.tejwani_meta\\Desktop\\student.json")),
					StandardCharsets.UTF_8);

			JSONObject obj = new JSONObject(text);
			Iterator<String> keys = obj.keys();
			while (keys.hasNext()) {
				String key = keys.next();
				result.add(new KeyValue(Integer.parseInt(key), obj.get(key)
						.toString()));
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		/**
		 * Create object of BST tree with some data in List
		 */
		BinarySearchTree bst = new BinarySearchTree(result);
		/*
		 * Display the Data
		 */
		bst.display();
		/*
		 * Delete the node in binary search tree
		 */
		bst.delete(1);
		System.out.println("After Deleting 1 Key.....");
		bst.display();
		bst.delete(10);
		System.out.println("After Deleting 10 Key.....");
		bst.display();
		System.out.println("Sorting from 7 To 15");
		List<KeyValue> b = bst.sorted(7, 15);
		for (int i = 0; i < b.size(); i++) {
			System.out.println(b.get(i).getKey() + " " + b.get(i).getValue());
		}
		System.out.println("Sorting....");
		b = bst.sorted();
		for (int i = 0; i < b.size(); i++) {
			System.out.println(b.get(i).getKey() + " " + b.get(i).getValue());
		}
		System.out.println(bst.getValue(11));
		BinarySearchTree bst1 = new BinarySearchTree();
		bst1.add(new KeyValue(1, "a"));
		bst1.add(new KeyValue(2, "b"));
		bst1.add(new KeyValue(3, "c"));
		bst1.add(new KeyValue(4, "d"));
		bst1.add(new KeyValue(-1, "e"));
		bst1.display();
		bst1.delete(1);
		bst1.display();

	}
}
