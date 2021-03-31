package study.game;

public class OutCard2 extends OutItem{

	OutCard2(){
		super("MIKE의 운전면허증", 0, 0, 0, 0);
	}
	
	String itemInfo(OutCharacter c) {

		System.out.println("<MIKE의 운전면허증입니다.>");
		System.out.println("<" + c.name + "은 유령의 이름을 알아냈습니다.>" );
		String info = name + " :";
		if (0 < hp)	 info += " 체력" + hp;
		if (0 < att) info += " 공격" + att;
		if (0 < def) info += " 방어" + def;
		if (0 < mental) info += " 정신력" + mental;
		return info;
	}
}
