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
	
	static int time = 10;
	
	
	OutCharacter(String name, int hp, int mental, int att, int def){
		this.name = name;
		this.maxHp = hp;
		this.hp = this.maxHp;
		this.maxMental = mental;
		this.mental = this.maxMental;
		this.att = att;
		this.def = def;
		this.items = new OutItem[10];
	}
	
	void showInfo(){
		
		if(hp > 80){
			System.out.println("<" + name + "의 몸에 상처는 없습니다.>");
		}else if(hp > 50){
			System.out.println("<" + name + "은 작은 상처를 입었습니다.>");
		}else if(hp > 30){
			System.out.println("<" + name + "의 상처에서 피가 흐르기 시작합니다.>");
		}else{
			System.out.println("<" + name + "은 피를 너무 많이 흘렸습니다.>");
		}
		
		if(mental > 80){
			System.out.println("<" + name + "은 정신이 또렷합니다.>");
		}else if(hp > 50){
			System.out.println("<" + name + "은 공포심에 정신이 혼란해지기 시작합니다.>");
		}else if(hp > 30){
			System.out.println("<" + name + "은 겁에 질렸습니다.>");
		}else{
			System.out.println("<" + name + "은 정신이 혼미합니다.>");
		}
		
		for(int i = 0; i < items.length; i++){
			if(items[i] != null){
				System.out.println("(" + (i + 1) + ")" + items[i].name);
			}
		}
		int input = ScanUtil.nextInt();
		items[input - 1].itemInfo();	// 아이템 선택 - 자세히 보기/사용하기 기능 
		
	}
	
	void attack(OutMonster m){
		int damage = att - m.def;
		damage = damage <= 0? 1 : damage;
		m.hp = m.hp < damage ? m.hp - m.hp : m.hp - damage;
		System.out.println("<" + name + "이 공격으로" + m.name + "에게" + damage + "만큼 데미지를 주었습니다.>" );
		System.out.println("<" + m.name + "의 남은 HP" + m.hp + ">");
	}
	
	void getItem(OutItem item){
		System.out.println("<" + item.name + "을 획득하였습니다.>");
		for(int i = 0; i < items.length; i++){
			if(items[i] == null){
				items[i] = item;
				break;
			}
		}
		hp += item.hp;	// 잃어버린 hp만 회복할 수 있다. 
		att += item.att;
		def += item.def;
	}
	
	void hide(){
		
	}
	
	void open(){
		
	}
	
	void interaction(){
		
	}
}
