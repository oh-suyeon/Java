package study.game;

import e_oop.ScanUtil;

public class OutGhost extends OutMonster {

	OutGhost(String name, int hp, int att, int def){
		super(name, hp, att, def);
	}
	
	@Override
	void attack(OutCharacter c){
		int damage = att - c.def;
		damage = damage <= 0? 1 : damage;
		c.mental = c.mental < damage ? c.mental - c.mental : c.mental - damage;
		System.out.println("<" + name + "가 " + c.name + "의 정신에 " + damage + "만큼 데미지를 주었습니다. >" );
		System.out.println("<" + c.name + "의 남은 정신력" + c.mental + ">");
	}
	
	void Quiz(OutCharacter c){
		System.out.println("나는 누구지? 여기는 너무 추워.");
		String answer = ScanUtil.nextLine();
		if(answer == "James"){
			System.out.println("밖으로 나가서 내가 여기 있다는 걸 알려줘.");
			System.out.println("자물쇠를 열 수 있게 도와줄게.");
			System.out.println("자물쇠를 잘 봐.");
		}else{
			this.attack(c);
		}
	}
	
	void Help(){
		System.out.println("자리에 맞는 숫자를 맞추면 '달칵' 소리가 나.");
		System.out.println("자리에 맞지는 않지만 세 숫자 중 하나라면 '끽' 소리가 나.");
		System.out.println("'끽' 소리가 많이 나면 그 사람들이 내려올 거야.");
	}
	
}
