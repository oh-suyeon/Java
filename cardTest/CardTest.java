package study.cardTest;

class Card{
	String name;
	int number;
	static int width = 100;
	static int heigh = 250;
}

public class CardTest {	
	
	public static void main(String[] args) {
		
		Card cd1 = new Card();
		
		cd1.width = 70;
		cd1.heigh = 100;
		
		cd1.name = "Daniel";
		cd1.number = 19961210;
		
		Card cd2 = new Card();
		
		cd2.name = "Nayeon";
		cd2.number = 19950922;
		
		System.out.println("1번 카드의 이름은" + cd1.name + ", 직원번호 " + cd1.number + ", 폭은 " + cd1.width + ", 높이는 " + cd1.heigh + "이다.");
		System.out.println("2번 카드의 이름은" + cd2.name + ", 직원번호 " + cd2.number + ", 폭은 " + cd2.width + ", 높이는 " + cd2.heigh + "이다.");
		
				
		
	}

}
