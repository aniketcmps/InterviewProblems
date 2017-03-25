package linkedlist;

public class Functions extends LinkedList {

	/**
	 * There are two singly linked lists in a system. By some programming error
	 * the end node of one of the linked list got linked into the second list,
	 * forming a inverted Y shaped list. Write a program to get the point where
	 * two linked list merge.
	 * 
	 */
	static Node head1, head2;

	public int getIntersection() {
		int count1 = getCount(head1);
		int count2 = getCount(head2);
		if (count1 > count2) {
			return intersectionNode((count1 - count2), head1, head2);
		} else {
			return intersectionNode((count2 - count1), head2, head1);
		}
	}

	public int intersectionNode(int headStart, Node list1, Node list2) {
		Node current1 = list1;
		Node current2 = list2;

		if (current1 != null && current2 != null) {
			for (int i = 0; i < headStart; i++) {
				current1 = current1.next;
			}

			while (current1 != null && current2 != null) {
				if (current1.data == current2.data) {
					return current1.data;
				}
				current1 = current1.next;
				current2 = current2.next;
			}
		}
		return -1;
	}

	/**
	 * Find kth node from the end of the list
	 */
	public void elementFromEnd(int k) {
		Node pointer = head;
		Node refPointer = head;
		int counter = 0;
		if (head != null) {
			while (counter < k) {
				if (refPointer == null) {
					System.out.println(k + " elements are not present in the linked list");
					return;
				} else {
					refPointer = refPointer.next;
					counter++;
				}
			}

			while (refPointer != null) {
				pointer = pointer.next;
				refPointer = refPointer.next;
			}
			System.out.println("kth element from end is " + pointer.data);
		}
	}

	/**
	 * Check if the Singly linked list is cyclic
	 */
	public boolean isCyclic() {
		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				System.out.println("Loop detected");
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Functions llist = new Functions();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(35);
		// llist.elementFromEnd(4);

		// Create loop for testing
		// llist.head.next.next.next.next = llist.head;

		// llist.isCyclic();

		Functions list = new Functions();
		list.head1 = new Node(3);
		list.head1.next = new Node(6);
		list.head1.next.next = new Node(15);
		list.head1.next.next.next = new Node(15);
		list.head1.next.next.next.next = new Node(30);

		// creating second linked list
		list.head2 = new Node(10);
		list.head2.next = new Node(15);
		list.head2.next.next = new Node(30);
		System.out.println("The node of intersection is " + list.getIntersection());
	}

}
