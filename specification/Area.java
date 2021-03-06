public class Area {
	/**
	 * find area of triangle using width and height formula width*height/2
	 * 
	 * @param width
	 *            must be double
	 * @param height
	 *            must be double
	 * @return area of triangle
	 */
	public double areaOfTriangle(double width, double height) {
		return (double)width * height / 2;
	}

	/**
	 * find area of rectangle using formula width*height
	 * 
	 * @param width
	 *            must be double
	 * @param height
	 *            must be double
	 * @return area of rectangle
	 */
	public double areaOfRectangle(double width, double height) {
		return (double)width * height;
	}

	/**
	 * find area of square using formula width*width
	 * 
	 * @param width
	 *            must be double
	 * @return area of square
	 */
	public double areaOfSquare(double width) {
		return (double)width * width;
	}

	/**
	 * find area of circle using formula PI*radius*radius
	 * 
	 * @param radius
	 *            must be double
	 * @return area of circle
	 */
	public double areaOfCircle(double radius) {
		return (double)3.14* radius * radius;
	}
}
