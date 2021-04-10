package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;


import e_oop.ScanUtil;

public class JDBCBoard {
	
	SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd");
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "djs02061";
	String password = "java";
	
	// 글 등록 INSERT
	void post(){

		Connection con = null;
		PreparedStatement ps = null;
		
		HashMap<String, Object> row = new HashMap<>();
		
		System.out.println("제목 : ");
		row.put("title", ScanUtil.nextLine());
		System.out.println("내용 : ");
		row.put("content", ScanUtil.nextLine());
		System.out.println("작성자 : ");
		row.put("userId", ScanUtil.nextLine());
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO tb_jdbc_board (board_no, title, content, user_id, reg_date)"
					   + "VALUES (sq_board_no.NEXTVAL, ?, ?, ?, SYSDATE)"; 
			ps = con.prepareStatement(sql);
			ps.setObject(1, row.get("title"));
			ps.setObject(2, row.get("content"));
			ps.setObject(3, row.get("userId"));
			
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
	void read(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		System.out.println("조회할 글 번호 : ");
		int no = ScanUtil.nextInt();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM tb_jdbc_board WHERE board_no = ?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, no);
			rs = ps.executeQuery();
			
			HashMap<String, Object> row = new HashMap<>();	
			while(rs.next()){
				row.put("boardNo", rs.getObject("board_no"));
				row.put("title", rs.getObject("title"));
				row.put("content", rs.getObject("content"));
				row.put("userId", rs.getObject("user_id"));
				row.put("regDate", rs.getObject("reg_date"));	
			}		
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			System.out.println("=====================================================================================================");
			for(int i = 1; i <= columnCount; i++){
				if(i != 3){
					System.out.print(metaData.getColumnName(i) + "\t\t\t");
				}
			}System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.print(row.get("boardNo") +"\t\t\t\t"+ row.get("title") + "\t\t\t" + row.get("userId") + "\t\t\t" + row.get("regDate") + "\n");
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.println(row.get("content"));
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t1. 수정\t\t2. 삭제\t\t0. 메인");
			System.out.println("=====================================================================================================");
			
			int input = ScanUtil.nextInt();
			switch(input){
			case 1 : update(no);
					 break;
			case 2 : delete(no);
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
	
	// 글 수정 UPDATE
	void update(int no){
		Connection con = null;
		PreparedStatement ps = null;
		
		HashMap<String, Object> row = new HashMap<>();
		
		System.out.println("수정할 제목 : ");
		row.put("title", ScanUtil.nextLine());
		System.out.println("수정할 내용 : ");
		row.put("content", ScanUtil.nextLine());
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE tb_jdbc_board SET "
					   + "title = ?, content = ?, reg_date = SYSDATE) "
					   + "WHERE board_no = ?"; 
			ps = con.prepareStatement(sql);
			ps.setObject(1, row.get("title"));
			ps.setObject(2, row.get("content"));
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
	
	// 글 삭제 DELETE	
	void delete(int no){
		Connection con = null;
		PreparedStatement ps = null;
		
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
		
		ArrayList<HashMap<String, Object>> boardList = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM tb_jdbc_board"; 
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			System.out.println("=====================================================================================================");
			for(int i = 1; i <= columnCount; i++){
				if(i != 3){
					System.out.print(metaData.getColumnName(i) + "\t\t\t");
				}
			}System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------------");
			
			while(rs.next()){	
				HashMap<String, Object> row = new HashMap<>();
				row.put("boardNo", rs.getObject("board_no"));
				row.put("title", rs.getObject("title"));
				row.put("content", rs.getObject("content"));
				row.put("userId", rs.getObject("user_id"));
				row.put("regDate", rs.getObject("reg_date"));
				boardList.add(row);
			}
			
			for(int i = 0; i < boardList.size() - 1; i++){
				int max = i;
				for(int j = i + 1; j < boardList.size(); j++){
					if(Integer.parseInt(String.valueOf(boardList.get(max).get("boardNo"))) < Integer.parseInt(String.valueOf(boardList.get(j).get("boardNo"))))
						max = j;
				}
				HashMap<String, Object> tempRow = boardList.set(i, boardList.get(max));
				boardList.set(max, tempRow);
			}
			
			for(int i = 0; i < boardList.size(); i++){	// 역순으로 출력
				System.out.print(boardList.get(i).get("boardNo") + "\t\t\t\t");
				System.out.print(boardList.get(i).get("title")   + "\t\t\t");
				System.out.print(boardList.get(i).get("userId")  + "\t\t\t");
				System.out.print(dateForm.format(boardList.get(i).get("regDate")) + "\t\t\t");
				System.out.println();
			}
			
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t1. 조회\t\t2. 등록\t\t0. 종료");
			System.out.println("=====================================================================================================");
			
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
			case 1 : read();
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
		JDBCBoard j = new JDBCBoard();
		j.build();
	}
}
