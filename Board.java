package study;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class Board {
	
	static ArrayList<HashMap<String, Object>> postList = new ArrayList<>();
	
	static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");

	static int maxBoardNo(){
		int maxBoardNo = 0;
		for(int i = 0; i < postList.size(); i++){
			int boardNo = (Integer) postList.get(i).get("번호");
			if(maxBoardNo < boardNo){
				maxBoardNo = boardNo;
			}
		}
		return maxBoardNo;
	}	
	
	static void boardMain(){
		System.out.println("======================================");
		System.out.println("번호\t제목\t\t작성자\t작성일");
		System.out.println("--------------------------------------");
		for(int i = postList.size() - 1; i >= 0; i--){
			HashMap<String, Object> temp = postList.get(i);
			System.out.println(temp.get("번호") + "\t" +
							   temp.get("제목") + "\t\t" +
							   temp.get("작성자") + "\t" +
							   temp.get("작성일"));
		}
		System.out.println("======================================");
		System.out.println("1.조회\t\t2.등록\t\t3.종료");
	}

	static void post(){
		System.out.println("제목 : ");
		String title = ScanUtil.nextLine();
		System.out.println("작성자 : ");
		String name = ScanUtil.nextLine();
		System.out.println("내용 : ");
		String content = ScanUtil.nextLine();
		
		HashMap<String, Object> row = new HashMap<>();
		row.put("번호", maxBoardNo() + 1);
		row.put("제목", title);
		row.put("작성자", name);
		row.put("작성일", dateFormat.format(new Date()));
		row.put("내용", content);
		postList.add(row);
	}
	
	static void postBase(String title, String name, String content){
		HashMap<String, Object> row = new HashMap<>();
		row.put("번호", maxBoardNo() + 1);
		row.put("제목", title);
		row.put("작성자", name);
		row.put("작성일", dateFormat.format(new Date()));
		row.put("내용", content);
		postList.add(row);
	}
	
	static void read(){
		System.out.println("글 번호를 입력해주세요.");
		int n = ScanUtil.nextInt();
		
		int index = 0;
		for(int i = 0; i < postList.size(); i++){
			if((Integer)postList.get(i).get("번호") == n){
				index = i;
				break;
			}
		}
		
		System.out.println("======================================");
		System.out.println("번호\t제목\t\t작성자\t작성일");
		System.out.println("--------------------------------------");
		System.out.println(postList.get(index).get("번호") + "\t" +
						   postList.get(index).get("제목") + "\t\t" +
						   postList.get(index).get("작성자") + "\t" +
						   postList.get(index).get("작성일"));
		System.out.println("--------------------------------------");
		System.out.println(postList.get(index).get("내용"));
		System.out.println("======================================");
		System.out.println("1.수정\t\t2.삭제\t\t3.메인");
		
		int i = ScanUtil.nextInt();
		switch(i){
		case 1 : modify(index); 
		 		 break;
		case 2 : delete(index);
				 break; 
		case 3 : break;
		}
	}
	
	static void modify(int index){
		System.out.println("제목 : ");
		String title = ScanUtil.nextLine();
		System.out.println("내용 : ");
		String content = ScanUtil.nextLine();

		postList.get(index);
		postList.get(index).put("제목", title);
		postList.get(index).put("내용", content);
		postList.get(index).put("작성일", dateFormat.format(new Date()));
	}
	
	
	static void delete(int index){
		postList.remove(index);
	}
	
	
	static void build(){
		while (true) {
			boardMain();
			
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1 : read();
					 break;
			case 2 : post();
					 break;
			case 3 : System.out.println("종료되었습니다.");
					 System.exit(0);
					 break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		postBase("안녕하세요1", "홍길동", "안녕하세요 내용입니다1");
		postBase("안녕하세요2", "홍길동", "안녕하세요 내용입니다2");
		postBase("안녕하세요3", "홍길동", "안녕하세요 내용입니다3");
		postBase("안녕하세요4", "홍길동", "안녕하세요 내용입니다4");
		
		build();
	}

}

