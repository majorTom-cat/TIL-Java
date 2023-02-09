interface PlaneObject { // 평면 도형 인터페이스
	Location getLocation();

	void setLocation(int x, int y); // 추상 메소드. 반드시 오버라이딩

	static class Location { // 위치 클래스. 정적 네스티드 클래스
		int x, y;

		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	} //
}
