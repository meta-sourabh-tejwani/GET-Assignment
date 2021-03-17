package task11stack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CollegeCounseling {
	private static Map<String, Integer> collegeoffer = new LinkedHashMap<>();
	private static Queue<String> students = new LinkedList<>();
	private static List<List<String>> studentpreference = new ArrayList<>();
	private static Map<String, String> assigned = new LinkedHashMap<>();

	/**
	 * check the student preference and according assign program if student have
	 * different program which not are available by college then it does not
	 * assign any program
	 * 
	 * @throws Exception
	 */
	public static void assignedProgram() throws Exception {
		getProgram(collegeoffer);
		getStudents(students, studentpreference);
		int total = students.size();
		for (int i = 0; i < total; i++) {
			String student = students.remove();
			String offergiven = "";
			for (String preferprogram : studentpreference.get(i)) {
				if (collegeoffer.containsKey(preferprogram)) {
					int capacity = collegeoffer.get(preferprogram);
					if (capacity > 0) {
						offergiven = preferprogram;
						collegeoffer.replace(preferprogram, capacity - 1);
						break;
					}
				}
			}
			assigned.put(student, offergiven);
		}
		printInExcel(assigned);

	}

	/**
	 * Read the data from student excel file
	 * @param students contain queue of student name
	 * @param studentpreference contain each student preference
	 * @throws IOException
	 */
	public static void getStudents(Queue<String> students,
			List<List<String>> studentpreference) throws IOException {
		FileInputStream fileinput = new FileInputStream(
				new File(
						"C:\\Users\\sourabh.tejwani_meta\\workspace\\task11stack\\src\\task11stack\\student.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			int checkpreference = 0;
			String studentname = "";
			Iterator<Cell> celliterator = row.cellIterator();
			List<String> preference = new ArrayList<>();
			while (celliterator.hasNext()) {
				Cell cell = celliterator.next();
				if (checkpreference == 0) {
					studentname = cell.getStringCellValue();
					checkpreference = 1;
				} else {
					preference.add(cell.getStringCellValue());
				}
			}
			students.add(studentname);
			studentpreference.add(preference);
		}
		workbook.close();
	}

	/**
	 * read the function excel file
	 * @param collegeoffer contain key value pair of program offer by college and capacity
	 * @throws IOException
	 */
	public static void getProgram(Map<String, Integer> collegeoffer)
			throws IOException {
		FileInputStream fileinput = new FileInputStream(
				new File(
						"C:\\Users\\sourabh.tejwani_meta\\workspace\\task11stack\\src\\task11stack\\function.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		XSSFSheet sheet = workbook.getSheetAt(0);
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
			collegeoffer.put(functionname, capacity);
		}
		workbook.close();
	}

	/**
	 * print the result into result excel file
	 * @param result contain key value pair of student and assigned program
	 * @throws Exception
	 */
	public static void printInExcel(Map<String, String> result)
			throws Exception {
		FileInputStream fis = new FileInputStream(
				new File(
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
