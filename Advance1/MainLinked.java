class Employee implements Comparable<Employee>{
	private String name;
	private int salary;
	private int age;

	Employee(String name, int salary, int age) {
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Employee employee) {
		if(this.salary>employee.salary)
			return 1;
		else if(this.salary==employee.salary)
		{
			if(this.age<employee.age)
				return 1;
			else if(this.age==employee.age)
				return 0;
			return -1;
		}
		return -1;
	}
}

class Node {
	private Node previous;
	private Employee employee;
	private Node next;

	Node(Employee employee) {
		this.employee = employee;
		this.next = null;
		this.previous = null;
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

	public Employee getEmployee()
	{
		return employee;
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
		Node create = new Node(new Employee(name,salary,age));
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
			System.out.println("Name = " + visit.getEmployee().getName() + " age="
					+ visit.getEmployee().getAge() + " salary= " + visit.getEmployee().getSalary());
			visit = visit.getNext();
		}
	}

	private void swap(Node current, Node previous) {
		current.setPrevious(previous.getPrevious());
		previous.setPrevious(current);
		previous.setNext(current.getNext());
		current.setNext(previous);
		if (current.getPrevious() == null)
			head = current;
		if (current != null) {
			if (current.getPrevious() != null)
				current.getPrevious().setNext(current);
		}
		if (previous != null) {
			if (previous.getNext() != null)
				previous.getNext().setPrevious(previous);
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
				if (pre.getEmployee().compareTo(compare.getEmployee())==-1) {
					swap(compare, pre);
					pre = compare.getPrevious();
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
		e.add(10000, 21, "avi");
		e.add(10000, 21, "mayank");
		e.add(11000, 14, "monu");
		e.add(14000, 21, "ravi");
		e.add(11000, 23, "rohit");
		e.add(10000, 11, "rahul");
		System.out.println("before sorted");
		e.display();
		System.out.println("After sort");
		e.insertionSort();
		e.display();
	}
}
