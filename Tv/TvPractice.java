package study.Tv;

import e_oop.ScanUtil;

public class TvPractice {
	
	boolean power;
	int channel;
	int volume;
	
	final int MIN_CHANNEL = 1;
	final int MAX_CHANNEL = 100;
	final int MIN_VOLUME = 0;
	final int MAX_VOLUME = 10;
	
	TvPractice(){
		power = false;
		channel = 1;
		volume = 5;
	}
	
	void power(){
		power = !power;
		String powerCheck = power? "켜짐" : "꺼짐";
		System.out.println(powerCheck);		// 이렇게 고쳐도 될까?
	}
	
	void changeChannel(int channel){
		if(power){
			if(channel <= MAX_CHANNEL && channel >= MIN_CHANNEL){
				this.channel = channel;
			}
			System.out.println("채널" + this.channel);
		}	
	}
	
	void channelUp(){
		this.changeChannel(++channel);; // 이렇게 고쳐도 될까?
	}
	
	void channelDown(){
		this.changeChannel(--channel);
	}
	
	void volumeUp(){
		if(volume < MAX_VOLUME){
			volume++;
		}
		showVolume();
	}	
	
	void volumeDown(){
		if(volume > MIN_VOLUME){
			volume--;
		}
		showVolume();
	}
	
	void showVolume(){
		System.out.print("음량. ");
		for(int i = MIN_VOLUME + 1; i <= MAX_VOLUME; i++){
			if(i <= volume){
				System.out.print("●");
			}else{
				System.out.print("○");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		TvPractice tp = new TvPractice();

		while (true) {
			System.out.println("-------------------------------");
			System.out.println("1.전원  2.채널변경  3.채널업  4.채널다운");
			System.out.println("5.볼륨업  6.볼륨다운  0.종료");
			System.out.println("-------------------------------");
			System.out.print("번호 입력>");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				tp.power();
				break;

			case 2:
				System.out.print("변경할 채널 입력>");
				int ch = ScanUtil.nextInt();
				tp.changeChannel(ch);
				break;

			case 3:
				tp.channelUp();
				break;
			case 4:
				tp.channelDown();
				break;
			case 5:
				tp.volumeUp();
				break;
			case 6:
				tp.volumeDown();
				break;

			default:
				System.out.println("종료되었습니다.");
				System.exit(0);
				break;

			}

		}

	}
}
	
	
	
	