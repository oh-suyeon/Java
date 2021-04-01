package study.game;

public class OutItem {
	String name;
	int hp;
	int att;
	int def;
	int mental;
	
	OutItem(String name, int hp, int att, int def, int mental){
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.mental = mental;
	}
	
	String itemInfo(OutCharacter c) {
		String info = name + " :";
		if (0 < hp)	 info += " 체력" + hp;
		if (0 < att) info += " 공격" + att;
		if (0 < def) info += " 방어" + def;
		if (0 < mental) info += " 정신력" + mental;
		return info;
	}

}