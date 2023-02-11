package Communication;

class CalcThread extends Thread {
	SharedArea sharedArea;

	@Override
	public void run() {
		double total = 0.0;
		for (int cnt = 1; cnt < 1000000000; cnt += 2) // { } 가 없어도 돌아가네?
			if (cnt / 2 % 2 == 0)
				total += 1.0 / cnt;
			else
				total -= 1.0 / cnt;
		
		sharedArea.result = total * 4;
		sharedArea.isReady = true;
		
		synchronized (sharedArea) {
			sharedArea.notify(); // 신호를 보냅니다.
			
		}
	}
}
