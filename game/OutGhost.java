package study.game;

import e_oop.ScanUtil;

public class OutGhost extends OutMonster {

	OutGhost(String name, int hp, int att, int def){
		super(name, hp, att, def, null);
	}
	
	@Override
	void attack(OutCharacter c){
		int damage = att - c.def;
		damage = damage <= 0? 1 : damage;
		c.mental = c.mental < damage ? c.mental - c.mental : c.mental - damage;
		System.out.println("<유령이 " + c.name + "의 정신에 " + damage + "만큼 데미지를 주었습니다.>" );
		System.out.println("<" + c.name + "의 남은 정신력 " + c.mental + "/" + c.maxMental + ">");
	}
	
	void Quiz(OutCharacter c){
		System.out.println("- 워추 무너 는기여. 지구누 는나?");
		System.out.println("<유령이 알고 싶어하는 것을 찾아주세요.>");
		String answer = ScanUtil.nextLine();
		
		// 스위치 문으로 바꿔서 반복문으로 바꾸고, 빠져나갈 수 있게 하기.
		if(answer.equals("MIKE")){
			System.out.println("- ... 아맞.");
			System.out.println("- 줘려알 걸 는다있 기여 가내 면가나 로으밖");
			System.out.println("- 게줄와도 게있 수 열 을문");
		}else{
			System.out.println("- ... 야니아.");
			this.attack(c);
			c.showInfo();
		}
	}
	
	void Help(){
		System.out.println("- 자리에 맞는 숫자를 넣으면 번호판이 움푹 들어가 (■)");
		System.out.println("- 자리에 맞지는 않지만 세 숫자 중 하나라면 번호판은 반 쯤 들어가 (▣)");
		System.out.println("- 어디에도 맞지 않는 숫자라면 번호판은 그대로야 (□)");
		System.out.println("- 10번 이상 틀리면 경보음이 울려......");
	}
	
}
