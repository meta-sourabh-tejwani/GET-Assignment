import org.junit.*;
public class LinkedListTesting {

	public static LinkedList<Integer> l;
	public static MultiPolynomial m;
	public static MultiPolynomial m1;
	
	@BeforeClass
	public static void setUp() {
		m = new MultiPolynomial("3x2y4-5z2+x-y+20");
		m1 = new MultiPolynomial("3x4-5z2+x");
	}
	
	@Test
	public void checkMaxDegree()
	{
		Assert.assertEquals(6,m.maxDegree());
		Assert.assertEquals(4,m1.maxDegree());
	}
	@Test
	public void checkRotate()
	{
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.addElement(2);
		l.addElement(3);
		l.addElement(4);
		l.addElement(5);
		l.addElement(6);
		l.addElement(7);
		Assert.assertEquals(false,l.checkLoop());
		
	}
	
	
}
