package tree;

import java.util.ArrayList;
import java.util.List;

class BST {
	Node root;

	BST() {
		root = null;
	}

	// Insert using recursive approach
	public Node insertRec(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		} else {
			if (root.data > value) {
				root.left = insertRec(root.left, value);
			} else if (root.data < value) {
				root.right = insertRec(root.right, value);
			} else {
				System.out.println("Duplicate");
			}
			return root;
		}
	}

	// Insert function
	public void insert(int value) {
		// root = insertRec(root, value);
		Node n = new Node(value);
		root = insertIterative(root, n);
	}

	// Insert using iterative approach
	public Node insertIterative(Node root, Node node) {
		if (root == null) {
			root = node;
			return root;
		}

		Node n = root;
		while (true) {
			if (n.data > node.data) {
				if (n.left != null)
					n = n.left;
				else {
					n.left = node;
					break;
				}
			} else if (n.data < node.data) {
				if (n.right != null)
					n = n.right;
				else {
					n.right = node;
					break;
				}
			} else {
				System.out.println("Duplicate");
				break;
			}
		}
		return root;
	}

	// Search key in BST
	private void search(int key) {
		Node n = search(root, key);
		if (n == null) {
			System.out.println("Not present");
		} else {
			System.out.println("found " + n.data);
		}
	}

	public Node search(Node root, int key) {
		if (root == null || root.data == key) {
			return root;
		}

		if (key < root.data) {
			return search(root.left, key);
		} else {
			return search(root.right, key);
		}
	}

	// Inorder tree traversal
	public void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}

	public void inorder() {
		inorder(root);
	}

	// Delete a key from BST
	public void delete(int key) {
		root = deleteRec(root, key);
	}

	public Node deleteRec(Node root, int key) {
		if (root == null) {
			return root;
		}

		if (key < root.data) {
			root.left = deleteRec(root.left, key);
		} else if (key > root.data) {
			root.right = deleteRec(root.right, key);
		} else {
			if (root.left == null) {
				root = root.right;
			} else if (root.right == null) {
				root = root.left;
			} else {
				root.data = successor(root.right);
				root.right = deleteRec(root.right, root.data);
			}
		}
		return root;
	}

	// Find value of successor of given node i.e left most element of right
	// sub-tree
	public int successor(Node n) {
		// int successor = n.data;
		while (n.left != null) {
			// successor = n.left.data;
			n = n.left;
		}
		return n.data;// successor;
	}

	// Check if tree is BST
	public boolean isBST() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data < min || node.data > max) {
			return false;
		}
		return (isBST(node.left, min, node.data - 1) && isBST(node.right, node.data + 1, max));
	}

	// Find lowest common ancestor for 2 values assuming they are present in BST
	public Node lca(Node node, int key1, int key2) {
		if (node == null) {
			return null;
		}
		if (node.data > key1 && node.data > key2) {
			return lca(node.left, key1, key2);
		}
		if (node.data < key1 && node.data < key2) {
			return lca(node.right, key1, key2);
		}
		return node;
	}

	// k-th smallest element in given tree
	public void ksmallest(int k) {
		List<Node> list = new ArrayList<Node>();
		list = traverse(root, list);

		if (k > list.size()) {
			System.out.println("Not possible. Tree has only " + list.size() + " elements");
		}
		System.out.println(k + " smallest element is " + list.get(k - 1).data);
	}

	public ArrayList<Node> traverse(Node n, List<Node> list) {
		if (n != null) {
			traverse(n.left, list);
			list.add(n);
			traverse(n.right, list);
		}
		return (ArrayList<Node>) list;
	}

	public static void main(String args[]) {
		BST tree = new BST();

		tree.insert(50);
		tree.insert(70);
		tree.insert(30);
		tree.insert(30);
		tree.insert(10);
		tree.insert(100);
		tree.insert(40);
		tree.insert(60);
		tree.ksmallest(6);

		tree.inorder();

		tree.search(30);
		tree.delete(10);
		tree.inorder();
		System.out.println("----------");
		tree.delete(30);
		tree.inorder();
		System.out.println("----------");
		tree.delete(70);
		tree.inorder();
		System.out.println("----------");

		System.out.println("is BST? " + tree.isBST());

	}
}