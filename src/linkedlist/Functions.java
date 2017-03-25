package linkedlist;

public class Functions extends LinkedList {

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

		llist.isCyclic();
	}

}
