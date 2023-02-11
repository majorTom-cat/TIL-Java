package Communication;

class PrintThread extends Thread {
	SharedArea sharedArea;

	@Override
	public void run() {
		if (sharedArea.isReady != true) {
			try {
				synchronized (sharedArea) {
					sharedArea.wait(); // 신호를 받습니다.

				}
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(sharedArea.result);
	}
}