import java.util.ArrayList;

class Cart { // 장바구니 클래스. 인클로징 클래스
	ArrayList<Item> list = new ArrayList<Item>();

	void addItem(String name, int num, int unitPrice) {
		list.add(new Item(name, num, unitPrice)); // 이너 클래스의 생성자 호출
	}

	void removeItem(int index) {
		list.remove(index);
	}

	int getItemNum() {
		return list.size();
	}

	Item getItem(int index) {
		return list.get(index);
	}

	int getTotalPrice() {
		int total = 0;
		for (Item item : list)
			total += item.getPrice(); // 이너 클래스의 메소드 호출
		return total;
	}

	void changeItemNumber(int index, int num) {
		Item item = list.get(index);
		item.num = num; // 이너 클래스의 필드 사용
	}

	class Item { // 상품 항목 클래스. 이너 클래스 --------------------------------- Cart 클래스에 종속된 클래스
		String name;
		int num;
		int unitPrice;

		Item(String name, int num, int unitPrice) {
			this.name = name;
			this.num = num;
			this.unitPrice = unitPrice;
		}

		int getPrice() {
			return num * unitPrice;
		}
	} // --------------------------------------------------------------------
}