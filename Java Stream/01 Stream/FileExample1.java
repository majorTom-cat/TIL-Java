import java.io.File;
import java.util.GregorianCalendar;

class FileExample1 {
	public static void main(String args[]) {
		File file = new File("."); // TestJava 폴더의 목록
		File arr[] = file.listFiles();
		for (int cnt = 0; cnt < arr.length; cnt++) {
			String name = arr[cnt].getName();
			if (arr[cnt].isFile())
				System.out.printf("%-25s %7d ", name, arr[cnt].length()); // arr[cnt].length() : 파일의 크기. 즉 바이트 수
			else
				System.out.printf("%-25s <DIR> ", name);
			long time = arr[cnt].lastModified();
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTimeInMillis(time);
			System.out.printf("%1$tF %1$tT %n", calendar); //F : 날짜, T : 시간
		}
	}
}