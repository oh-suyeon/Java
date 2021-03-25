package study;

class TestClass{
	static int a = 10;
	static int b = 20;
	int c = 50;
	
	void add01(){
		System.out.println(a + b);
	}
	
	int add02(int c){
		return a + b + c;
	}
	
	int add03(int c){
		return c + this.c;		// <인스턴스변수 c>와 <매개변수 c>의 합을 반환?? 어떻게 구별? this를 써서 전역변수로 만들어주기
	}
	
	void add04(){
		int d = (int)(Math.random() * 100);
		System.out.println(c + d);
	}
	
}

public class methodTest {	
	
	public static void main(String[] args) {
		
		TestClass tc = new TestClass();
		
		tc.add01();
		
		int add02 = tc.add02(2);
		System.out.println(add02);
		
		int add03 = tc.add03(2);
		System.out.println(add03);
		
		tc.add04();
				
	}

}
