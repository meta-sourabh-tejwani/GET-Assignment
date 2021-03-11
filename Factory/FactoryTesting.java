import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.*;

public class FactoryTesting {
	static Screen s;

	@BeforeClass
	public static void setUp() {
		s = new Screen(100, 100);
	}

	@Test
	public void testAddShape() {
		List<Integer> l = new ArrayList<>();
		l.add(2);
		Assert.assertEquals(true,
				s.addObject(Shape.ShapeType.Circle, new Point(4, 5), l));
		
		
		l = new ArrayList<>();
		l.add(5);
		l.add(6);
		l.add(7);
		Assert.assertEquals(true,
				s.addObject(Shape.ShapeType.Triangle, new Point(7, 8), l));
		Assert.assertEquals(false,
				s.addObject(Shape.ShapeType.Triangle, new Point(102, 8), l));
		
		
		l = new ArrayList<>();
		l.add(12);
		Assert.assertEquals(true,
				s.addObject(Shape.ShapeType.Square, new Point(10, 8), l));
		
		
		l = new ArrayList<>();
		l.add(6);
		Assert.assertEquals(true,
				s.addObject(Shape.ShapeType.Circle, new Point(14, 15), l));
		

		l = new ArrayList<>();
		l.add(5);
		l.add(10);
		Assert.assertEquals(true,
				s.addObject(Shape.ShapeType.RegularPolygon, new Point(5,5), l));
		
		System.out.println("Present Shape...");
		for (int i = 0; i < s.shapesadd.size(); i++)
			System.out.println(s.shapesadd.get(i).getClass().toString().substring(6) + " points "
					+ s.shapesadd.get(i).getOrigin().getX() + " "
					+ s.shapesadd.get(i).getOrigin().getY());
		
		
		Collections.sort(s.shapesadd, new SortArea());
		Assert.assertEquals(Triangle.class,s.shapesadd.get(0).getClass());
		Assert.assertEquals(Circle.class,s.shapesadd.get(1).getClass());
		Assert.assertEquals(RegularPolygon.class,s.shapesadd.get(2).getClass());
		Assert.assertEquals(Circle.class,s.shapesadd.get(3).getClass());
		Assert.assertEquals(Square.class,s.shapesadd.get(4).getClass());
		

		Collections.sort(s.shapesadd, new SortTimeStamp());
		Assert.assertEquals(Circle.class,s.shapesadd.get(0).getClass());
		Assert.assertEquals(Triangle.class,s.shapesadd.get(1).getClass());
		Assert.assertEquals(Square.class,s.shapesadd.get(2).getClass());
		Assert.assertEquals(Circle.class,s.shapesadd.get(3).getClass());
		Assert.assertEquals(RegularPolygon.class,s.shapesadd.get(4).getClass());
		

		System.out.println("Inside point(5,5) shape....");
		List<Shape> insidepoint=s.shapeEnclosing(new Point(5,5));
		for (int i = 0; i < insidepoint.size(); i++)
			System.out.println(insidepoint.get(i).getClass().toString().substring(6) + " points "
					+ insidepoint.get(i).getOrigin().getX() + " "
					+ insidepoint.get(i).getOrigin().getY());
		
		
		s.deleteShapeSpecificType(Shape.ShapeType.Circle);
		System.out.println("After deleting Circle specific Type...");
		for (int i = 0; i < s.shapesadd.size(); i++)
			System.out.println(s.shapesadd.get(i).getClass().toString().substring(6) + " points "
					+ s.shapesadd.get(i).getOrigin().getX() + " "
					+ s.shapesadd.get(i).getOrigin().getY());
	}

}
