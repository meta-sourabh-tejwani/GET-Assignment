import java.util.*;

class TimeStamp {
	public static int timeStamp = 1;
}

public interface Shape {
	public static enum ShapeType {
		Circle, Square, Triangle, Rectangle, RegularPolygon
	}

	public int getTimeStamp();

	public float getArea();

	public float getPerimeter();

	public Point getOrigin();

	public boolean isPointEnclosed(Point p);
}

class Circle implements Shape {
	public int timestamp;
	public Point p;
	public int radius;

	Circle(Point p, List<Integer> list) {
		this.p = p;
		this.timestamp = TimeStamp.timeStamp++;
		this.radius = list.get(0);
	}

	public int getTimeStamp() {
		return timestamp;
	}

	/**
	 * return Area of Circle
	 */
	@Override
	public float getArea() {
		return (float) (Math.PI * (float) radius * (float) radius); // PI*radius^2
	}

	/**
	 * return perimeter of circle
	 */
	@Override
	public float getPerimeter() {
		return (float) (2.0 * Math.PI * (float) radius); // 2*PI*radius
	}

	/**
	 * return origin point of circle
	 */
	@Override
	public Point getOrigin() {
		return p;
	}

	/**
	 * find the point p lie inside the circle or not if lie return true else
	 * return false
	 */
	@Override
	public boolean isPointEnclosed(Point p) {
		// (x1-x2)^2+(y1-y2)^2<=radius^2
		return (float) Math.pow(this.p.getX() - p.getX(), 2)
				+ (float) Math.pow(this.p.getY() - p.getY(), 2) <= (float) Math
					.pow(radius, 2);
	}
}

class Square implements Shape {
	public int timestamp;
	public Point p;
	public int length;

	Square(Point p, List<Integer> list) {
		this.timestamp = TimeStamp.timeStamp++;
		this.p = p;
		length = list.get(0);
	}

	public int getTimeStamp() {
		return timestamp;
	}

	/**
	 * return area of square
	 */
	@Override
	public float getArea() {
		return (float) Math.pow(length, 2); // length^2
	}

	/**
	 * return perimeter of square
	 */
	@Override
	public float getPerimeter() {
		return (float) 4 * length; // 4*length
	}

	/**
	 * return origin point of square
	 */
	@Override
	public Point getOrigin() {
		return p;
	}

	/**
	 * find the point p lie inside the square or not if lie return true else
	 * return false
	 */
	@Override
	public boolean isPointEnclosed(Point p) {
		// (x1<=p.x<=x1+length && y1<=p.y<=y1+length)
		return (this.p.getX() <= p.getX() && p.getX() <= (this.p.getX() + this.length))
				&& (this.p.getY() <= p.getY() && p.getY() <= (this.p.getY() + this.length));
	}

}

class Triangle implements Shape {
	public int timestamp;
	public Point p1;
	public Point p2;
	public Point p3;
	public int base;
	public int height;
	public int a;
	public int b;
	public int c;

	Triangle(Point p, List<Integer> list) {
		this.timestamp = TimeStamp.timeStamp++;
		this.p1 = p;
		this.a = list.get(0);
		this.b = list.get(1);
		this.c = list.get(2);
		p2 = new Point(b, 0);
		p3 = new Point(0, 0);
		// (x1-x2)^2+(y1-y2)^2=r^2 formula used
		int x = ((int) Math.pow(p2.getX(), 2) + (int) Math.pow(a, 2) - (int) Math
				.pow(c, 2)) / (2 * p2.getX());
		int y = (int) Math.sqrt((int) Math.pow(a, 2) - (int) Math.pow(x, 2));
		p2.setX(b + p1.getX());
		p2.setY(p1.getY());
		p3.setX(x + p1.getX());
		p3.setY(y + p1.getY());
	}

	public int getTimeStamp() {
		return timestamp;
	}

	/**
	 * return area of triangle
	 */
	@Override
	public float getArea() {
		return areaOfPoint(p1.getX(), p1.getY(), p2.getX(), p2.getY(),
				p3.getX(), p3.getY());
	}

	/**
	 * return perimeter of triangle
	 */
	@Override
	public float getPerimeter() {
		return (float) (a + b + c);
	}

	/**
	 * return origin point of triangle
	 */
	@Override
	public Point getOrigin() {
		return p1;
	}

