package study.game;


public class OutGame {

	OutCharacter c;
	OutItem[] items;
	
	OutRoom r1 = new OutRoom();
	
	OutGame(){
		c = new OutCharacter("Jane", 100, 100, 50, 50);
	}
	
	public static void main(String[] args) {
		new OutGame().Start();
	}
	
	private void Start(){
		
		c.showInfo();
		System.out.println();
		r1.showRoom();
			
			
		
	}
		
	
	
}
