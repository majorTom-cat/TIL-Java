package Java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SawonToJDBCAnother {

	public static void main(String[] args) {
		int menu;

		Scanner scan = new Scanner(System.in);

		while (true) {
			printMenu();
			System.out.print("메뉴 선택 => ");
			menu = scan.nextInt();
			System.out.println();

			if (menu == 6) {
				System.out.println("The End...");
				break;
			}

			switch (menu) {
			case 1:
				input_sawon();
				break;
			case 2:
				output_sawon();
				break;
			case 3:
				search_sawon();
				break;
			case 4:
				update_sawon();
				break;
			case 5:
				delete_sawon();
				break;
			default:

			}
		}

	} // main 메소드의 끝 ===============================================

	static void printMenu() {
		System.out.println("*** 사원관리 ***");
		System.out.println("1. 사원정보 입력");
		System.out.println("2. 사원정보 출력");
		System.out.println("3. 사원정보 조회");
		System.out.println("4. 사원정보 수정");
		System.out.println("5. 사원정보 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}
	
	static Connection connectDB() {
		Connection con = null;
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/tabledb";
					
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "123456");
		}
		catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		}
		return con;
	}
	
	
	static void input_sawon() {
		
		Connection con = null; // try 블록 바깥에 선언해주자
		PreparedStatement pstmt = null; // try 블록 바깥에 선언해주자
		
		Sawon obj = new Sawon(); // 이 세 문장은 try 안에 집어넣어도 크게 상관 x
		obj.inputData();
		String sql = "insert into sawon values(?,?,?,?,?)"; // ? PreparedStament 타입의 객체
		
		try {
			con = connectDB();
			
			if (con == null) // db에 연결할게 없기때문에
				return;
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.sabun);
			pstmt.setString(2, obj.deptname);
			pstmt.setString(3, obj.irum);
			pstmt.setString(4, obj.gender);
			pstmt.setString(5, obj.email);
			int res = pstmt.executeUpdate(); // executeUpdate() 메서드도 리턴값이 있다. 영향받은 행 갯수 리턴
			if (res == 1) // 1개를 성공적으로 insert 했으면 1이 리턴됨
				System.out.println("\n사원정보 입력 성공\n");
			
		} catch (Exception e) {
			System.out.println("\n이미 입력된 사원입니다 = " + e.getMessage());
		}
		finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	} // input_sawon 메소드의 끝 ===================================
	
	static void output_sawon() {
		Connection con = null; // try 블록 바깥에 선언해주자
		PreparedStatement pstmt1 = null; // try 블록 바깥에 선언해주자
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		// try 안에 있어도 됨
		String sql1 = "select count(*) from sawon"; 
		String sql2 = "select * from sawon order by sawon";
		
		try {
			Sawon obj = new Sawon(); // 데이터 출력할때 활용하려고 선언
			
			con = connectDB();
			pstmt1 = con.prepareStatement(sql1);
			rs1 = pstmt1.executeQuery();
			rs1.next(); // 결과의 첫번째 행에 접근
			if (rs1.getInt(1) == 0) // 1열
				System.out.println("\n출력할 데이터가 없습니다\n");
			else {
				pstmt2 = con.prepareStatement(sql2);
				rs2 = pstmt2.executeQuery();
				
				System.out.println();
				System.out.println("-----------------------------------");
				System.out.println("사원번호\t 부서명\t 이름\t 성별\t 이메일\t");
				System.out.println("-----------------------------------");
				while(rs2.next()) {
					obj.sabun = rs2.getString("sabun");
					obj.sabun = rs2.getString("deptname");
					obj.sabun = rs2.getString("irum");
					obj.sabun = rs2.getString("gender");
					obj.sabun = rs2.getString("email");
				}
				System.out.println("-----------------------------------");
				// 사원 수 필요하면 rs1.getInt(1) 활용
				
			}
			
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패 = " + e.getMessage());
		}
		finally {
			try {
				if(rs1 != null) rs1.close();
				if(rs2 != null) rs2.close();
				if(pstmt1 != null) pstmt1.close();
				if(pstmt2 != null) pstmt2.close();
				if(con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	} // output_sawon 메소드의 끝 ======================================
	
	static void search_sawon() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon where sabun = ?";
		
		// 다른 방식으로 해봤음
		try {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("조회할 사원번호 입력 => ");
			String sabun = scan.next();
			
			con = connectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sabun);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println();
				System.out.println("사원번호 : " + rs.getString("sabun"));
				System.out.println("부서명 : " + rs.getString("deptname"));
				System.out.println("사원이름 : " + rs.getString("irum"));
				System.out.println("성별 : " + rs.getString("gender"));
				System.out.println("이메일 : " + rs.getString("email") + "\n");
			} else {
				System.out.println("\n존재하지 않는 사원번호입니다\n");
			}
			
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패 = " + e.getMessage());
		}
		
	} // search_sawon 메소드의 끝 ======================================
	
	static void update_sawon() {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update sawon set deptname=?, email=? where sabun = ?";
		
		try {
			Scanner scan = new Scanner(System.in);
			Sawon obj = new Sawon(); // 이번 예제는 객체 안만들고 String으로 각각 처리해도 됨
			
			System.out.println("수정할 사원번호 입력 => ");
			obj.sabun = scan.next();
			System.out.println("수정할 부서명 입력 => ");
			obj.deptname = scan.next();
			System.out.println("수정할 이메일 입력 => ");
			obj.email = scan.next();
			
			con = connectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.deptname);
			pstmt.setString(2, obj.email);
			pstmt.setString(3, obj.sabun);
			int res = pstmt.executeUpdate();
			if (res == 1) {
				System.out.println("\n" + obj.sabun + " 사원정보 수정 완료\n");
			} else {
				System.out.println("\n존해아지 않는 사원번호입니다\n");
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패 = " + e.getMessage());
		}
		finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	} // update_sawon 메소드의 끝 ======================================
	
	static void delete_sawon() {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete from sawon where sabun =?";
		
		try {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("삭제할 사원번호 입력 => ");
			String sabun = scan.next();
			
			con = connectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sabun);
			
			int res = pstmt.executeUpdate();
			if (res == 1) {
				System.out.println("\n" + sabun + " 사원정보 삭제 완료\n");
			} else {
				System.out.println("\n존해아지 않는 사원번호입니다\n");}
			
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패 = " + e.getMessage());
		}
		finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	} // delete_sawon 메소드의 끝 ======================================
	

} // SawonToJDBCAnother 클래스의 끝

class Sawon { // =================================================================================

	String sabun, deptname, irum, gender, email;

	Sawon() {
	}

//	@Override
//	public int hashCode() {
//		return sabun.hashCode();
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof Sawon))
//			return false;
//		Sawon name = (Sawon) obj;
//		if (sabun.equals(name.sabun))
//			return true;
//		else
//			return false;
//	}

	public void inputData() {

		Scanner scan = new Scanner(System.in);

		System.out.print("사원번호 입력 => ");
		sabun = scan.next();

		System.out.print("부서 입력 => ");
		deptname = scan.next();

		System.out.print("이름 입력 => ");
		irum = scan.next();

		System.out.print("성별 입력 => ");
		gender = scan.next();

		System.out.print("이메일 입력 => ");
		email = scan.next();
	}

	public void outputData() {
		System.out.printf("%5s %6s %9s %9s %20s\n", sabun, deptname, irum, gender, email);

	}

} // Sawon 클래스의 끝