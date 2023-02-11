package SharedArea;

class PrintThread extends Thread {
	SharedArea sharedArea;

	@Override
	public void run() {
		while(sharedArea.isReady != true) 
			 continue; // SharedArea 객체의 isReady 필드 값이 true가 될 때까지 루프를 반복합니다.

		System.out.println(sharedArea.result); // 공유 영역의 데이터를 출력합니다

	}
}