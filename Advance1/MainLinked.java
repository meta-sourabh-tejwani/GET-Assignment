class Node {
	private String name;
	private Node previous;
	private int salary;
	private int age;
	private Node next;

	Node(int salary, int age, String name) {
		this.salary = salary;
		this.age = age;
		this.next = null;
		this.previous = null;
		this.name = name;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public int getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
}

class EmployeeLinkedList {
	private Node head;

	EmployeeLinkedList() {
		this.head = null;
	}

	/**
	 * Add The Employee in the Linked List
	 * 
	 * @param salary
	 *            contain salary of employee
	 * @param age
	 *            contain age of employee
	 * @param name
	 *            contain name of employee
	 */
	public void add(int salary, int age, String name) {
		Node create = new Node(salary, age, name);
		if (head == null) {
			head = create;
		} else {
			Node visitnode = head;
			while (visitnode.getNext() != null) {
				visitnode = visitnode.getNext();
			}
			visitnode.setNext(create);
			create.setPrevious(visitnode);
		}
	}

	/**
	 * Display The Data present in the LinkedList
	 */
	public void display() {
		Node visit = head;
		while (visit != null) {
			System.out.println("Name = " + visit.getName() + " age="
					+ visit.getAge() + " salary= " + visit.getSalary());
			visit = visit.getNext();
		}
	}

	/**
	 * Sort The Linked List By using insertion sort
	 */
	public void insertionSort() {
		Node compare = head;
		while (compare != null) {
			Node pre = compare.getPrevious();
			while (pre != null) {
				if (pre.getSalary() < compare.getSalary()) {
					compare.setPrevious(pre.getPrevious());
					pre.setPrevious(compare);
					pre.setNext(compare.getNext());
					compare.setNext(pre);
					if (compare.getPrevious() == null)
						head = compare;
					pre = compare.getPrevious();

				} else if (pre.getSalary() == compare.getSalary()) {
					if (compare.getAge() < pre.getAge()) {
						compare.setPrevious(pre.getPrevious());
						pre.setPrevious(compare);
						pre.setNext(compare.getNext());
						compare.setNext(pre);
						pre = compare.getPrevious();
						if (compare.getPrevious() == null)
							head = compare;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			compare = compare.getNext();
		}
	}
}

public class MainLinked {
	public static void main(String... k) {
		EmployeeLinkedList e = new EmployeeLinkedList();
		e.add(12000, 21, "sourabh");
		e.add(22000, 23, "avi");
		e.add(22000, 21, "monu");
		e.add(21000, 23, "ravi");
		e.add(11000, 23, "rohit");
		e.add(10000, 11, "rahul");
		System.out.println("before sorted");
		e.display();
		System.out.println("After sort");
		e.insertionSort();
		e.display();
	}
}
