package CriticalSection;

class SharedArea {
	Account account1; // 이몽룡의 계좌
	Account account2; // 성춘향의 계좌

	void transfer(int amount) { // 계좌 이체를 한다
		synchronized (this) { // 메소드를 동기화하는 방법.
			// 메소드 선언 제일 앞에 synchronized 키워드를 써도 된다.
			// synchronized void transfer(int amount)

			account1.withdraw(1000000);
			System.out.print("이몽룡 계좌: 100만원 인출,");
			account2.deposit(1000000);
			System.out.println("성춘향 계좌: 100만원 입금");
		}
	}

	int getTotal() { // 잔액 합계를 구한다
		synchronized (this) { // this
			return account1.balance + account2.balance;
		}
	}

}