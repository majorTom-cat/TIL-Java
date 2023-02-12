import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class ReaderExample1 {
	public static void main(String args[]) {
		FileReader reader = null;

		try {
			reader = new FileReader("poem.txt");
			while (true) {
				int data = reader.read();
				if (data == -1)
					break;
				char ch = (char) data;
				System.out.print(ch);
			}
		}

		catch (FileNotFoundException fnfe) { // IOException 의 자식 클래스
			System.out.println("파일이 존재하지 않습니다.");
		}

		catch (IOException ioe) { // FileNotFoundException 보다 먼저 쓰면 에러. IOException 이 부모
			System.out.println("파일을 읽을 수 없습니다.");
		}

		finally {
			try {
				reader.close();
			} catch (Exception e) {
			}
		}
	}
}