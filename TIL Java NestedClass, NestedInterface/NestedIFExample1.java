class NestedIFExample1 {
	public static void main(String args[]) {
		MP3PlayerFactory factory = new MP3PlayerFactory();
		// factory 는 MP3PlayerFactory 클래스의 객체. 레퍼런스 변수. 즉, 주소를 담은 객체이며
		
		PlayerFactory.Player blabla = factory.createPlayer();
		// [createPlayer() 메소드] 로 인해 [new MP3Player() 가 return 됨]. 즉, [MP3Player 클래스의 객체가 return 됨]
		// [PlayerFactory 추상 클래스의] [static 인터페이스 Player의 타입인 blabla 객체는] [Player 인터페이스의 메소드로 접근 가능]
		// play() 메소드와 stop() 메소드가 사용 가능하며 MP3PlayerFactory 클래스의 이너 클래스인 MP3Player 의
		// 오버라이드한 메소드인 play() 와 stop() 을 사용한다.
		
		blabla.play("아리랑");
		blabla.stop();
	}
}