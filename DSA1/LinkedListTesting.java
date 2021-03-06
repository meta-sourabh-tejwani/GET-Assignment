import org.junit.*;

public class LinkedListTesting {

	public static LinkedList<Integer> l;
	public static MultiPolynomial m;
	public static MultiPolynomial m1;
	public static MultiPolynomial m2;
	public static MultiPolynomial m3;


	@BeforeClass
	public static void setUp() {
		m = new MultiPolynomial("x");
		m1 = new MultiPolynomial("3x4-5z2+x");
		m2 = new MultiPolynomial("2");
		m3=new MultiPolynomial("x12y+1");
	}

	@Test
	public void checkMaxDegree() {
		Assert.assertEquals(1, m.maxDegree());
		Assert.assertEquals(4, m1.maxDegree());
		Assert.assertEquals(0, m2.maxDegree());
		Assert.assertEquals(13, m3.maxDegree());
	}

	@Test
	public void checkLoop() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.addElement(2);
		l.addElement(3);
		l.addElement(4);
		l.addElement(5);
		l.addElement(6);
		l.addElement(7);
		Assert.assertEquals(false, l.checkLoop());

	}

}
