package study.game;

public class Character {

	Item[] items;
	int maxHp;
	int hp;
	int def;
	int att;
	int time;
	
	Character(int name, int maxHp, int hp, int def, int att){
		this.items = new Item[10];
		this.maxHp = hp;
		this.hp = this.maxHp;
		this.def = def;
		this.att = att;
		this.time = 10;
	}
	
	void showTimer(){
		//한번 움직일때마다 시간이 줄어든다.
	}

	void att(){
		// 아이템을 사용해 공격할 수 있다. 무찌르지는 못하고 도망가서 숨을 기회가 생길 수도 있다. 
	}
	
	void hide(){
		// 도망가서 숨기
	}
	
	void open(){
		// 아이템을 사용해 닫혀 있는 문 따위를 열 수 있다. 
	}
	
	void find(){
		// 아이템(이 있는 퍼즐)을 탐색할 수 있다. 아이템을 얻으려면 퍼즐을 풀어야 한다. 
	}
	
}
