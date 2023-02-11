package SharedArea;

class CalcThread extends Thread {
	SharedArea sharedArea;

	@Override
	public void run() {
		double total = 0.0;
		for (int cnt = 1; cnt < 100000; cnt += 2)
			if (cnt / 2 % 2 == 0)
				total += 1.0 / cnt;
			else
				total -= 1.0 / cnt;
		sharedArea.result = total * 4; // 계산 결과를 공유 영역에 씁니다
		
		sharedArea.isReady = true; // SharedArea 객체의 isReady 핃드 값을 true로 설정합니다.

	}
}