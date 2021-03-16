package study;

import java.util.Scanner;

public class repetitiveSatatement {

	public static void main(String[] args) {
		// 1부터 10까지 합계를 저장
		// 1 + 2 + 3 + ... + 10 반복
		
		int sum = 0;
		
		for(int i = 1; i <= 10; i++){
			sum += i;
		}System.out.println(sum);
		
		
		// 1부터 100까지 짝수의 합 출력
		// 2 + 4 + 6 + ... + 100 
		
		sum = 0;
		
		for(int i = 1; i <= 50; i++){
			sum += i * 2;
		}System.out.println(sum);
		
		// 1부터 20까지 홀수의 합 출력
		// 1 + 3 + ... + 19
		
		sum = 0;

		for(int i = 1; i <= 20; i++){
			if(i % 2 == 1){
				sum += i;
			}
		}System.out.println(sum);
		
		sum = 0;
		
		for(int i = 1; i <= 19; i += 2){
			sum += i;		
		}System.out.println(sum);
			
		// 구구단 출력 -- 2단
		// 2 * 1 = 2
		// 2 * 2 = 4
		// ...
		// 2 * i =  2 * i
		
		for(int i = 1; i <= 9; i++){
			System.out.println(2 + " * " + i + " = " + i * 2 );
		}System.out.println();
			
		// 구구단 출력 -- 2단 ~ 3단
		// if문이 한바퀴 돌면, 앞의 2가 3으로 바뀌어야 한다. 
		
		for(int j = 2; j <= 3; j++){
			for(int i = 1; i <= 3; i++){
				System.out.println(j + " * " + i + " = " + i * j );
			}System.out.println();
		}
		
		// 구구단 출력 -- 가로로 배열하기
		// 2 * 1 = 2	3 * 1 = 3 
		// 2 * 2 = 4	3 * 2 = 6
		for(int i = 1; i <= 5; i++){
			for(int j = 2; j <= 9; j++){
				System.out.print(j + " * " + i + " = " + i * j + "\t");
			}System.out.println();
		}
		
		System.out.println();
		
		// a에 2씩 몇 번을 곱해야 1000이상이 될까?
		// a * 2 * 2 * 2 ... >= 1000 
		int a = 1;
		int count = 0;
		
		while(a <= 1000){
			a *= 2;
			count++;
		}System.out.println("count : " + count + " / a : " + a);
		
		System.out.println();
		
		a = 1;
		count = 0;
		
		while(a < 1000){
			a *= 2;
			count += 1;				
		}System.out.println("count : " + (count - 1) + " / a : " + (a / 2));
		
		System.out.println();
		
		// 1~100 숫자 맞추기 게임 up, down
		
//		Scanner sc = new Scanner(System.in);
//		
//		int rn = (int)(Math.random() * 100) + 1;
//		
//		System.out.println("1~100 숫자 입력 >");
//		int answer = Integer.parseInt(sc.nextLine());
//		
//		while(rn != answer){
//			if(answer < rn){
//				System.out.println("UP! 숫자 입력 >");
//				answer = Integer.parseInt(sc.nextLine());
//			}else if(answer > rn){
//				System.out.println("DOWN! 숫자 입력 >");
//				answer = Integer.parseInt(sc.nextLine());
//			}
//		}System.out.println("정답입니다!");
//		
//		System.out.println();
		
		// 별짓기 패턴. 네모 5*5
		// *****
		
		int row = 1;
		int col = 1;
		
		while(col <= 5){
			col++;
			row = 1;						// 내부 반복문 때문에 row 값이 6이 된 상태. 1로 초기화해주지 않으면 다시 실행되지 않는다. 
			while(row <= 5){
				row++;
				System.out.print("*");
			}System.out.println();
		}
		
		System.out.println();
		
		for(col = 1; col <= 5; col++){
			for(row = 1; row <= 5; row++){	// while과 다르게 초기화 문장이 이미 있다.
				System.out.print("*");
			}System.out.println();
		}
		
		System.out.println();
		
		for (int i = 5; i >= 1; i--){
			for (int j = 1; j <= i; j++){
				System.out.print("*");
			}System.out.println();
		}
		
		System.out.println();
		
		for (int i = 1; i <= 5; i++){
			for (int j = 1; j <= i; j++){
				System.out.print("*");
			}System.out.println();
		}
		
		System.out.println(); 
		
		for (int j = 1; j <= 5; j++) {
			for (int i = 1; i <= 5; i++) {
				if (i < j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		for (int j = 1; j <= 5; j++) {
			for (int i = 1; i <= 5; i++) {
				if (i <= j) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		} 
		
		
		
	

	}

}
