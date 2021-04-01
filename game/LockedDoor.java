package study.game;

import e_oop.ScanUtil;

public class LockedDoor extends OutPuzzle{
	
	
	int a;
	int b;
	int c;
	int timeCount;
	
	LockedDoor(){
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
	
	@Override
	void puzzleInfo(){
		System.out.println("--------------------------------");
		System.out.println("        |                    |");
		System.out.println("        |  (●)               |");
		System.out.println("        | [□□□]              |");
		System.out.println("        |                    |");
		System.out.println("--------------------------------");
		System.out.println("<3자리 숫자 자물쇠가 있습니다.>");
		System.out.println("<각 숫자는 0부터 9까지 있습니다.>");
	}
	
	@Override
	void playPuzzle(){
		
		for(int i = 0; i < 10; i++){
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
			
			time();
			
			if(timeCount < 10 && a == this.a && b == this.b && c == this.c){
				System.out.println("덜컥!");
				System.out.println("<문이 열렸습니다!>");
				success();
				break;
			}
			
			if(timeCount > 10){
				System.out.println("GameOver");
				System.out.println();
				failure();
			}
		}
	}
	
	
	private void time(){
		timeCount++;
		System.out.println(timeCount + "/10");
		
		if(timeCount >= 10){
			System.out.println("<경보음이 울립니다. 문 뒤에서 발소리가 들립니다.>");
		}
		failure();
	}
	
	private void success () {
		System.out.println("<당신은 지하실을 탈출했습니다.>");
		System.out.println();
	}
	
	private void failure () {
		System.out.println("<당신은 지하실을 탈출하지 못했습니다.>");
		System.out.println();
	}
	

}