	/**
	 * find the point p lie inside the triangle or not if lie return true else
	 * return false
	 */
	@Override
	public boolean isPointEnclosed(Point p) {
		float A = areaOfPoint(p1.getX(), p1.getY(), p2.getX(), p2.getY(),
				p3.getX(), p3.getY());
		float A1 = areaOfPoint(p.getX(), p.getY(), p2.getX(), p2.getY(),
				p3.getX(), p3.getY());
		float A2 = areaOfPoint(p1.getX(), p1.getY(), p.getX(), p.getY(),
				p3.getX(), p3.getY());
		float A3 = areaOfPoint(p1.getX(), p1.getY(), p2.getX(), p2.getY(),
				p.getX(), p.getY());
		return (A == A1 + A2 + A3);
	}

	/**
	 * 
	 * @param x1
	 *            contain first point in 2 d X
	 * @param y1
	 *            contain first point in 2 d Y
	 * @param x2
	 *            contain second point in 2 d X
	 * @param y2
	 *            contain second point in 2 d Y
	 * @param x3
	 *            contain third point in 2 d X
	 * @param y3
	 *            contain third point in 2 d Y
	 * @return area of triangle using point P1 P2 P3
	 */
	public float areaOfPoint(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (float) Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3
				* (y1 - y2)) / 2.0); // abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2))/2
	}
}

class Rectangle implements Shape {
	public int timestamp;
	public Point p;
	public int width;
	public int height;

	Rectangle(Point p, List<Integer> list) {
		this.timestamp = TimeStamp.timeStamp++;
		this.p = p;
		this.width = list.get(0);
		this.height = list.get(1);
	}

	public int getTimeStamp() {
		return timestamp;
	}

	/**
	 * return area of rectangle
	 */
	@Override
	public float getArea() {
		return (float) height * width;// height*width
	}

	/**
	 * return perimeter of rectangle
	 */
	@Override
	public float getPerimeter() {
		return (float) 2 * (height + width); // (height+width)*2
	}

	/**
	 * return origin point of rectangle
	 */
	@Override
	public Point getOrigin() {
		return p;
	}

	/**
	 * find the point p lie inside the rectangle or not if lie return true else
	 * return false
	 */
	@Override
	public boolean isPointEnclosed(Point p) {
		// (x1<=p.x<=x1+width && y1<=p.y<=y1+height)
		return (this.p.getX() <= p.getX() && p.getX() <= this.p.getX() + width)
				&& (this.p.getY() <= p.getY() && p.getY() <= this.p.getY()
						+ height);
	}

}

class RegularPolygon implements Shape {
	public int timestamp;
	public Point p;
	public int side;
	public int length;
	public float radius;
	public float angle;
	public Point center;

	RegularPolygon(Point p, List<Integer> list) {
		this.p = p;
		this.timestamp = TimeStamp.timeStamp++;
		this.side = list.get(0);
		this.length = list.get(1);
		this.angle = (float) (2 * Math.PI / side);
		this.radius = (float) (length / (Math.sin(angle / 2) * 2));
		this.center = new Point(p.getX() + length / 2, p.getY()+(int) (radius
				* Math.cos(angle) / 2));
	}

	public int getTimeStamp() {
		return timestamp;
	}

	/**
	 * return area of regular polygon
	 */
	@Override
	public float getArea() {
		return (float) (Math.pow(length, 2) * side) / 4
				* (float) (Math.tan((Math.PI / side)));
	}

	/**
	 * return perimeter of regular polygon
	 */
	@Override
	public float getPerimeter() {
		return (float) (length) * side;
	}

	/**
	 * return origin point of regular polygon
	 */
	@Override
	public Point getOrigin() {
		return p;
	}

	@Override
	public boolean isPointEnclosed(Point p) {
		double centerangle=angleBetweenPoints(this.p,p);
		double sectionangle=(angle-Math.floor(centerangle/angle)*angle);
		return (float)distanceTo(center,p)*(float)radius*Math.cos(angle/2)/Math.cos(angle/2*sectionangle)<=length;
	}

	public float distanceTo(Point p1, Point p2) {
		return (float) Math.pow(
				(p2.getX() - p1.getX()) * (p2.getX() - p1.getX())
						+ (p2.getY() - p1.getY()) * (p2.getY() - p1.getY()),0.5);
	}

	public double angleBetweenPoints(Point rightPoint, Point leftPoint) {

		float rightToLeft = distanceTo(leftPoint, rightPoint);
		float thisToRight = distanceTo(rightPoint,center);
		float thisToLeft = distanceTo(leftPoint,center);
		return  Math.cos((thisToLeft * thisToLeft + thisToRight
				* thisToRight - rightToLeft * rightToLeft)
				/ (2 * thisToLeft * thisToRight));
	}

}

class Point {
	private int x;
	private int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}
}