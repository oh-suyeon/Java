package study.game;

public class OutMonster {
	
	String name;
	int hp;
	int att;
	int def;
	OutItem[] items;
	
	OutMonster(String name, int hp, int att, int def){
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
	}
	
	void attack(OutCharacter c){
		int damage = att - c.def;
		damage = damage <= 0? 1 : damage;
		c.hp = c.hp < damage ? c.hp - c.hp : c.hp - damage;
		System.out.println(name + "이 공격으로" + c.name + "에게" + damage + "만큼 데미지를 주었습니다." );
		System.out.println(c.name + "의 남은 HP" + c.hp);
	}
	
	OutItem ItemDrop(){
		return items[(int)(Math.random() * items.length)];
	}
	
}
