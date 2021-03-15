package study;

import java.util.Scanner;

public class ifAndSwitchTest {

	public static void main(String[] args) {
		
		// 2-14
//		boolean power = true;
//		
//		if (power == true){
//			System.out.println("켜져있습니다.");
//		}

		// 2-15
//		Scanner sc = new Scanner(System.in);
//		System.out.println("숫자를 입력하세요 >>");
//		int input = Integer.parseInt(sc.nextLine());
//		
//		if (input % 2 == 0){
//			System.out.println("2의 배수입니다.");
//		}else {
//			System.out.println("2의 배수가 아닙니다.");
//		}
		
		// 2-16
		
//		int score = (int)(Math.random() * 100) + 1;
//		
//		if (score >= 90){
//			System.out.println("A");
//		}else if (score >= 80){
//			System.out.println("B");
//		}else if (score >= 70){
//			System.out.println("C");			
//		}else if (score >= 60){
//			System.out.println("D");
//		}else{
//			System.out.println("F");
//		}
		
		// 2-16.5
		
//		int score2 = (int)(Math.random() * 100) + 1;
//		String grade = null;
//		
//		if (score2 >= 90){
//			grade = "A";
//			if (score2 >= 95){
//				grade += "+";
//			}else{
//				grade += "-";
//			}
//		}else if (score2 >= 80){
//			grade = "B";
//			if (score2 >= 85){
//				grade += "+";
//			}else{
//				grade += "-";
//			}
//		}else if (score2 >= 70){
//			grade = "C";
//			if (score2 >= 75){
//				grade += "+";
//			}else{
//				grade += "-";
//			}
//		}else if (score2 >= 60){
//			grade = "D";
//			if (score2 >= 65){
//				grade += "+";
//			}else{
//				grade += "-";
//			}
//		}else{
//			grade = "F";					
//		}
//	
//		System.out.println("score : " + score2 + "\ngrade : " + grade);
		
		
		// 2-17
		
//		int random = (int)(Math.random() * 5) + 1; // 1 ~ 5 정수
//		
//		if (random == 1){
//			System.out.println("32평 아파트 당첨");
//		}else if (random == 2){
//			System.out.println("자동차 당첨");
//		}else if (random == 3){
//			System.out.println("노트북 당첨");
//		}else if (random == 4){
//			System.out.println("자전거 당첨");
//		}else {
//			System.out.println("다음 기회에");
//		}
		
		// 2-18
		
//		int score = (int)(Math.random() * 200) / 2; // 0 ~ 100 정수
//		
//		switch(score / 10){
//		case 10: case 9: 
//			System.out.println("A"); break;
//		case 8:
//			System.out.println("B"); break;
//		case 7:
//			System.out.println("C"); break;
//		case 6:
//			System.out.println("D"); break;
//		default:
//			System.out.println("F"); 
//		}
//		
		// 랜덤 값 반올림 해보기
		
//		double random = (Math.random() * 100.0) + 1.0;
//		random = Math.round(random);
//		System.out.println(random);
//		
		//???// 랜덤 값 지정하는 게 헷갈린다. 
		
		double a = (Math.random() * 5.0) + 0.4; // 0 ~ 4.5 + 0.4 -> 0.4 ~ 4.9 -> 0 ~ 5
		a = (int)Math.round(a); // int로 형변환 시켰는데, 자꾸 소수점까지 나온다.
		System.out.println(a);
		
		int b = (int)(Math.random() * 5) + 1; 	// 1 ~ 5.5
		System.out.println(b);					// 1 ~ 5까지 나온다. int타입으로 설정하면 소수점은 그냥 무시되는 건가? 

		// 복습 문제 1~100 랜덤 숫자 3개 오름차순 출력 
//		int x = (int)(Math.random() * 100) + 1;
//		int y = (int)(Math.random() * 100) + 1;
//		int z = (int)(Math.random() * 100) + 1;
//		
//		if (x > y){
//			int t = x;
//			x = y;
//			y = t;
//		}
//		if (x > z){				// 첫번째 if문이 true라고 끝나버리면 안 되니까, else if가 아니라 따로 분리한다.
//			int t = x;
//			x = z;
//			z = t;
//		}
//		if (y > z){
//			int t = y;
//			y = z;
//			z = t;
//		}
//		
//		System.out.println(x + " " + y + " " + z);
		
	
	}

}
