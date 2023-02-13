import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class PerClinetThread extends Thread {
    static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
    // 동기화 리스트가 만들어짐. 동기화 리스트를 통해 write를 관리
    // 각 스레드의 멤버지만 따로 관리됨
    
    Socket socket;
    PrintWriter writer;
    PerClinetThread(Socket socket) {
        this.socket= socket;
        try {
            writer = new PrintWriter(socket.getOutputStream()); // 송신 객체 만들어 write에 저장
            list.add(writer);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
	public void run() {
        String name = null;
        try {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())); // 각 스레드마다 데이터 수신할수있는 객체 만듬
            name = reader.readLine(); // 수신(메세지를 수신) - 첫번째 메세지는 닉네임
            sendAll("#" + name + "님이 들어오셨습니다.");
            while (true) {
                String str = reader.readLine(); // 실제 메세지 수신
                if (str == null)
                    break;
                sendAll(name + ">" + str);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            list.remove(writer);
            sendAll("#" + name + "님이 나가셨습니다.");
            try {
                socket.close();
            }
            catch (Exception ignored) {
            }
        }
    }
    private void sendAll(String str) {  
        for (PrintWriter writer : list) {
            writer.println(str);
            writer.flush();
        }
    }
}
