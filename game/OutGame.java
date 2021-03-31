package study.game;

import e_oop.ScanUtil;


public class OutGame {

	OutCharacter c;
	OutGhost g1; 
	OutBox b1 = new OutBox();
	OutItem[] items;
	OutRoom r1 = new OutRoom();

	OutGame(){
		c = new OutCharacter("JANE", 100, 100, 50, 50);
		g1 = new OutGhost("MIKE", 100, 100, 50);
	}
	
	public static void main(String[] args) {
		new OutGame().Start();
	}
	
	private void Start(){
		
		r1.showRoom();
		
		escape:
		while(true){
			int input = ScanUtil.nextInt();
			switch(input){
			case 1: b1.openBox(c);
					getBack();
				    break;
			case 2: r1.interactGhost();
					g1.Quiz(c);
					getBack();		// 오답일 경우 뒤로 가기가 나오지 않음.
					break;
			case 3: r1.openDoor();
					getBack();
					break;
			case 0: c.showInfo();
					break;
			default : break escape;
			}
		}		
	}
		
	
	private void getBack(){
		System.out.println("<뒤로 물러서려면 (9)키를 누르세요.>");
		int input = ScanUtil.nextInt();
		back:
		switch(input){
		case 9: Start(); break;
		default: break back;
		}
	}
	
	
	
}
