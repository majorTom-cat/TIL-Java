class NestedClassExample9 {
	public static void main(String args[]) {
		
		MessageSender obj = new MessageSender() { // 이름 없는 이너 클래스의 선언 및 객체 생성 (anonymous inner class), 익명 클래스
			@Override
			void send(String message) {
				System.out.println("발신: 마이다스");
				System.out.println("수신: 빌 게이츠");
				System.out.println("메시지: " + message);
				System.out.println();
			}
			
		}; // 익명 이너 클래스. 세미콜론 반드시
		// 일회성 목적으로 사용. 추가적인 객체 생성 불가능
		
		obj.send("굿 모닝"); // 이름 없는 이너 클래스의 메소드 호출
	}
}