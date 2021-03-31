package study.game;

import e_oop.ScanUtil;

public class OutPuzzle {
	
	int a;
	int b;
	int c;
	int timeCount;
	
	OutPuzzle(){
		a = (int)(Math.random() * 9);
		while(true){
			int b = (int)(Math.random() * 9);
			if(b != a){
				this.b = b;
				break;
			}
		}
		while(true){
			int c = (int)(Math.random() * 9);
			if(c != a && c!= b){
				this.c = c;
				break;
			}
		}
		timeCount = 0;
	}
	
	void explainPuzzle(){
		System.out.println("<3자리 숫자 자물쇠가 있습니다.>");
		System.out.println("<각 숫자는 0부터 9까지 있습니다.>");
		System.out.println("\tㅁ ㅁ ㅁ");
	}
	
	void playPuzzle(){
		
		System.out.println("<0부터 9까지의 숫자 세 개를 입력하세요.>");
		int number = ScanUtil.nextInt();
		
		int c = number % 10;
		int b = (number / 10) % 10;
		int a = number / 100; 
		
		if(a == this.a){
			System.out.print("■");
		}else if(a == this.b || a == this.c){
			System.out.print("▣");
		}else{
			System.out.print("□");
		}
		
		if(b == this.b){
			System.out.print("■");
		}else if(b == this.c || b == this.a){
			System.out.print("▣");
		}else{
			System.out.print("□");
		}
		
		if(c == this.c){
			System.out.print("■");
		}else if(c == this.b || c == this.a){
			System.out.print("▣");
		}else{
			System.out.print("□");
		}
		
	}
	
	void time(){
		timeCount++;
		System.out.println(timeCount + "/10");
		
		if(timeCount >= 10){
			System.out.println("<경보음이 울립니다. 발소리가 들립니다.>");
		}
	}
	
	
	public static void main(String[] args) {
		OutPuzzle p = new OutPuzzle();
		p.playPuzzle();
	} 
	
	
	
}


