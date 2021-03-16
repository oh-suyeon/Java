package study;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		/*
		 * 123 (1~9 사이의 숫자. 중복 안됨)
		 * 입력 받은 숫자 147와 비교해서 1S / 0B / 2O 
		 * 숫자도 같고 자릿수도 같으면 스트라이크 
		 * 숫자 같지만 자릿수 다르면 볼
		 * 숫자도 자릿수도 다르면 아웃
		 * 결과값을 보면서 정답을 계속 맞춰가는 게임
		 * 
		 * 768 1S 0B 20
		 * -> 
		 * 743 0 1 2
		 * -> 
		 * 543 0 1 20
		 * ->
		 * 924 1 1 1
		 * 431 1 0 2
		 * 963 0 0 3
		 * 524 110
		 * 254  
		 *  
		 * 428
		 */

		
		//랜덤한 숫자 3개 만들고 시작 1~9까지 중복되지 않게.
		
		/* 
		 * 랜덤한 숫자 3개 만들기
		 * 
		 * 서로 중복되지 않게 하기
		 *		
		 * 값을 입력받기
		 * 
		 * 스트라이크 변수 / 볼 변수 / 아웃 변수 = 0; 
		 * 
		 * for 문으로 변수에 값을 넣기
		 * 
		 * 값이 3 0 0 이 될때까지 반복하기
		 * 
		 */
		

		Scanner sc = new Scanner(System.in);
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		do {
			a = (int) (Math.random() * 9) + 1;
			b = (int) (Math.random() * 9) + 1;
			c = (int) (Math.random() * 9) + 1;
		} while (a != b && a != c && b != c);
	
		int strike = 0;
		int ball = 0;
		int out = 0;	
		
		System.out.println("야구 게임입니다. \n1 ~ 9까지의 숫자 3개를 중복 없이 입력해주세요." );
		
		do{
			System.out.println("\n첫번째 숫자를 입력하세요> ");
			int a2 = Integer.parseInt(sc.nextLine());
			System.out.println("두번째 숫자를 입력하세요> ");
			int b2 = Integer.parseInt(sc.nextLine());
			System.out.println("세번째 숫자를 입력하세요> ");
			int c2 = Integer.parseInt(sc.nextLine());
			
				if(a == a2){
					strike++;
				}
				if(b == b2){
					strike++;
				}
				if(c == c2){
					strike++;
				}
			
				if(a == b2 || a == c2){
					ball++;
				}
				if(b == a2 || b == c2){
					ball++;
				}
				if(c == a2 || c == b2){
					ball++;
				}
			
				out = 3 - (strike + ball);
			
				System.out.println("Strike : " + strike + " / ball : " + ball + " / out : " + out);
			
				strike = 0;
				ball = 0;
			
		}while (strike < 3);
		
		System.out.println("Strike : 3! 축하합니다!");
			
	}

}
