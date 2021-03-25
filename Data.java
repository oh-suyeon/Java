package study;

class DataMethod{
	int x;
		
}


public class Data {

	public static void main(String[] args) {
		
		DataMethod d1 = new DataMethod();
		
		d1.x = 10;
		
		System.out.println(d1.x);
		
//		d1.change2();
		

	}

	static void change(int x){
		x = 1000;
		System.out.println("change() 기본형 : " + x);
	}
	
	static void change2(DataMethod d1){
		d1.x = 1000;
		System.out.println("change2() 참조형 : " + d1.x);
	}


}
