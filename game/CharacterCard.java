package study.game;

public class CharacterCard extends OutItem{

	CharacterCard(OutCharacter c){
		super(c.name + "의 명함", 0, 0, 0, 2);
	}
	
	@Override
	String itemInfo(OutCharacter c) {
		System.out.println("<" + c.name + "의 명함입니다.>");
		System.out.println("<" + c.name + "이 정신을 가다듬습니다.>");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("|                  |");
		System.out.println("|    DAILY NEWS    |");
		System.out.println("\t" + c.name);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		String info = "<" + name + " :";
		if (0 < hp)	 info += " 체력 +" + hp + ">";
		if (0 < att) info += " 공격 +" + att + ">";
		if (0 < def) info += " 방어 +" + def + ">";
		if (0 < mental) info += " 정신력 +" + mental + ">";
		return info;
	}
	
//	public static void main(String[] args) {
//		OutCharacter c = new OutCharacter("Jane", 10, 10, 10, 10);
//		CharacterCard cc = new CharacterCard(c);
//		String info = cc.itemInfo(c);
//		System.out.println(info);
//	}
	
}
