class Position {
	public static int position = 1;
}

class Node<T> {
	private int position;
	private Node<T> next;
	private T value;

	Node(T value) {
		this.value = value;
		this.position = Position.position++;
		this.next = null;
	}

	public String toString() {
		return "node-" + value.toString();
	}

	public int getPosition() {
		return position;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setValue(T value) {
		this.value = value;
	}
}

class LinkedList<T> {
	public Node<T> head;

	LinkedList() {
		head = null;
	}

	// add element in the list
	public void addElement(T value) {
		Node<T> node = new Node<T>(value);
		if (head == null) {
			head = node;
		} else {
			Node<T> lastNode = head;
			while (lastNode.getNext() != null) {
				lastNode = lastNode.getNext();
			}
			lastNode.setNext(node);
		}
	}

	public String toString() {
		StringBuilder string = new StringBuilder("Linked List-");
		Node<T> temp = head;
		while (temp != null) {
			string.append(temp.toString() + ",");
			temp = temp.getNext();
		}
		return string.toString();
	}

	// set position of each element
	public void setPosition() {
		Node<T> retriveNode = head;
		int count = 0;
		while (retriveNode != null) {
			retriveNode.setPosition(count++);
			retriveNode = retriveNode.getNext();
		}
	}

	// display the list element
	public void display() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.print(temp.getValue() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	// rotate the list with n times from left to right element
	public void rotate(int left, int right, int n) {
		int total = right - left + 1;
		total = (total + n) % total;
		Node<T> previousLeft = head, PreviousRight = head;
		while (previousLeft.getNext().getPosition() != left) {
			previousLeft = previousLeft.getNext();
		}
		while (PreviousRight.getNext().getPosition() != right) {
			PreviousRight = PreviousRight.getNext();
		}
		while (total != 0) {
			Node<T> currentRight, currentLeft;
			currentRight = PreviousRight.getNext();
			PreviousRight.setNext(currentRight.getNext());
			currentLeft = previousLeft.getNext();
			previousLeft.setNext(currentRight);
			currentRight.setNext(currentLeft);
			currentRight = head;
			while (currentRight.getNext().getValue() != PreviousRight
					.getValue()) {
				currentRight = currentRight.getNext();
			}
			PreviousRight = currentRight;
			total--;
		}
		setPosition();
	}

	public boolean checkLoop() {
		Node<T> temp = head;
		int count = 1;
		while (temp != null) {
			if (temp.getPosition() < count++) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

}

public class LinkedListExample {
	public static void main(String... k) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.addElement(2);
		l.addElement(3);
		l.addElement(4);
		l.addElement(5);
		l.addElement(6);
		l.addElement(7);
		l.display();
		l.rotate(5, 6, 5);
		l.display();
	}
}