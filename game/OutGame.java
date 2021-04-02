package study.game;

import e_oop.ScanUtil;

public class OutGame {

	OutCharacter c;
	OutItem[] items;
	Basement basement;
	IceBox icebox; 
	Ghost ghost1;
	LockedDoor door1;
	GhostCard gc;
	Memo m;
	
	OutGame(){
		c = new OutCharacter("Jane", 10, 10, 10, 10);
		basement = new Basement();
		icebox = new IceBox("아이스 박스", 0, 0, 0, items);
		ghost1 = new Ghost("Mike", 10, 10, 10, items);
		door1 = new LockedDoor();
		
		gc = new GhostCard(ghost1);
		icebox.items = new OutItem[1];
		icebox.items[0] = gc;
		
		m = new Memo("쪽지", 0, 0, 0, 0);
		ghost1.items = new OutItem[1];
		ghost1.items[0] = m;
	}

	public static void main(String[] args) {
		new OutGame().start();
	}
	
	private void start() {
		int input = 0;
		while(true){
			basement.showRoom();
			System.out.println("<당신의 상태를 보려면 '0'키를 누르세요.>");
			input = ScanUtil.nextInt();
			
			escape :
			switch(input){
				case 0: c.characterInfo(c);
						getBack();
						break;
				case 1: icebox.monsterInfo(c);
							System.out.println("상자를 뒤져보려면 (1), 뒤로 가려면 (2)키를 누르세요.");
							int input2 = ScanUtil.nextInt();
								switch(input2){
									case 1: icebox.interact(c);
											break;
									default: break;
								}
						break;
				case 2: ghost1.monsterInfo(c); 
							System.out.println("이름을 알려주려면 (1), 뒤로 가려면 (2)키를 누르세요.");
							input2 = ScanUtil.nextInt();
								switch(input2){
									case 1: ghost1.interact(c);
											break;
									default: break;
								}
						break;
				case 3: door1.puzzleInfo(); 
							System.out.println("문을 열어보려면 (1), 뒤로 가려면 (2)키를 누르세요.");
							input2 = ScanUtil.nextInt();
								switch(input2){
									case 1: door1.interact();
											break;
									default: break;
								}
						break;
				default : break escape;
			}
		}
	}
	
	
	private void getBack() {
		System.out.println("<뒤로 가려면 (9)키를 누르세요.>");
		int input = ScanUtil.nextInt();
		back:
		switch(input){
			case 9: start(); break;
			default: break back;
		}
	}
	
}
