class EMailSender extends MessageSender {
	String sender;
	String receiver;

	EMailSender(String sender, String receiver) {
		this.sender = sender;
		this.receiver = receiver;
	}

	@Override
	void send(String message) {
		System.out.println("보내는 사람:" + sender);
		System.out.println("받는 사람:" + receiver);
		System.out.println("내용:" + message);
		System.out.println();
	}
}