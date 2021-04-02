package study.game;

public class OutMonster {
	
	String name;
	int hp;
	int att;
	int def;
	OutItem[] items;
	
	OutMonster(String name, int hp, int att, int def, OutItem[] items){
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.items = items;
	}
	
	void monsterInfo(OutCharacter c){
		System.out.println("-");
	}
	
	void attack(OutCharacter c){
		int damage = att - c.def;
		damage = damage <= 0? 1 : damage;
		c.hp = c.hp < damage ? c.hp - c.hp : c.hp - damage;
		System.out.println(name + "이 공격으로" + c.name + "에게" + damage + "만큼 데미지를 주었습니다." );
		System.out.println(c.name + "의 남은 HP" + c.hp);
	}
	
//	OutItem dropItem(){
//		System.out.println("<" + items[(int)(Math.random() * items.length)].name + "을 획득했습니다.>");
//		System.out.println("<소지품을 확인해보세요.>");
//		return items[(int)(Math.random() * items.length)];
//	}
	
	void dropItem2(OutCharacter c){
		System.out.println("<" + items[(int)(Math.random() * items.length)].name + "을 획득했습니다.>");
		System.out.println("<소지품을 확인해보세요.>");
		c.items[0] = items[(int)(Math.random() * items.length)];
	}
	
}
