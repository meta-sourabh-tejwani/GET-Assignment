import org.junit.*;
public class Testing {

	public static MarkSheet m;
	@BeforeClass
	public static void setUp() {
		float a[]={5,22,67,99,100};
		m=new MarkSheet(5,a);
	}
	@Test
	public void checkStringAPI()
	{
		StringOperation s=new StringOperation();
		Assert.assertEquals(0,s.compareString("Hello", "HEllo"));
		Assert.assertEquals(1,s.compareString("Hello", "Hello"));
		Assert.assertEquals(0,s.compareString("Hii", "Hello"));
		Assert.assertEquals("olleh",s.reverseString("hello"));
		Assert.assertEquals("hEllO",s.replaceLowerUpper("HeLLo"));
		Assert.assertEquals("tejwani",s.largestWord("Hello sourabh tejwani"));
		Assert.assertEquals("be",s.largestWord("i be am be"));
	}
	
	@Test
	public void checkArea()
	{
		Area a=new Area();
		Assert.assertEquals(12.56,a.areaOfCircle(2),0.000001d);
		Assert.assertEquals(4.0,a.areaOfRectangle(2,2),0.000001d);
		Assert.assertEquals(4.0,a.areaOfSquare(2),0.000001d);
		Assert.assertEquals(2.0,a.areaOfTriangle(2,2),0.000001d);
	}
	
	@Test
	public void checkMarks()
	{
		Assert.assertEquals(58.6,m.average(),.1f);
		Assert.assertEquals(100,m.maximum(),.1f);
		Assert.assertEquals(5,m.minimum(),.1f);
		Assert.assertEquals(60,m.passPercantage(),.1f);
	}
}
