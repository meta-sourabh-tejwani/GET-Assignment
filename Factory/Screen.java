import java.util.*;

class SortArea implements Comparator<Shape> {
	@Override
	public int compare(Shape s1, Shape s2) {
		if (s1.getArea() > s2.getArea())
			return 1;
		else if (s1.getArea() < s2.getArea())
			return -1;
		return 0;
	}
}

class SortPerimeter implements Comparator<Shape> {
	@Override
	public int compare(Shape s1, Shape s2) {
		if (s1.getPerimeter() > s2.getPerimeter())
			return 1;
		else if (s1.getPerimeter() < s2.getPerimeter())
			return -1;
		return 0;
	}
}

class SortTimeStamp implements Comparator<Shape> {

	@Override
	public int compare(Shape s1, Shape s2) {
		if (s1.getTimeStamp() > s2.getTimeStamp())
			return 1;
		else if (s1.getTimeStamp() < s2.getTimeStamp())
			return -1;
		return 0;
	}
}

class SortOrigin implements Comparator<Shape> {
	@Override
	public int compare(Shape s1, Shape s2) {
		if (s1.getOrigin().getX() < s2.getOrigin().getX())
			return -1;
		else if (s1.getOrigin().getX() == s2.getOrigin().getX()) {
			if (s1.getOrigin().getY() < s2.getOrigin().getY())
				return -1;
			else if (s1.getOrigin().getY() > s2.getOrigin().getY())
				return 1;
			return 0;
		}
		return 1;
	}

}

class Screen {
	public List<Shape> shapesadd;
	private int XMAX;
	private int YMAX;

	public static enum sort {
		AREA, PERIMETER, TIMESTAMP, ORIGIN
	};

	Screen(int XMAX, int YMAX) {
		shapesadd = new ArrayList<>();
		this.XMAX = XMAX;
		this.YMAX = YMAX;
	}

	/**
	 * 
	 * @param type
	 *            contain type of shape
	 * @param p
	 *            contain origin point of shape
	 * @param list
	 *            contain property of shape
	 * @return true if shape add else return false
	 */
	public boolean addObject(Shape.ShapeType type, Point p, List<Integer> list) {
		Shape object = ShapeFactory.create(type, p, list);
		if (object.isPointEnclosed(new Point(XMAX, YMAX)) == false
				&& p.getX() >= 0 && p.getX() <= XMAX && p.getY() >= 0
				&& p.getY() <= YMAX) {
			shapesadd.add(object);
			return true;
		}
		return false;
	}

	/**
	 * delete last added shape
	 */
	public void deleteShape() {
		if (shapesadd.size() > 0) {
			shapesadd.remove(shapesadd.size() - 1);
		}
	}

	/**
	 * delete particular type of all shape
	 * 
	 * @param type
	 *            contain type of object delete
	 */
	public void deleteShapeSpecificType(Shape.ShapeType type) {
		if (type == Shape.ShapeType.Circle) {
			int i = 0;
			while (i < shapesadd.size()) {
				if (shapesadd.get(i).getClass() == Circle.class) {
					shapesadd.remove(i);
				} else {
					i++;
				}
			}
		} else if (type == Shape.ShapeType.Rectangle) {
			int i = 0;
			while (i < shapesadd.size()) {
				if (shapesadd.get(i).getClass() == Rectangle.class) {
					shapesadd.remove(i);
				} else {
					i++;
				}
			}
		}

		else if (type == Shape.ShapeType.Square) {
			int i = 0;
			while (i < shapesadd.size()) {
				if (shapesadd.get(i).getClass() == Square.class) {
					shapesadd.remove(i);
				} else {
					i++;
				}
			}
		}

		else if (type == Shape.ShapeType.Triangle) {
			int i = 0;
			while (i < shapesadd.size()) {
				if (shapesadd.get(i).getClass() == Triangle.class) {
					shapesadd.remove(i);
				} else {
					i++;
				}
			}
		}

		else if (type == Shape.ShapeType.RegularPolygon) {
			int i = 0;
			while (i < shapesadd.size()) {
				if (shapesadd.get(i).getClass() == RegularPolygon.class) {
					shapesadd.remove(i);
				} else {
					i++;
				}
			}
		}

	}

	/**
	 * return list of point where point inside the shape
	 * 
	 * @param p
	 *            contain point
	 * @return list of shape
	 */
	public List<Shape> shapeEnclosing(Point p) {
		List<Shape> pointenclosed = new ArrayList<>();
		for (int i = 0; i < shapesadd.size(); i++) {
			if (shapesadd.get(i).isPointEnclosed(p)) {
				pointenclosed.add(shapesadd.get(i));
			}
		}
		return pointenclosed;
	}

	/**
	 * sort according to area perimeter timestamp and origin
	 * 
	 * @param type
	 *            contain type of sorting require
	 */
	public void sortOrder(Screen.sort type) {
		if (type == Screen.sort.AREA) {
			Collections.sort(shapesadd, new SortArea());
		} else if (type == Screen.sort.ORIGIN) {
			Collections.sort(shapesadd, new SortOrigin());
		} else if (type == Screen.sort.PERIMETER) {
			Collections.sort(shapesadd, new SortPerimeter());
		} else if (type == Screen.sort.TIMESTAMP) {
			Collections.sort(shapesadd, new SortTimeStamp());
		}
	}

}
