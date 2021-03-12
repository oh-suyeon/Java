package study;

import java.util.Scanner;

public class operator {

	public static void main(String[] args) {
		// 산술 연산 (사칙, 산술, 증감 연산)
		
		/*한 줄 씩 계산해서 결과값을 도출하세요.
		 * 1. 123456 + 654321
		 * 2. 1번의 결과값 * 123456
		 * 3. 2번의 결과값 / 123456
		 * 4. 3번의 결과값 - 654321
	 	 * 5. 4번의 결과값 % 123456
		 */
		long cal = 123456L + 654321L;
		cal *= 123456L;
		cal /= 123456L;
		cal -= 654321L;
		cal %= 123456L;
		System.out.println(cal);
		
		/*
		 * 3개의 int형 변수를 선언 및 초기화 후 합계와 평균을 출력해주세요.
		 */
		int int1 = 21;
		int int2 = 4;
		int int3 = -54;
		
		int sum = int1 + int2 + int3;
		double avg = (double)sum / 3.0;
		avg = Math.round(avg * 1000) / 1000.0;
		System.out.println("합계 :" + sum + " / 평균 :" + avg);
		
		// 비교 연산 & 논리 연산 & 기타 연산
		
		/*
		 * 2개의 숫자를 입력받고, 둘 중 더 큰 숫자를 출력해주세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("첫 번째 숫자 입력 > ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("두 번째 숫자 입력 > ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		int result = num1 > num2 ? num1 : num2;
		
		System.out.println("더 큰 숫자는 " + result);

		
		/*
		 * <숫자를 입력받고, 그 숫자가 1이나 3이면 남자를, 2나 4면 여자를 출력해주세요. 
   			그 외의 숫자를 입력하면 확인불가를 출력해주세요.>
		 */
	
		System.out.println("숫자 입력 > ");
		int num3 = Integer.parseInt(sc.nextLine());

		String gender = num3 == 1 || num3 == 2 ? "남자" : 
			num3 == 2 || num3 == 4 ? "여자" : "확인불가";
		
		System.out.println("당신의 성별은 " + gender + "입니다." );
	}

}
