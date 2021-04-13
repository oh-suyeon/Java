package study;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k_jdbc.JDBCUtil;
import e_oop.ScanUtil;

public class JDBCBoard3 {
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	SimpleDateFormat dateForm = new SimpleDateFormat("yy-MM-dd");
	
	String regex = "[0-9a-zA-Z]{4,10}";
	Pattern p = Pattern.compile(regex);	
	
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
		
		String sql = "INSERT INTO tb_jdbc_board (board_no, title, content, user_id, reg_date, password)"
				   + "VALUES (sq_board_no.NEXTVAL, ?, ?, ?, SYSDATE, ?)"; 
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(userId);
		param.add(pw);
		
		jdbc.update(sql, param);
		
		System.out.println("<게시글을 등록했습니다.> \n");
			
	}
	
	// 글 보기 SELECT
	void read(int no){
		
			String sql = "SELECT board_no, title, content, user_id, reg_date"
					+ " FROM tb_jdbc_board WHERE board_no = ?";
			List<Object> param = new ArrayList<>();
			param.add(no);
			Map<String, Object> row = jdbc.selectOne(sql, param);
			
			System.out.println("========================================");
			System.out.print("번호\t제목\t\t작성자\t작성일\n");
			System.out.println("----------------------------------------");
			System.out.print(row.get("BOARD_NO") + "\t" + row.get("TITLE") + "\t\t" + 		// 대문자!
							 row.get("USER_ID") + "\t" + dateForm.format(row.get("REG_DATE")) + "\n");
			System.out.println("----------------------------------------");
			System.out.println(row.get("CONTENT"));
			System.out.println("----------------------------------------");
			System.out.println("\t1.수정\t2.삭제\t0.메인");
			System.out.println("========================================");
			
			int input = ScanUtil.nextInt();
			switch(input){
			case 1 : boolean bUpdate = checkPassword(no);	
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
	}
	
	// 비밀번호 확인 SELECT
	boolean checkPassword(int no){
		boolean checkResult = false;
		
		String sql = "SELECT password  " + 
			 	     "FROM tb_jdbc_board " +
				     "WHERE board_no = ?";
		List<Object> param = new ArrayList<>();
		param.add(no);
	
		Map<String, Object> row = jdbc.selectOne(sql, param);
			
		String checkPw = (String)row.get("PASSWORD");
			
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
		return checkResult;	
	}
		
	// 글 수정 UPDATE 
	void update(int no){
		
		System.out.println("수정할 제목 : ");
		String title = ScanUtil.nextLine();
		System.out.println("수정할 내용 : ");
		String content = ScanUtil.nextLine();
		
			String sql = "UPDATE tb_jdbc_board SET "
					   + "title = ?, content = ?, reg_date = SYSDATE "
					   + "WHERE board_no = ?"; 
			List<Object> param = new ArrayList<>();
			param.add(title);
			param.add(content);
			param.add(no);
			jdbc.update(sql, param);
			
			System.out.println("<게시글을 수정했습니다.> \n");
	}
	
	// 글 삭제 DELETE
	void delete(int no){
		
			String sql = "DELETE FROM tb_jdbc_board "
					   + "WHERE board_no = ?"; 
			List<Object> param = new ArrayList<>();
			jdbc.update(sql, param);
			
			System.out.println("<게시글을 삭제했습니다.> \n");
	}
	
	// 게시판 출력 SELECT
	void boardMain(){

			String sql = "SELECT board_no, title, user_id, reg_date"
					+ " FROM tb_jdbc_board"
					+ " ORDER BY board_no DESC"; 
			List<Map<String, Object>> list = jdbc.selectList(sql);
			
			System.out.println("========================================");
			System.out.print("번호\t제목\t\t작성자\t작성일\n");
			System.out.println("----------------------------------------");
			
			for(int i = 0; i < list.size(); i++){
				Map<String, Object> row = list.get(i);
				System.out.print(row.get("BOARD_NO") + "\t" + row.get("TITLE") + "\t\t" + 
							     row.get("USER_ID") + "\t" + dateForm.format(row.get("REG_DATE")) + "\n");
			}
			System.out.println("----------------------------------------");
			System.out.println("\t1.조회\t2.등록\t0.종료");
			System.out.println("========================================");
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
		new JDBCBoard3().build();
	}
}
