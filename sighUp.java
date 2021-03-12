package study;

import java.util.Scanner;

public class sighUp {

	public static void main(String[] args) {
		
		/*
		 * ========== 회원가입 ==========
		 * 아이디>admin
		 * 비밀번호(4자리 숫자)>1234
		 * 이름>홍길동
		 * 나이>30
		 * 키>185.5
		 * ===========================
		 * 회원가입 완료!!
		 * ========== 내 정보  ===========
		 * 아이디 : admin
		 * 비밀번호 : 1234
		 * 이름 : 홍길동
		 * 나이 : 30세
		 * 키 : 185.5cm
		 * ===========================
		 */
		
		Scanner sc = new Scanner(System.in);

		String id;
		int password;
		String name;
		int age;
		double height;
		
		System.out.println("========== 회원가입 ==========");
		
		System.out.println("아이디를 입력하세요 >");
		id = sc.nextLine();
		System.out.println("비밀번호 네 자리를 입력하세요 >");
		password = Integer.parseInt(sc.nextLine());
		System.out.println("이름을 입력하세요 >");
		name = sc.nextLine();
		System.out.println("나이를 입력하세요 >");
		age = Integer.parseInt(sc.nextLine());
		System.out.println("키를 입력하세요 >");
		height = Double.parseDouble(sc.nextLine());
		
		System.out.println("===========================");
		System.out.println("회원가입 완료!!");
		System.out.println("===========================");
		
		System.out.println("아이디 :" + id);
		System.out.println("비밀번호 :" + password);
		System.out.println("이름 :" + name);
		System.out.println("나이 :" + age + "세");
		System.out.println("키 :" + height + "cm");
		
		System.out.println("===========================");		
		
	}

}
