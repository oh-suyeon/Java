package study.game;

import e_oop.ScanUtil;

public class OutBox {
	
	OutCard2 card2 = new OutCard2();
	int count;
	
	OutBox(){
		int count = 0;
	}
	
	void openBox(OutCharacter c){
		System.out.println(c.name + "은 아이스박스를 열었습니다.");
		System.out.println("-" + c.name + " : !!!");
		System.out.println("<꽁꽁 언 시체가 들어있습니다.>");
		System.out.println("--------------------------------");
		System.out.println("DEADBODYDEADBODYDEA(2)@OBDDBODY");
		System.out.println("DEA(1)⊙ODYDEADBODYDEADBODYDBODY");
		System.out.println("DEADODYDEADBODYDEADBODYDEADBODY");
		System.out.println("DEADBODYD(3)=DBODYDBODYDEA(4)□□");
		System.out.println("--------------------------------");
		this.attack(c);
		count++;
		System.out.println("<상호작용할 대상을 고르세요.>");
		finding : 
		while(true){
			int input2 = ScanUtil.nextInt();
			switch(input2){
			case 1: System.out.println("<눈>"); attack(c); break;
			case 2: System.out.println("<귀>"); attack(c); break;
			case 3: System.out.println("<손가락>"); attack(c); break;
			case 4: ItemDrop(c); break;
			default : break finding;
			}
		}
		
	}
	
	void ItemDrop(OutCharacter c){
		c.items[0] = card2;
		System.out.println("<시체의 신분증을 획득했습니다.>");
		System.out.println("<소지품을 확인해보세요.>");
	}
	
	
	void attack(OutCharacter c){
		
		int damage;
		
		switch(count){
		case 1: damage = 20;
				break;
		case 2: damage = 10;
				break;
		default: damage = 5;
				break;
		}
		c.mental -= damage;
		System.out.println("<" + c.name + "이 충격을 받아 정신력이 " + damage + "만큼 깎였습니다.>");
		System.out.println("<" + c.name + "의 남은 정신력 " + c.mental + "/" + c.maxMental + ">");
	}
	
	
}
