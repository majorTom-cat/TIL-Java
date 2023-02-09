abstract class PlayerFactory {
	abstract Player createPlayer();

	interface Player { // 네스티드 인터페이스. 네스티드 인터페이스는 자동으로 static 키워드가 붙음
		void play(String source);

		void stop();
	} //
}