package task11stack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class StudentQueue {
	public String name[];
	public String function[][];
	public int front;
	public int rear;

	StudentQueue(int size) {
		this.name = new String[size];
		this.function = new String[size][5];
		this.rear = 0;
		this.front = 0;
	}

	/**
	 * Insert into queue with name and 5 function
	 * @param name contain name of student
	 * @param function contain preference of function
	 */
	public void enQueue(String name, String function[]) {
		this.name[rear] = name;
		this.function[rear] = Arrays.copyOf(function, 5);
		rear++;
	}

	/**
	 * remove student when function is match with required function
	 * @param function contain required function
	 * @return name of that function if function found else blank String
	 */
	public String deQueue(String function) {
		for (int i = 0; i < this.function[front].length; i++) {
			if (this.function[front][i].equals(function)) {
				front++;
				return function;
			}
		}
		front++;
		return "";
	}

}

class FunctionQueue {
	public String functionname[];
	public int capacity[];
	public int front;
	public int rear;

	FunctionQueue(int size) {
		this.functionname = new String[size];
		this.capacity = new int[size];
		this.rear = 0;
		this.front = 0;
	}

	/**
	 * Add in Queue
	 * @param name contain name of function
	 * @param capacity contain requirement of function
	 */
	public void enQueue(String name, int capacity) {
		this.functionname[rear] = name;
		this.capacity[rear] = capacity;
		rear++;
	}

	/**
	 * remove function when function requirement completed
	 */
	public void deQueue() {
		if (front < functionname.length) {
			while (capacity[front] == 0) {
				front++;
				if (front >= functionname.length)
					return;
			}
			capacity[front] -= 1;
		} else
			return;
	}

	/**
	 * 
	 * @return current required function name
	 */
	public String getFunctionName() {
		if (front >= functionname.length)
			return "";
		return functionname[front];
	}

	public void display() {
		for (int i = 0; i < this.functionname.length; i++) {
			System.out.println(this.functionname[i] + " " + this.capacity[i]);
		}	
	}

}

public class CollegeCounseling {
	public static void main(String... k) {
		StudentQueue student = null;
		try {
			student = createStudent();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FunctionQueue function = null;
		try {
			function = createFunction();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, String> result = new LinkedHashMap<>();
		for (int i = 0; i < student.name.length; i++) {
			function.deQueue();
			String generated = function.getFunctionName();
			if (student.deQueue(generated).equals(generated)) {
				result.put(student.name[i], generated);
			}
		}
		for (String name : result.keySet()) {
			System.out
					.println("name=" + name + " function=" + result.get(name));
		}
		try {
			printInExcel(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static StudentQueue createStudent() throws IOException {
		Map<String, List<String>> student = new LinkedHashMap<>();

		FileInputStream fis = new FileInputStream(new File(
				"C:\\Users\\sourabh.tejwani_meta\\workspace\\task11stack\\src\\task11stack\\student.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			int c = 0;
			String studentname = "";
			Iterator<Cell> celliterator = row.cellIterator();
			List<String> function = new ArrayList<>();
			while (celliterator.hasNext()) {
				Cell cell = celliterator.next();
				if (c == 0) {
					studentname = cell.getStringCellValue();
					c = 1;
				} else {
					function.add(cell.getStringCellValue());
				}
			}
			student.put(studentname, function);
		}
		StudentQueue st = new StudentQueue(student.size());
		for (String name : student.keySet()) {
			String fun[] = new String[5];
			for (int i = 0; i < student.get(name).size(); i++) {
				fun[i] = student.get(name).get(i);
			}
			st.enQueue(name, fun);
		}
		wb.close();

		/*
		 * StudentQueue st = new StudentQueue(4); String fun[] = { "singing",
		 * "dancing", "gaming", "organized", "arrangment" };
		 * st.enQueue("sourabh", fun); st.enQueue("avi", fun);
		 * st.enQueue("rahul", fun); st.enQueue("monu", fun);
		 */
		return st;
	}

	public static FunctionQueue createFunction() throws IOException {

		Map<String, Integer> scfunction = new LinkedHashMap<>();
		FileInputStream fis = new FileInputStream(new File(
				"C:\\Users\\sourabh.tejwani_meta\\workspace\\task11stack\\src\\task11stack\\function.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			int capacity = 0, count = 0;
			String functionname = "";
			Iterator<Cell> celliterator = row.cellIterator();
			while (celliterator.hasNext()) {
				Cell cell = celliterator.next();
				if (count == 1) {
					capacity = (int) cell.getNumericCellValue();
				} else {
					count = 1;
					functionname = cell.getStringCellValue();
				}
			}
			scfunction.put(functionname, capacity);
		}
		FunctionQueue fc = new FunctionQueue(scfunction.size());
		for (String name : scfunction.keySet()) {
			fc.enQueue(name, scfunction.get(name));
		}
		wb.close();

		/*
		 * FunctionQueue fc = new FunctionQueue(3); fc.enQueue("singing", 2);
		 * fc.enQueue("dancing", 1); fc.enQueue("arrangment", 1);
		 */
		return fc;
	}

	public static void printInExcel(Map<String, String> result)
			throws Exception {
		FileInputStream fis = new FileInputStream(new File(
				"C:\\Users\\sourabh.tejwani_meta\\workspace\\task11stack\\src\\task11stack\\result.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rownum = 0;
		for (String name : result.keySet()) {
			Row row = sheet.createRow(rownum++);
			Cell cell1 = row.createCell(0);
			cell1.setCellValue(name);
			Cell cell2 = row.createCell(1);
			cell2.setCellValue(result.get(name));
		}
		
		try
		{
			FileOutputStream output=new FileOutputStream(new File(
				"C:\\Users\\sourabh.tejwani_meta\\workspace\\task11stack\\src\\task11stack\\result.xlsx"));
			wb.write(output);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		wb.close();
	}
}
