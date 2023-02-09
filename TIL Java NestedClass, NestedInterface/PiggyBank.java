class PiggyBank { // 돼지 저금통 클래스
	int total;
	Slot slot;

	PiggyBank() {
		total = 0;
		slot = new Slot();
	}

	class Slot { // 입구 클래스
		void put(int amount) {
			total += amount; // 인클로징 클래스의 필드를 이너 클래스에서 바로 사용 가능
		}
	} //
}