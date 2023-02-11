package CriticalSection;

class TransferThread extends Thread {
	SharedArea sharedArea;

	TransferThread(SharedArea area) { // 생성자
		sharedArea = area;
	}

	@Override
	public void run() {
		for (int cnt = 0; cnt < 12; cnt++) {
			
//			synchronized (sharedArea) { // 이 작업이 끝나기 전까지 다른 스레드는 이 동기화 객체에 접근 못함
//			
//			// critical section
//			sharedArea.account1.withdraw(1000000);
//			System.out.print("이몽룡 계좌: 100만원 인출,");
//			sharedArea.account2.deposit(1000000);
//			System.out.println("성춘향 계좌: 100만원 입금");
//			
//			}
			sharedArea.transfer(100); // 계좌 이체 메소드 호출
			
		}
	}
}
