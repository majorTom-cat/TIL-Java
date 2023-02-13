import java.io.BufferedReader;
import java.io.IOException;
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
			// reader : 수신 객체
			
			while (true) {
				String str = reader.readLine(); // 서바가 보내온 메세지 수신
				if (str == null)
					break;
				System.out.println(str);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
