package CriticalSection;

class PrintThread extends Thread {
	SharedArea sharedArea;

	PrintThread(SharedArea area) { // 생성자
		sharedArea = area;
	}

	@Override
	public void run() {
		for (int cnt = 0; cnt < 3; cnt++) {
//			synchronized (sharedArea) {
			int sum = sharedArea.getTotal(); // 잔액 합계 메소드 호출
			// critical section
//			int sum = sharedArea.account1.balance + sharedArea.account2.balance;
			System.out.println("계좌 잔액 합계: " + sum);
			
//			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}