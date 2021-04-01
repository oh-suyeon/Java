package study.game;

import e_oop.ScanUtil;


public class OutCharacter {
	
	String name;
	int hp;
	int maxHp;
	int mental;
	int maxMental;
	int att;
	int def;
	OutItem[] items;
	
	OutCharacter(String name, int hp, int mental, int att, int def){
		this.name = name;
		this.maxHp = hp;
		this.hp = this.maxHp;
		this.maxMental = mental;
		this.mental = this.maxMental;
		this.att = att;
		this.def = def;
		this.items = new OutItem[5];
	}
	
	void characterInfo(OutCharacter c){
		System.out.println("======================");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("|                  |");
		System.out.println("|    DAILY NEWS    |");
		System.out.println("\t" + c.name);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		showState(hp, mental);
		
		System.out.println("items");
		for(int i = 0; i < items.length; i++){
			if(items[i] != null){
				System.out.println("(" + (i + 1) + ")" + items[i].name);
			}
		}
		System.out.println("======================");
		System.out.println();
	}
	
	void attack(OutMonster m){
		int damage = att - m.def;
		damage = damage <= 0? 1 : damage;
		m.hp = m.hp < damage ? m.hp - m.hp : m.hp - damage;
		System.out.println("<" + name + "이 공격으로" + m.name + "에게" + damage + "만큼 데미지를 주었습니다.>" );
		System.out.println("<" + m.name + "의 남은 HP" + m.hp + ">");
	}
	
	void getItem(OutItem item){
		System.out.println("<" + item.name + ">");
		for(int i = 0; i < items.length; i++){
			if(items[i] == null){
				items[i] = item;
				break;
			}
		}
		hp += item.hp;	
		att += item.att;
		def += item.def;
	}
	
	void showState(int hp, int mental){
		System.out.println("hp");
		for(int i = 0; i < maxHp; i++){
			if(hp > i){ 
				System.out.print("■");
			} else {
				System.out.print("□");
			}
		}
		System.out.println();
		System.out.println("mental");
		for(int i = 0; i < maxMental; i++){
			if(mental > i){ 
				System.out.print("■");
			} else {
				System.out.print("□");
			}
		}
		System.out.println();
	}	
}	
