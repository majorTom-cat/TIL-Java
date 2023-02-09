class NestedClassExample1 {
	public static void main(String args[]) {
		Cart cart = new Cart();
		cart.addItem("쵸콜렛", 3, 1000);
		cart.addItem("케이크", 1, 25000);
		cart.addItem("샴페인", 1, 7000);
		
		Cart.Item item = cart.new Item("꽃다발", 1, 50000); // 상품 항목 객체를 생성해서 장바구니에 추가합니다.
		cart.list.add(item); // list 바로 접근 가능. private 아니기 때문
		
		printCart(cart);
	}

	static void printCart(Cart cart) {
		int num = cart.getItemNum(); // 3개니까 3저장
		System.out.println(" 상품명 수량 단가 금액");
		System.out.println("----------------------------------");
		for (int cnt = 0; cnt < num; cnt++) {
			//장바구니에 있는 상품 항목을 순서대로 가져와서 출력합니다
			Cart.Item item = cart.getItem(cnt); // 표현 잘 볼 것. Item 은 독립적으로 쓸 수 없음
			System.out.printf("%3d %5s %5d %7d %7d %n", cnt + 1, item.name, item.num, item.unitPrice, item.getPrice());
		}
		System.out.println("----------------------------------");
		System.out.printf(" 총계 %10d %n", cart.getTotalPrice());
	}
}