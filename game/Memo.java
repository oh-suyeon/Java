package study.game;

public class Memo extends OutItem {

	Memo(String name, int hp, int att, int def, int mental) {
		super(name, hp, att, def, mental);
	}
	
	void ItemInfo(){
		System.out.println("- 비밀번호를 잊어버렸을 때 주의점");
		System.out.println("- 자리에 맞는 숫자를 넣으면 번호판이 움푹 들어감 (■)");
		System.out.println("- 자리에 맞지는 않지만 세 숫자 중 하나라면 번호판은 반 쯤 들어감 (▣)");
		System.out.println("- 어디에도 맞지 않는 숫자라면 번호판은 그대로임 (□)");
		System.out.println("- 10번 이상 틀리면 경보음이 울림");
	}
	
}
