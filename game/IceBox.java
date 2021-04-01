package study.game;

import e_oop.ScanUtil;

public class IceBox extends OutMonster{
	
	IceBox(String name, int hp, int att, int def, OutItem[] items){
		super(name, def, def, def, items);
	}
	
	void openBox(OutCharacter c){
		System.out.println(c.name + "은 아이스박스를 열었습니다.");
		System.out.println("-" + c.name + " : !!!");
		System.out.println("<꽁꽁 언 시체가 들어있습니다.>");
		this.attack(c);
		System.out.println("--------------------------------");
		System.out.println("DEADBODYDEADBODYDEA(2)@OBDDBODY");
		System.out.println("DEA(1)⊙ODYDEADBODYDEADBODYDBODY");
		System.out.println("DEADODYDEADBODYDEADBODYDEADBODY");
		System.out.println("DEADBODYD(3)=DBODYDBODYDEA(4)□□");
		System.out.println("--------------------------------");
		System.out.println("<상호작용할 대상을 고르세요.>");
		finding : 
		while(true){
			int input2 = ScanUtil.nextInt();
			switch(input2){
			case 1: System.out.println("<눈>"); attack(c); break finding;
			case 2: System.out.println("<귀>"); attack(c); break finding;
			case 3: System.out.println("<손가락>"); attack(c); break finding;
			case 4: dropItem2(c); break finding;
			default : break finding;
			}
		}
	}
	
	@Override
	void dropItem2(OutCharacter c){
		System.out.println("<" + items[(int)(Math.random() * items.length)].name + "을 획득했습니다.>");
		System.out.println("<소지품을 확인해보세요.>");
		c.items[0] = items[(int)(Math.random() * items.length)];
	}
	
	@Override
	void attack(OutCharacter c){
		
		int damage = att - c.def;
		damage = damage <= 0? 1 : damage;
		c.mental = c.mental < damage ? c.mental - c.mental : c.mental - damage;
		c.mental -= damage;
		System.out.println("<" + c.name + "이 충격을 받아 정신력이 " + damage + "만큼 깎였습니다.>");
		System.out.println("<" + c.name + "의 남은 정신력 " + c.mental + "/" + c.maxMental + ">");
	}
	
	
}
