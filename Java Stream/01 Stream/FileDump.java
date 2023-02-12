import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileDump {
	public static void main(String args[]) { // String args[] 명령행 매개변수
		if (args.length < 1) {
			System.out.println("Usage: java FileDump <filename>");
			return;
		}
//		FileInputStream in = null;
		BufferedInputStream in = null;
		
		try {
//			in = new FileInputStream(args[0]); // output.dat 파일 오픈
			
			in = new BufferedInputStream(new FileInputStream(args[0])); 
			
			byte arr[] = new byte[16];
			while (true) {
				int num = in.read(arr); // 16 바이트 읽어서 저장
				if (num < 0)
					break;
				
				for (int cnt = 0; cnt < num; cnt++)
					System.out.printf("%02x ", arr[cnt]); 
				// X : 16진수 출력, 02 : 2자리수 그리고 빈자리 0, 10진수는 d
				
				System.out.println();
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println(args[0] + " 파일이 존재하지 않습니다.");
		} catch (IOException ioe) {
			System.out.println(args[0] + " 파일을 읽을 수 없습니다.");
		} finally {
			try {
				in.close();
			} catch (Exception e) {
			}
		}
	}
}