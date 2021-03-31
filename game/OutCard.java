package study.game;

public class OutCard extends OutItem{

	OutCard(OutCharacter c){
		super(c.name + "의 명함", 0, 0, 0, 10);
	}
	
	
	
	String itemInfo(OutCharacter c) {

		System.out.println("<" + c.name + "의 명함입니다.>");
		System.out.println("<" + c.name + "이 자신의 이름을 되새깁니다.>" );
		String info = name + " :";
		if (0 < hp)	 info += " 체력" + hp;
		if (0 < att) info += " 공격" + att;
		if (0 < def) info += " 방어" + def;
		if (0 < mental) info += " 정신력" + mental;
		return info;
	}
}
