package linkedlist;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}
}

public class LinkedList {
	Node head;

	LinkedList() {
		head = null;
	}

	// Insertion
	LinkedList(int data) {
		head = new Node(data);
	}

	public void push(int data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
	}

	public void add(int data) {
		Node n = new Node(data);

		if (head == null) {
			head = n;
		} else {
			Node temp = head;

			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
		}
	}

	public void addAfter(Node previous, int data) {
		Node n = new Node(data);
		n.next = previous.next;
		previous.next = n;
	}

	// Deletion
	public void delete(int key) {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		if (head.data == key) {
			head = head.next;
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			if (temp.next.data == key) {
				temp.next = temp.next.next;
				return;
			}
			temp = temp.next;
		}
		System.out.println("Node not present");
	}

	public void deleteAt(int position) {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		if (position == 1) {
			head = head.next;
			return;
		}

		Node previous = null;
		Node temp = head;
		int key = 1;

		while (temp != null && key < position) {
			previous = temp;
			temp = temp.next;
			key++;
		}

		if (temp == null) {
			System.out.println("Element not present in Linked List");
		} else {
			previous.next = temp.next;
		}
	}

	// Delete entire list
	void deleteList() {
		head = null;
	}

	// Find length of Linked List
	public int length() {
		int length = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			length++;
		}
		return length;
	}

	public int getCount(Node n) {
		if (n == null) {
			return 0;
		} else {
			return 1 + getCount(n.next);
		}
	}

	public int lengthRec() {
		return getCount(head);
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print("\n");
	}

	// Reverse the linked list
	public Node reverse() {
		Node previous = null;
		Node current = head;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		return previous;
	}

	/**
	 * Given a linked list and two keys in it, swap nodes for two given keys.
	 * Nodes should be swapped by changing links. Swapping data of nodes may be
	 * expensive in many situations when data contains many fields.
	 */
	public void swap(int a, int b) {
		if (a == b) {
			return; // Same node
		}

		Node prevA = null;
		Node currA = head;
		while (currA != null && currA.data != a) {
			prevA = currA;
			currA = currA.next;
		}

		Node prevB = null;
		Node currB = head;
		while (currB != null && currB.data != b) {
			prevB = currB;
			currB = currB.next;
		}

		if (currA == null || currB == null) {
			return; // Node not present
		}

		if (prevA != null) {
			prevA.next = currB;
		} else {
			head = currB; // A was head
		}

		if (prevB != null) {
			prevB.next = currA;
		} else {
			head = currA; // B was head
		}

		// swap the next pointers of a and b
		Node temp = currA.next;
		currA.next = currB.next;
		currB.next = temp;
	}

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.add(6);
		llist.push(7);
		llist.push(1);
		llist.add(4);
		llist.addAfter(llist.head.next, 8);
		System.out.println("\nCreated Linked list is: ");
		llist.printList();
		System.out.println("Length of the list is " + llist.length());

		System.out.println("\nAfter Reversing the Linkedlist ");
		llist.head = llist.reverse();
		llist.printList();

		System.out.println("\nAfter swapping 7 and 4 ");
		llist.swap(7, 4);
		llist.printList();

		System.out.println("\nAfter Deleting ");
		llist.delete(1);
		llist.delete(10);
		llist.deleteAt(2);
		llist.deleteAt(8);
		llist.printList();
		System.out.println("Length of the list is " + llist.lengthRec());

		System.out.println("After swapping 7 and 4 ");
		llist.swap(7, 4);
		llist.printList();
	}

}
