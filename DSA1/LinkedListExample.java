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

	public void addElement(T value) {
		Node<T> node = new Node<T>(value);
		if (head == null) {
			head = node;
		} else {
			Node<T> temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
	}

	public void setPosition() {
		Node<T> temp = head;
		int count = 1;
		while (temp != null) {
			temp.setPosition(count++);
			temp = temp.getNext();
		}
	}

	public void display() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.print(temp.getValue() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	public void rotate(int left, int right, int n) {
		int total = right - left + 1;
		total = (total + n) % total;
		Node<T> temp1 = head, temp2 = head;
		while (temp1.getNext().getPosition() != left) {
			temp1 = temp1.getNext();
		}
		while (temp2.getNext().getPosition() != right) {
			temp2 = temp2.getNext();
		}
		while (total != 0) {
			Node<T> temp3, temp4;
			temp3 = temp2.getNext();
			temp2.setNext(temp3.getNext());
			temp4 = temp1.getNext();
			temp1.setNext(temp3);
			temp3.setNext(temp4);
			temp3 = head;
			while (temp3.getNext().getValue() != temp2.getValue()) {
				temp3 = temp3.getNext();
			}
			temp2 = temp3;
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
		l.rotate(2, 5, 3);
		l.display();
	}
}