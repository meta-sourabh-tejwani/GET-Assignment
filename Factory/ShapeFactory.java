import java.util.*;

public class ShapeFactory {
	public static Shape create(Shape.ShapeType type, Point p, List<Integer> list) {
		Shape shape = null;
		if (Shape.ShapeType.Circle.equals(type)) {
			shape = new Circle(p, list);
		} else if (Shape.ShapeType.Rectangle.equals(type)) {
			shape = new Rectangle(p, list);
		} else if (Shape.ShapeType.Triangle.equals(type)) {
			shape = new Triangle(p, list);
		} else if (Shape.ShapeType.Square.equals(type)) {
			shape = new Square(p, list);
		} else if (Shape.ShapeType.RegularPolygon.equals(type)) {
			shape = new RegularPolygon(p, list);
		}
		return shape;
	}
}
