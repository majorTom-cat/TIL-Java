import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientExample1 {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 9000); // 소켓을 생성합니다

			//			InputStream in = socket.getInputStream();
			//			OutputStream out = socket.getOutputStream();
			//
			//			String str = "안녕, 서버"; // 데이터를 송신합니다
			//			out.write(str.getBytes());
			//
			//			byte arr[] = new byte[100]; // 수신된 데이터를 출력합니다
			//			in.read(arr); // 메세지 수신
			//			System.out.println(new String(arr));

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println("안녕, 서버");
			writer.flush();
			String str = reader.readLine();
			System.out.println(str);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close(); // 소켓을 닫습니다
			} catch (Exception e) {
			}
		}
	}
}