package study;

public class LogicalOperator {

	public static void main(String[] args) {
		/*
		 * 논리연산자
		 * - &&(AND), ||(OR), !(NOT)
		 * - 피연산자로 boolean만 허용한다. 
		 */
		int x = 10;
		int y = 20;
		boolean b = 0 < x && x < 10 || x < y; // &&와 || 둘다 사용된 경우, &&가 우선순위가 높음
	
		b = !(x < y); // 논리연산자는 boolean타입에만 붙을 수 있으므로, !x 같은 건 안된다. 비교연산자인 (x < y)에 붙을 수 있다.
		
		//효율적인 연산
		b = true && true; //true
		b = true && false; //false
		b = false && true; //false
		b = false && false; //false
		
		b = true || true; //true
		b = true || false; //true
		b = false || true; //true
		b = false || false; //false
		// 왼쪽 피연산자에서 결과가 정해지면 오른쪽은 수행하지 않는다. 확인하지 않은 뒷편에는 노란 줄.
		
		int a = 10;
		b = a < 5 && 0 < a++; // 'a < 5'만 확인하고 거짓이니까, 끝나버림. a가 11로 증가하지 않아 의도가 어긋남. 
		System.out.println(a);
		
		//다음의 문장들을 코드로 작성해주세요.
		//1. x가 y보다 크고 x가 10보다 작다.
		b = x > y && x < 10;
		//2. x가 짝수이고 y보다 작거나 같다.
		b = x % 2 == 0 && x <= y;  
		//3. x가 3의 배수이거나 5의 배수이다. 
		b = (x % 3 == 0) || (x % 5 == 0);
		System.out.println(b);
	}

}
