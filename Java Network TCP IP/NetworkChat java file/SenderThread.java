import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class SenderThread extends Thread {
	Socket socket;
	String name;

	SenderThread(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// 키보드로 메세지 입력받음. reader : 메세지 입력을 받기위한 객체
			
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			//writer 송신객체
			
			writer.println(name);
			writer.flush();
			while (true) {
				String str = reader.readLine(); // 키보드로부터 메세지 입력받음
				if (str.equals("bye"))
					break;
				writer.println(str); // 송신
				writer.flush();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception ignored) {
			}
		}
	}
}