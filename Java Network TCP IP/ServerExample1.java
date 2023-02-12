
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerExample1 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000); // 서버 소켓을 생성합니다

			socket = serverSocket.accept(); // 연결 요청이 오면 소켓을 생성합니다. 커서 대기

			//			InputStream in = socket.getInputStream();
			//			OutputStream out = socket.getOutputStream();
			//			
			//			byte arr[] = new byte[100]; // 수신된 데이터를 출력합니다. 배열 사용하면 한번에 100 바이트 읽어올수있음 원래는 1바이트씩
			//			in.read(arr);
			//			System.out.println(new String(arr));
			//			
			//			String str = "안녕, 클라이언트"; // 데이터를 송신합니다
			//			out.write(str.getBytes());

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			String str = reader.readLine();
			System.out.println(str);
			writer.println("안녕, 클라이언트");
			writer.flush();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close(); // 소켓을 닫습니다
			} catch (Exception ignored) {
			}
			try {
				serverSocket.close(); // 서버 소켓을 닫습니다
			} catch (Exception ignored) {
			}
		}
	}
}