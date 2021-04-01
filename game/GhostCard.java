package study.game;

public class GhostCard extends OutItem{

	GhostCard(Ghost g){		
		super(g.name + "의 운전면허증", 0, 0, 0, 2);
	}
	
	@Override
	String itemInfo(OutCharacter c) {
		System.out.println("<누군가의 운전면허증입니다.>");
		String info = "<" + name + " :";
		if (0 < hp)	 info += " 체력 +" + hp + ">";
		if (0 < att) info += " 공격 +" + att + ">";
		if (0 < def) info += " 방어 +" + def + ">";
		if (0 < mental) info += " 정신력 +" + mental + ">";
		return info;
	}
}