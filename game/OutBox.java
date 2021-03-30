package study.game;

public class OutBox {
	
	OutItem[] items;
	
	OutItem ItemDrop(){
		return items[(int)(Math.random() * items.length)];
	}
	
}
