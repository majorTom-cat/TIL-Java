import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

class ReceiverThread extends Thread {
	Socket socket;

	ReceiverThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String str = reader.readLine(); // 수신
				if (str == null)
					break;
				System.out.println("수신>" + str);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}