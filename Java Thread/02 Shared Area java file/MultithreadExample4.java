package SharedArea;

class MultithreadExample4 {
	public static void main(String args[]) {
		CalcThread thread1 = new CalcThread();
		PrintThread thread2 = new PrintThread();
		
		// 공유 영역 객체를 생성해서 그 객체의 참조값을 두 스레드의 필드에 저장합니다
		SharedArea obj = new SharedArea(); 
		thread1.sharedArea = obj;
		thread2.sharedArea = obj;
		
		thread1.start();
		thread2.start();
	}
}