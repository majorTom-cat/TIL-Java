class NestedClassExample10 {
	public static void main(String args[]) {
		
		Player obj = new Player() { // Player 인터페이스를 구현하는 이름 없는 이너 클래스
			@Override
			public void play(String source) {
				System.out.println("플레이 시작: " + source);
			}

			@Override
			public void stop() {
				System.out.println("플레이 종료");
			}
		}; //
		
		obj.play("LetItBe.mp3"); // 이름 없는 이너 클래스의 메소드 호출
		obj.stop();
	}
}