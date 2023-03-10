import java.net.Socket;

class ClientExample4 { // 명령행 매개변수를 하나 전달받을것
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java ClientExample4 <user-name>");
			return;
		}
		try {
			Socket socket = new Socket("127.0.0.1", 9002);
			Thread thread1 = new SenderThread(socket, args[0]);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
