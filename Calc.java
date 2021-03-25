package study;

import java.util.Scanner;

class Calculator{
	int add(int a, int b){
		return a + b;
	}
	
	int substract(int a, int b){
		return a - b;
	}
	
	long multiply(int a, int b){
		return a * b;
	}
	
	double divide(int a, int b){
		return Math.round(a / b * 10) / 10;
	}
}


public class Calc {	
	
	public static void main(String[] args) {
		
		Calculator c = new Calculator();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 정수를 입력해주세요.");
		int firstNum = Integer.parseInt(sc.nextLine());

		System.out.println("부호를 입력해주세요.");
		String buho = sc.nextLine();
		
		System.out.println("두번째 정수를 입력해주세요.");
		int secondNum = Integer.parseInt(sc.nextLine());
		
		int answer = 0;
		long answer2 = 0;
		double answer3 = 0;
		
		if(buho.equals("+")){
			answer = c.add(firstNum, secondNum);
			System.out.println(answer);
		}else if(buho.equals("-")){
			answer = c.substract(firstNum, secondNum);
			System.out.println(answer);
		}else if(buho.equals("*")){
			answer2 = c.multiply(firstNum, secondNum);
			System.out.println(answer2);
		}else if(buho.equals("/")){
			answer3 = c.divide(firstNum, secondNum);
			System.out.println(answer3);
		}else{
			System.out.println("연산종료");
		}
		
		
		
	}

}
