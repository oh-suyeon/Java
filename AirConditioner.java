package study;

import e_oop.ScanUtil;

public class AirConditioner {
	// 에어컨의 변수 : 전원, 온도(올리기/내리기) 바람세기(1~5), 바람방향(올리기/내리기)  
	
	boolean power;
	int temperature;
	int windSpeed;
	boolean windDirection;
	
	final int temperatureMin = 10;							// 최소, 최대 값 제한
	final int windSpeedMax = 5;
	final int windSpeedMin = 1;
	
	AirConditioner(){										// 기본 값 초기화
		power = false;
		temperature = 18;
		windSpeed = 2;
		windDirection = false; 
	}
	
	void powerOnOff(){										// 전원
		power = !power;
		System.out.println("전원 : " + (power? "켜짐" : "꺼짐"));
	}
	
	void temperatureUp(){									// 온도 올리기
		if(power && temperature > 10)
		temperature++;
		System.out.println("현재 온도 : " + temperature);
	}
	
	void temperatureDown(){									// 온도 내리기
		if(power && temperature > 10)
		temperature--;
		System.out.println("현재 온도 : " + temperature);
	}
	
	void speedChange(int speedLevel){						// 바람세기 입력 (1~5)
		if(power && speedLevel >= windSpeedMin && speedLevel <= windSpeedMax){
			windSpeed = speedLevel;
		}
		showSpeed();
	}
	
	void directionChange(){
		windDirection = !windDirection;
		System.out.println("현재 풍향 : " + (windDirection? "위" : "아래"));	// 풍향 조절
	}
	
	void showSpeed(){
		for(int i = windSpeedMin; i <= windSpeedMax; i++){				// 바람세기 표시
			if(i <= windSpeed){
				System.out.print("●");
			}else{
				System.out.print("○");
			}
		}System.out.println();
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		
		AirConditioner ac = new AirConditioner();

		do {
			System.out.println("---------에어컨리모컨---------");
			System.out.println("1. 전원\t\t 2. 온도 조절");
			System.out.println("3. 바람 세기\t 4. 바람 방향 ");
			System.out.println("--------------------------");

			int control = ScanUtil.nextInt();

			if (control == 1) {
				ac.powerOnOff();
			}

			if (control == 2) {
				System.out.println("----------온도 조절----------");
				System.out.println("현재 온도 : " + ac.temperature);
				System.out.println("1. 올리기\t 2. 내리기\t");
				System.out.println("--------------------------");
				int control2 = ScanUtil.nextInt();
				if (control2 == 1) {
					ac.temperatureUp();
				}
				if (control2 == 2) {
					ac.temperatureDown();
				}
			}

			if (control == 3) {
				System.out.println("---------바람세기 조절---------");
				System.out.println("현재 바람 세기 : " + ac.windSpeed);
				System.out.println("바람 세기를 입력해주세요.");
				System.out.println("1(아주 약함) ~ 5(아주 강함)");
				System.out.println("--------------------------");
				int control2 = ScanUtil.nextInt();
				ac.speedChange(control2);
			}

			if (control == 4) {
				ac.directionChange();
			}

		} while (true);

	}

}
