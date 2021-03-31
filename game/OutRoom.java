package study.game;

public class OutRoom {
	
	boolean iceBox;
	boolean ghost;
	boolean door;
	
	
	OutRoom(){
		iceBox = false;
		ghost = false;
		door = false;
	}
	
	void showRoom(){
		System.out.println("<어딘지 알 수 없는 지하실입니다.>");
		System.out.println("<웅웅 거리는 아이스 박스와 자물쇠로 잠긴 문 사이로 흐릿한 인영이 보입니다.>");
		System.out.println("--------------------------------");
		System.out.println("                (2)    (3)|   |");
		System.out.println("_(1)_____          ⊙⊙              |●  |");
		System.out.println("|_|___|_|          MM     |   |");
		System.out.println("|       |         MMMM    |   |");
		System.out.println("--------------------------------");
		System.out.println("<상호작용할 대상을 고르세요.>");
		System.out.println("<소지품을 보려면 (0)키를 누르세요.>");
	}

	void interactGhost(){
		System.out.println("--------------------------------");
		System.out.println("    MMMMMMMMMMMMMMMMMMMMMMMM");
		System.out.println("   MMMMMMM ◎  MMMMMMM ◎  MMMMMM");
		System.out.println("   MMMMMMMMMMMMMMMMMMMMMMMMMM");
		System.out.println("    MMMMMMMMMMMMMMMMMMMMMMMM");
		System.out.println("--------------------------------");
	}
	
	void openDoor(){
		System.out.println("--------------------------------");
		System.out.println("        |                    |");
		System.out.println("        |  (●)               |");
		System.out.println("        | [□□□]              |");
		System.out.println("        |                    |");
		System.out.println("--------------------------------");
	}
	
}
