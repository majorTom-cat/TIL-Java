class MultithreadExample1 {
	public static void main(String args[]) {
		Thread thread = new DigitThread(); // 스레드를 생성 
		thread.start(); // 스레드를 시작
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
} // sleep() 없으면 균등하거나 섞여 나올수도 있음
	// main 스레드 시작. start() 만나는 순간 다른 스레드 시작
	// 숫자는 안끊기고 출력되는건 cpu 할당 시간이 숫자 출력하는데는 충분하기때문