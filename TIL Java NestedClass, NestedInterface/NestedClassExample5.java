class NestedClassExample5 {
	public static void main(String args[]) {
		Line line = new Line(0, 0, 100, 100);
		line.move(10, 20);
		printPoint(line.point1);
		printPoint(line.point2);
		
		// 위에 네 줄 주석처리해도 됨. 즉, Line line 을 선언하지 않고 독립적으로 객체를 생성한것
		Line.Point point = new Line.Point(100, 200); // static 이 없으면 line.new Point(100, 200)
		printPoint(point);
	}

	static void printPoint(Line.Point point) {
		System.out.printf("(%d, %d) %n", point.x, point.y);
	}
}