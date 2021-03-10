import java.util.*;

class StringSorterOrder implements Comparator<Employee> {

	@Override
	public int compare(Employee object1, Employee object2) {
		String first = object1.getName();
		String second = object2.getName();
		for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
			if (first.charAt(i) > second.charAt(i)) {
				return 1;
			}
			if (first.charAt(i) < second.charAt(i)) {
				return -1;
			}
		}
		if(first.length()>second.length())
			return 1;
		else if(first.length()<second.length())
			return -1;
		return 0;
	}
}

class NaturalSortedOrder implements Comparator<Employee> {

	@Override
	public int compare(Employee object1, Employee object2) {
		return object1.getId() - object2.getId();
	}

}

class AddEmployee {
	private static Map<Integer, Integer> presentId = new HashMap<>();
	public static List<Employee> employeelist = new ArrayList<>();

	/**
	 * Add employee
	 * @param id contain id of employee
	 * @param name contain name of employee
	 * @param salary contain salary of employee
	 */
	public static void addEmployee(int id, String name, int salary) {
		if (presentId.containsKey(id) == false) {
			employeelist.add(new Employee(id, name, salary));
			presentId.put(id, id);
		}
	}

	public static List<Employee> getEmployeeList() {
		return employeelist;
	}

	public static void sortedName() {
		Collections.sort(employeelist, new StringSorterOrder());
	}

	public static void sortedNatural() {
		Collections.sort(employeelist, new NaturalSortedOrder());
	}
}
