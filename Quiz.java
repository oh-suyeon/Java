package study;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args) {
		// 거스름돈 동전 개수
				/*
				 * 거스름돈에 동전 단위마다 몇 개의 동전이 필요한지 출력해주세요.
				 * 거스름돈 : 2860원
				 * 500원 : 5개
				 * 100원 : 3개
				 * 50원 : 1개
				 * 10원 : 1개
				 */
		
		System.out.println("**거스름돈 동전 개수**");
		
		int money = (int)(Math.random()* 500) * 10;
		System.out.println("거스름돈 : " + money);
		
		int[] coin = {500, 100, 50, 10};
		int cn = 0;
		
		for(int i = 0; i < coin.length; i++){
			cn = money / coin[i];
			money %= coin[i];
			System.out.println(coin[i] + "원 : " + cn + "개" );
		}
		
		
		// 그래프 그리기 
				// 1~5사이의 숫자가 발생된 만큼 *을 사용해 그래프를 그려주세요.
		
		System.out.println("\n**그래프 그리기**");
		
		int[] array  = new int[20];
		for(int i = 0; i < array.length; i++){
			array[i] = (int)(Math.random() * 5) + 1; 
		}
		System.out.println(Arrays.toString(array));
		
		for(int j = 1; j < 6; j++){
			System.out.print(j + " : ");
			for(int i = 0; i < array.length; i++){
				if(j == array[i]){
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
		// 중복되지 않는 배열 
				// 1~5사이의 랜덤한 값이 10개 저장된 배열에서 중복된 값이 제거된 배열을 만들어주세요.
		
		System.out.println("\n**중복되지 않는 배열**");
		
		int[] ar = new int[10];
		
		for(int i = 0; i < ar.length; i++){
			ar[i] = (int)(Math.random() * 5) + 1;
		}
		System.out.println(Arrays.toString(ar));
		
//		int[] temp = new int[10]; 
//		int c = 0;
//		
//		for(int j = 0; j < ar.length; j++){
//			boolean flag = true;
//			for(int i = 0; i < temp.length; i++){		
//				if(ar[j] == temp[i]){
//					flag = false;
//				}
//			}
//			if(flag){
//				temp[c++] = ar[j];
//			}
//		}
//		int[] result = new int[c];
//		for(int i = 0; i < result.length; i++){
//			result[i] = temp[i];
//		}	
//		System.out.println(Arrays.toString(result));
		
//		int[] temp = new int[10];		
//
//		int c = 0;
//		
//		for(int i = 0; i < ar.length; i++){
//			boolean flag = true;		
//			for(int j = 0; j < temp.length; j++){
//				if(ar[i] == temp[j]){ 					// arr에 있는 값이랑, temp에 옮겨놓은 값이랑 비교해야 함. 	
//					flag = false;
//				}
//			}
//			if(flag){
//				temp[c] = ar[i];	
//				c++;							// temp[] 인덱스 번호가 c++라는 게 헷갈렸다. c값을 실행하고 나서 1을 더한다. 쉽게는 이런 식으로 갈 수 있겠다.  
//			}	
//		}
//		int[] result = new int[c];
//		for(int i = 0; i < result.length; i++){
//			result[i] = temp[i];			
//		}
//		System.out.println(Arrays.toString(result));
		
		int[] temp = new int[10];
		int c = 0;
		
		for(int i = 0; i < ar.length; i++){
			boolean flag = true;
			for(int j = 0; j < temp.length; j++){
				if(ar[i] == temp[j]){
					flag = false;
				}
			}
			if(flag){
				temp[c] = ar[i];
				c++;
			}
		}
		int[] result = new int[c];
		for(int i = 0; i < result.length; i++){
			result[i] = temp[i];
		}System.out.println(Arrays.toString(result));
		
		

			
	
		

		
		
		
	}

}
