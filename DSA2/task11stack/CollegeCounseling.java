package task11stack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class Student {
	private String name;
	private String preference[];
	private String assigned;

	Student(String name, String preference[]) {
		this.name = name;
		this.preference = new String[5];
		for (int i = 0; i < 5; i++) {
			this.preference[i] = preference[i];
		}
		this.assigned = "";
	}
	/**
	 * 
	 * @return assigned course of student
	 */
	public String getAssigned() {
		return assigned;
	}

	/**
	 * assigned the course of student
	 * @param assigned the course
	 */
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	/**
	 * 
	 * @return name of student
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param index contain index of course
	 * @return preference of that index
	 */
	public String getPreference(int index) {
		return preference[index];
	}

}

class Course {
	private String name;
	private int capacity;

	Course(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	/**
	 * 
	 * @return capacity of particular course
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * 
	 * @return name of course
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the capacity
	 * @param capacity contain new capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}

class StudentQueue{
	private Student[] students;
	private int rear = 0;
	private int front = 0;
	private int size;

	StudentQueue(int size) {
		this.size = size;
		this.students = new Student[size];
	}

	/**
	 * insert the student in Queue
	 * @param student contain Student object
	 */
	public void enQueue(Student student) {
		if (rear < size) {
			this.students[rear++] = student;
		}
	}

	/**
	 * return size of Queue
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * remove into the queue
	 * @return object which is removed
	 */
	public Student deQueue() {

		if (front <= rear) {
			return students[front++];
		}
		return null;
	}
}

class CollegeCounseling {
	private static Course collegeoffer[];
	private static Student students[];
	private static StudentQueue queue;

	/**
	 * check the student preference and according assign program if student have
	 * different program which not are available by college then it does not
	 * assign any program
	 * 
	 * @throws Exception
	 */
	public static void assignedProgram() throws Exception {
		getProgram();
		getStudents();
		queue = new StudentQueue(students.length);
		for (int i = 0; i < students.length; i++) {
			queue.enQueue(students[i]);
		}
		for (int i = 0; i < queue.getSize(); i++) {
			Student student = queue.deQueue();
			int assigned = 0;
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < collegeoffer.length; k++) {
					if (student.getPreference(j).equals(
							collegeoffer[k].getName())) {
						int capacity = collegeoffer[k].getCapacity();
						if (capacity > 0) {
							student.setAssigned(student.getPreference(j));
							collegeoffer[k].setCapacity(capacity--);
							assigned = 1;
							break;
						}
					}
				}
				if (assigned == 1) {
					break;
				}
			}
		}
		printInExcel();

	}
	/**
	 * Accept the Data from student excel sheet
	 * @throws IOException
	 */
	public static void getStudents() throws IOException {
		FileInputStream fileinput = new FileInputStream(
				new File(
						"C:\\Users\\sourabh.tejwani_meta\\workspace\\task11stack\\src\\task11stack\\student.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		List<Student> student = new ArrayList<>();
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			int checkpreference = 0;
			String studentname = "";
			Iterator<Cell> celliterator = row.cellIterator();
			String preference[] = new String[5];
			int index = 0;
			while (celliterator.hasNext()) {
				Cell cell = celliterator.next();
				if (checkpreference == 0) {
					studentname = cell.getStringCellValue();
					checkpreference = 1;
				} else {
					preference[index++] = cell.getStringCellValue();
				}
			}
			student.add(new Student(studentname, preference));
			students = new Student[student.size()];
			for (int i = 0; i < student.size(); i++) {
				students[i] = student.get(i);
			}
		}
		workbook.close();
	}
	/**
	 * Accept the college data from function excel
	 * @throws IOException
	 */
	public static void getProgram() throws IOException {
		FileInputStream fileinput = new FileInputStream(
				new File(
						"C:\\Users\\sourabh.tejwani_meta\\workspace\\task11stack\\src\\task11stack\\function.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		List<Course> courses = new ArrayList<>();
		while (itr.hasNext()) {
			Row row = itr.next();
			int capacity = 0, check = 0;
			String program = "";
			Iterator<Cell> celliterator = row.cellIterator();
			while (celliterator.hasNext()) {
				Cell cell = celliterator.next();
				if (check == 1) {
					capacity = (int) cell.getNumericCellValue();
				} else {
					check = 1;
					program = cell.getStringCellValue();
				}
			}
			courses.add(new Course(program, capacity));
		}
		collegeoffer = new Course[courses.size()];
		for (int i = 0; i < courses.size(); i++) {
			collegeoffer[i] = courses.get(i);
		}
		workbook.close();
	}
	/**
	 * write the data into excel file result
	 * @throws Exception
	 */
	public static void printInExcel() throws Exception {
		FileInputStream fis = new FileInputStream(
				new File(
						"C:\\Users\\sourabh.tejwani_meta\\workspace\\task11stack\\src\\task11stack\\result.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rownum = 0;
		for (int i = 0; i < students.length; i++) {
			Row row = sheet.createRow(rownum++);
			Cell cell1 = row.createCell(0);
			cell1.setCellValue(students[i].getName());
			Cell cell2 = row.createCell(1);
			cell2.setCellValue(students[i].getAssigned());
		}

		try {
			FileOutputStream output = new FileOutputStream(
					new File(
							"C:\\Users\\sourabh.tejwani_meta\\workspace\\task11stack\\src\\task11stack\\result.xlsx"));
			wb.write(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		wb.close();
	}
}
