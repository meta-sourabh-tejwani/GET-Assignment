import org.junit.*;
import java.util.*;

public class CollectionTesting {

	@Test
	public void testUnique() {
		Assert.assertEquals(7, Unique.uniqueCharacter("sourabh"));
		Assert.assertEquals(3, Unique.uniqueCharacter("aabbcc"));
		Assert.assertEquals(3, Unique.uniqueCharacter("aabbcc"));
		Assert.assertEquals(6, Unique.uniqueCharacter("sourab"));
	}

	@Test
	public void testCompoundMass() {
		Assert.assertEquals(13, Organic.returnMass("CH"));// 12+1
		Assert.assertEquals(46, Organic.returnMass("C(OH)2"));// 12+(16+1)*2
		Assert.assertEquals(86, Organic.returnMass("CHOC(CH3)3"));// 12+1+16+12+(12+3)*3
		Assert.assertEquals(56, Organic.returnMass("CHOC(CH3)"));// 12+1+16+12+(12+3)
	}

	@Test
	public void tesTEmployee() {
		AddEmployee.addEmployee(1, "sourabh", 10000);
		AddEmployee.addEmployee(1, "tejwani", 10000);
		AddEmployee.addEmployee(2, "sou", 10000);
		AddEmployee.addEmployee(3, "tej", 10000);
		AddEmployee.addEmployee(4, "tejw", 10000);
		AddEmployee.addEmployee(5, "saurabh", 10000);
		List<Employee> present = AddEmployee.getEmployeeList();
		System.out.println("Size=" + present.size());
		for (int i = 0; i < present.size(); i++)
			System.out.println(present.get(i).getId() + " "
					+ present.get(i).getName() + " "
					+ present.get(i).getSalary());
		Collections.sort(present, new StringSorterOrder());
		Assert.assertEquals("saurabh", present.get(0).getName());
		Assert.assertEquals("sou", present.get(1).getName());
		Assert.assertEquals("sourabh", present.get(2).getName());
		Assert.assertEquals("tej", present.get(3).getName());
		Assert.assertEquals("tejw", present.get(4).getName());
		Collections.sort(present, new NaturalSortedOrder());
		Assert.assertEquals(1, present.get(0).getId());
		Assert.assertEquals(2, present.get(1).getId());
		Assert.assertEquals(3, present.get(2).getId());
		Assert.assertEquals(4, present.get(3).getId());
		Assert.assertEquals(5, present.get(4).getId());

	}
}
