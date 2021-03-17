package task11stack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
public class Testing {

	@Test
	public void testInfix()
	{
		Assert.assertEquals(12,InfixUsingStack.infixValue("2 * 3 * ( 12 / 6 )"));
		Assert.assertEquals(0,InfixUsingStack.infixValue(" 1 <= 0 && 2 >= 1"));
		Assert.assertEquals(1,InfixUsingStack.infixValue(" 1 <= 12 && 2 >= 1"));
		Assert.assertEquals(1,InfixUsingStack.infixValue(" ( ( 1 + 11 ) <= 12 ) && 2 * 9 >= 17"));
		Assert.assertEquals(8,InfixUsingStack.infixValue(" ( ( 1 + 11 ) * 12 ) / ( 2 * 9 )"));
		Assert.assertEquals(-11,InfixUsingStack.infixValue("1 - 12"));
	}
	
	@Test
	public void testQueue()
	{
		Queue queue=new Queue(5);
		Assert.assertEquals(true,queue.isEmpty());
		Assert.assertEquals(true,queue.enQueue(12));
		Assert.assertEquals(true,queue.enQueue(13));
		Assert.assertEquals(true,queue.enQueue(14));
		Assert.assertEquals(true,queue.enQueue(15));
		Assert.assertEquals(true,queue.enQueue(16));
		Assert.assertEquals(false,queue.enQueue(17));
		Assert.assertEquals(true,queue.isFull());
		Assert.assertEquals(12,queue.deQueue());
		Assert.assertEquals(13,queue.deQueue());
		Assert.assertEquals(true,queue.enQueue(17));
	}
	@Test
	public void testCounseling() throws IOException
	{
		try {
			CollegeCounseling.assignedProgram();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String,String> assigned=new LinkedHashMap<>();
		FileInputStream fileinput = new FileInputStream(
				new File(
						"C:\\Users\\sourabh.tejwani_meta\\workspace\\task11stack\\src\\task11stack\\result.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			int count = 0;
			String functionname = "",studentname="";
			Iterator<Cell> celliterator = row.cellIterator();
			while (celliterator.hasNext()) {
				Cell cell = celliterator.next();
				if (count == 0) {
					studentname =cell.getStringCellValue();
					count=1;
				} else {
					count = 1;
					functionname = cell.getStringCellValue();
				}
			}
			assigned.put(studentname,functionname);
		}
		workbook.close();
		Assert.assertEquals("CS",assigned.get("sourabh"));
		Assert.assertEquals("IT",assigned.get("avi"));
		Assert.assertEquals("CS",assigned.get("rahul"));
		Assert.assertEquals("",assigned.get("monu"));
		Assert.assertEquals("ME",assigned.get("arpit"));
		Assert.assertEquals("ME",assigned.get("rishabh"));
		Assert.assertEquals("EE",assigned.get("vishal"));
		Assert.assertEquals("EC",assigned.get("rakesh"));
		Assert.assertEquals("IT",assigned.get("mohit"));
	}
}
