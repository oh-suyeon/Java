package study.game;

import e_oop.ScanUtil;

public class Ghost extends OutMonster {
	
	Ghost(String name, int hp, int att, int def, OutItem[] items) {
		super(name, def, def, def, items);
	}
	
	@Override
	void monsterInfo(OutCharacter c){
		System.out.println("--------------------------------");
		System.out.println("    MMMMMMMMMMMMMMMMMMMMMMMM");
		System.out.println("   MMMMMMM ◎  MMMMMMM ◎  MMMMMM");
		System.out.println("   MMMMMMMMMMMMMMMMMMMMMMMMMM");
		System.out.println("--------------------------------");
		System.out.println("- 추워..");
		System.out.println("- 나는 누구지..");
		System.out.println("<유령이 자신의 이름을 알고 싶어합니다.>");
	}
	
	@Override
	void attack(OutCharacter c){
		int damage = att - c.def;
		damage = damage <= 0? 1 : damage;
		c.mental = c.mental < damage ? c.mental - c.mental : c.mental - damage;
		System.out.println("<화가 난 유령이 " + c.name + "의 정신에 " + damage + "만큼 데미지를 주었습니다.>" );
		System.out.println("<" + c.name + "의 남은 정신력 " + c.mental + "/" + c.maxMental + ">");
		if(c.mental <= 0){
			System.out.println("<Game Over>");
			System.exit(0);
		}
	}
	
	void interact(OutCharacter c){
		System.out.println("<유령의 이름을 알려주세요.>");
		String answer = ScanUtil.nextLine();
		
		quiz : 
		switch(answer){
			
		case "Mike" : System.out.println("- 맞아..");			
					  System.out.println("<유령이 무언가를 건네줍니다.>");
					  dropItem2(c);
					  break quiz;
		default : System.out.println("- 아냐..");
				  this.attack(c);
				  c.characterInfo(c);
				  break quiz;
		}
	}
	
	@Override
	void dropItem2(OutCharacter c){
		System.out.println("<" + items[(int)(Math.random() * items.length)].name + "을 획득했습니다.>");
		ItemInfo();
		c.items[1] = items[(int)(Math.random() * items.length)];
	}
	
	void ItemInfo(){
		System.out.println("- 비밀번호를 잊어버렸을 때 주의점");
		System.out.println("- 자리에 맞는 숫자를 넣으면 번호판이 움푹 들어감 (■)");
		System.out.println("- 자리에 맞지는 않지만 세 숫자 중 하나라면 번호판은 반 쯤 들어감 (▣)");
		System.out.println("- 어디에도 맞지 않는 숫자라면 번호판은 그대로임 (□)");
		System.out.println("- 10번 이상 틀리면 경보음이 울림");
	}
	
	
}
