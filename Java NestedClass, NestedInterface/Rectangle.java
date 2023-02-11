class Rectangle implements PlaneObject { // 사각형 클래스
	Location location;
	int width, height;

	Rectangle(int x, int y, int width, int height) {
		this.location = new Location(x, y); // PlaneObject 인터페이스로부터 상속받은 정적 네스티드 클래스의 생성자 호출
		this.width = width;
		this.height = height;
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(int x, int y) {
		location.x = x; // 정적 네스티드 클래스의 필드 사용
		location.y = y;
	}
}