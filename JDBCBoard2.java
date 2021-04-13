package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import e_oop.ScanUtil;

public class JDBCBoard2 {
	
	SimpleDateFormat dateForm = new SimpleDateFormat("yy-MM-dd");
	
	String regex = "[0-9a-zA-Z]{4,10}";
	Pattern p = Pattern.compile(regex);	
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "djs02061";
	String password = "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// 글 등록 INSERT 
	void post(){
		
		System.out.println("제목 : ");
		String title = ScanUtil.nextLine();
		System.out.println("내용 : ");
		String content = ScanUtil.nextLine();
		System.out.println("작성자 : ");
		String userId = ScanUtil.nextLine();
		
		String pw = "0000";
		while(true){
			System.out.println("비밀번호 : ");
			System.out.println("<영어 대소문자와 숫자를 섞어 4~10글자 입력해주세요.>");
			String tempPw = ScanUtil.nextLine();
			Matcher m = p.matcher(tempPw);
			if(m.matches()){
				pw = tempPw;
				break;
			} else {
				System.out.println("<조건에 맞지 않는 비밀번호입니다.>");
			}
		}
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO tb_jdbc_board (board_no, title, content, user_id, reg_date, password)"
					   + "VALUES (sq_board_no.NEXTVAL, ?, ?, ?, SYSDATE, ?)"; 
			ps = con.prepareStatement(sql);
			ps.setObject(1, title);
			ps.setObject(2, content);
			ps.setObject(3, userId);
			ps.setObject(4, pw);
			
			ps.executeUpdate();
			System.out.println("<게시글을 등록했습니다.> \n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps  != null) try {ps.close(); } catch(Exception e) {};
			if(con != null) try {con.close();} catch(Exception e) {};
		}
	}
	
	// 글 보기 SELECT
	void read(int no){
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "SELECT board_no, title, content, user_id, reg_date"
					+ " FROM tb_jdbc_board WHERE board_no = ?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, no);
			rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println("========================================");
				System.out.print("번호\t제목\t\t작성자\t작성일\n");
				System.out.println("----------------------------------------");
				System.out.print(rs.getObject("board_no") +"\t"+ rs.getObject("title") + "\t\t" + 
								 rs.getObject("user_id") + "\t" + dateForm.format(rs.getObject("reg_date")) + "\n");
				System.out.println("----------------------------------------");
				System.out.println(rs.getObject("content"));
				System.out.println("----------------------------------------");
				System.out.println("\t1.수정\t2.삭제\t0.메인");
				System.out.println("========================================");
			}		
			
			int input = ScanUtil.nextInt();
			switch(input){
			case 1 : boolean bUpdate = checkPassword(no);		// if(checkPassword(no))라고 썼더니, 이 메소드가 두번 실행됨 조심!
					 if(bUpdate){
						 update(no);
					 }
					 read(no);
					 break;
			case 2 : boolean bDelete = checkPassword(no);
					 if(bDelete){
						 delete(no); 
					 }
					 break;
			case 0 : break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs  != null) try {rs.close(); } catch (Exception e) {};
			if(ps  != null) try {ps.close(); } catch (Exception e) {};
			if(con != null) try {con.close();} catch (Exception e) {};
		}
	}
	
	// 비밀번호 확인 SELECT
	boolean checkPassword(int no){
		boolean checkResult = false;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT password  " + 
					   "FROM tb_jdbc_board " +
					   "WHERE board_no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			
			String checkPw = "0000";
			while(rs.next()){
				checkPw = rs.getString("password");
			}
			
			outer:
			while(true){
				System.out.println("<비밀번호를 입력하세요.>");
				String tempPw = ScanUtil.nextLine();
				
				if(tempPw.equals(checkPw)){
					checkResult = true;
					break;
				} else {
					System.out.println("<잘못된 비밀번호 입니다.>\n 1.다시 입력\t0.뒤로 가기");
					int input = ScanUtil.nextInt();
					switch(input){
					case 1: break;
					case 0: break outer; 
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();} catch(Exception e){};
			if(ps != null) try{ps.close();} catch(Exception e){};
			if(con != null) try{con.close();} catch(Exception e){};
		}
		return checkResult;	
	}
	
	
	// 글 수정 UPDATE 
	void update(int no){
		
		System.out.println("수정할 제목 : ");
		String title = ScanUtil.nextLine();
		System.out.println("수정할 내용 : ");
		String content = ScanUtil.nextLine();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE tb_jdbc_board SET "
					   + "title = ?, content = ?, reg_date = SYSDATE "
					   + "WHERE board_no = ?"; 
			ps = con.prepareStatement(sql);
			ps.setObject(1, title);
			ps.setObject(2, content);
			ps.setObject(3, no);
			
			ps.executeUpdate();
			System.out.println("<게시글을 수정했습니다.> \n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps  != null) try {ps.close(); } catch(Exception e) {};
			if(con != null) try {con.close();} catch(Exception e) {};
		}
	}
	
	// 글 삭제 DELETE	+ password
	void delete(int no){
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "DELETE FROM tb_jdbc_board "
					   + "WHERE board_no = ?"; 
			ps = con.prepareStatement(sql);
			ps.setObject(1, no);
			ps.executeUpdate();
			System.out.println("<게시글을 삭제했습니다.> \n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps  != null) try {ps.close(); } catch(Exception e) {};
			if(con != null) try {con.close();} catch(Exception e) {};
		}
	}
	
	
	// 게시판 출력 SELECT
	void boardMain(){

		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "SELECT board_no, title, user_id, reg_date"
					+ " FROM tb_jdbc_board"
					+ " ORDER BY board_no DESC"; 
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			System.out.println("========================================");
			System.out.print("번호\t제목\t\t작성자\t작성일\n");
			System.out.println("----------------------------------------");
			
			while(rs.next()){	
				System.out.print(rs.getObject("board_no") + "\t");
				System.out.print(rs.getObject("title") + "\t\t");
				System.out.print(rs.getObject("user_id") + "\t");
				System.out.print(dateForm.format(rs.getObject("reg_date")) + "\n");
			}
			
			System.out.println("----------------------------------------");
			System.out.println("\t1.조회\t2.등록\t0.종료");
			System.out.println("========================================");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs  != null) try {rs.close(); } catch(Exception e) {};
			if(ps  != null) try {ps.close(); } catch(Exception e) {};
			if(con != null) try {con.close();} catch(Exception e) {};
		}
	}
	
	
	// 게시판 생성 (main)
	void build(){
		while (true) {
			boardMain();
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1 : System.out.println("조회할 글 번호 :");
			 		 int no = ScanUtil.nextInt(); 
					 read(no);
					 break;
			case 2 : post();
					 break;
			case 0 : System.out.println("<종료되었습니다.>");
					 System.exit(0);
					 break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		new JDBCBoard2().build();
	}
}
