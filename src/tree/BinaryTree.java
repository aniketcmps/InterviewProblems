package tree;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
	Node root;

	BinaryTree() {
		root = null;
	}

	BinaryTree(int data) {
		root = new Node(data);
	}

	public void inorder(Node n) {
		if (n == null) {
			return;
		}
		inorder(n.left);
		System.out.println(n.data);
		inorder(n.right);
	}

	public void inorder() {
		inorder(root);
	}

	public void levelOrder() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			Node n = q.poll();
			System.out.println(n.data);
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}
	}

	public int height(Node n) {
		if (n == null) {
			return 0;
		}

		return (1 + Math.max(height(n.left), height(n.right)));
	}

	public int height() {
		return height(root);
	}

	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(5);
		bt.root.left = new Node(1);
		bt.root.left.right = new Node(3);
		bt.root.left.right.left = new Node(6);
		bt.root.right = new Node(11);
		bt.root.right.left = new Node(8);
		bt.root.right.right = new Node(18);

		// bt.inorder();
		// bt.levelOrder();
		System.out.println(bt.height());
	}
}
