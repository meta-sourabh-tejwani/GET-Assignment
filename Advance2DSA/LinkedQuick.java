
class Employee implements Comparable<Employee> {
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
		if (this.salary > employee.salary)
			return -1;
		else if (this.salary == employee.salary) {
			if(this.age==employee.age)
				return 0;
			else if(this.age<employee.age)
				return -1;
			else 
				return 1;
		}
		return 1;
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

	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee)
	{
		this.employee=employee;
	}
}

class EmployeeLinkedList {
	private Node head;
	private Node end;
	EmployeeLinkedList() {
		this.head = null;
		this.end=null;
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
		Node create = new Node(new Employee(name, salary, age));
		if (head == null) {
			head = create;
			end=create;
		} else {
			end.setNext(create);
			create.setPrevious(end);
			end=create;
		}
	}

	/**
	 * Display The Data present in the LinkedList
	 */
	public void display() {
		Node visit = head;
		while (visit != null) {
			System.out.println("Name = " + visit.getEmployee().getName()
					+ " age=" + visit.getEmployee().getAge() + " salary= "
					+ visit.getEmployee().getSalary());
		//	System.out.println(visit+" "+visit.getPrevious()+" "+visit.getNext());
			visit = visit.getNext();
			
			
		}
	}
	
	
	public Node partition(Node start, Node end) {
		if(start==this.end || start==null ||  end==null)
			return start;
		Node pivot=end;
		Node curr=start;
		Node previous=start;
		while(start!=end)
		{
			if(start.getEmployee().compareTo(pivot.getEmployee())==-1)
			{
				previous=curr;
				Employee temp=curr.getEmployee();
				curr.setEmployee(start.getEmployee());
				start.setEmployee(temp);
				curr=curr.getNext();
				
			}
			start=start.getNext();
		}

		Employee temp=curr.getEmployee();
		curr.setEmployee(pivot.getEmployee());
		pivot.setEmployee(temp);
		return previous;

	}

	public void quickSort(Node head, Node end) {
		if(head==null || head==end || head==end.getNext())
			return;
		Node pivotpre=partition(head,end);
		quickSort(head,pivotpre);
		if(pivotpre!=null && pivotpre==head)
		{
			quickSort(pivotpre.getNext(),end);
		}
		else if(pivotpre!=null && pivotpre.getNext()!=null)
		{
			quickSort(pivotpre.getNext().getNext(),end);
		}
	}
	
	public void quickSort()
	{
		Node end=head;
		while(end.getNext()!=null)
		{
			end=end.getNext();
		}
		quickSort(head,end);
	}

}

public class LinkedQuick{
	public static void main(String... k) {
		EmployeeLinkedList e = new EmployeeLinkedList();
		e.add(10000, 21, "avi");
		e.add(7000, 21, "mayank");
		e.add(11000, 14, "monu");
		e.add(11000, 23, "rohit");
		e.add(10000, 11, "rahul");
		e.add(14000, 21, "ravi");
		System.out.println("before sorted");
		e.display();
		System.out.println("After sort");
		e.quickSort();
		e.display();
	}

}
