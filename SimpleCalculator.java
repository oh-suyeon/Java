package b_operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		//두개의 숫자와 하나의 사칙 연산자(+, -, *, /, %)를 입력받아 연산결과를 알려주는 프로그램을 만들어주세요.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사칙 연산 계산기입니다.");
		System.out.println("숫자를 입력해주세요 >");
		double num1 = Double.parseDouble(sc.nextLine());
		System.out.println("사칙 연산자를 입력해주세요 >"); 
		String opr = sc.nextLine(); 
		System.out.println("숫자를 입력해주세요 >");
		double num2 = Double.parseDouble(sc.nextLine());
		
		double result = opr.equals("+") ? num1 + num2 :
							opr.equals("-") ? num1 - num2 :
								opr.equals("*") ? num1 * num2 :
									opr.equals("/") ? num1 / num2 : num1 % num2;								
				
		result = Math.round(result * 100.0) / 100.0;
		
		System.out.println(num1 + " " + opr + " " + num2 + " = " + result);
	}

}
