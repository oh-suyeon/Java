package study;

import java.util.Arrays;

public class sort {

	public static void main(String[] args) {
		//배열 요소의 자리 바꾸기
		
		System.out.println("예제1=====================");
		
		String[] names = new String[]{"김씨", "이씨", "박씨", "한씨"};
		System.out.println(Arrays.toString(names) + " 변경 전");
		
		String temp = names[1];
		names[1] = names[2];
		names[2] = temp;

		System.out.println(Arrays.toString(names) + " 변경 후");
		
		// 5개의 숫자 5, 2, 3, 1, 4를 버블정렬, 오름차순정렬
		// 각 정렬이 끝날 때마다 출력
		
		System.out.println("\n예제2=====================");
		
		int[] bubble = new int[] { 5, 2, 3, 1, 4 };

		for (int i = 0; i < bubble.length - 1; i++) {
			boolean flag = true;
			for (int j = 0; j < bubble.length - 1 - i; j++) {
				if (bubble[j] > bubble[j + 1]) {
					int temps = bubble[j + 1];
					bubble[j + 1] = bubble[j];
					bubble[j] = temps;
					flag = false;
				}

			}
			if (flag) {
				break;
			}

		}
		System.out.println(Arrays.toString(bubble));
			
		int[] arr = new int[]{5, 2, 3, 1, 4};
		
		for(int i = 0; i < arr.length - 1; i++){			// i는 범위를 줄이기 위해서만 쓰인다.
			boolean flag = true;
			for(int j = 0; j < arr.length - 1 - i; j++){  	// 비교되는 두 값이 모두 j다. i는 한 바퀴 돌때는 변하지 않는 값. 한바퀴 돌때마다 1씩 늘어나는 i값을 빼줘서 범위를 조정해준다.
				if(arr[j] > arr[j + 1]){
					int temps = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temps;
					flag = false;							// 검사하는 변수는 보통 불린타입
				}
			}
			if(flag){
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
		
		
		// 5개의 숫자 5, 2, 3, 1, 4를 선택정렬, 오름차순정렬
		
		System.out.println("\n예제3=====================");
		
		int[] select = new int[]{5, 2, 3, 1, 4};
		
		for(int i = 0; i < select.length - 1; i++){
			int min = i;
			for(int j = i + 1; j < select.length; j++){
				if(select[j] < select[min]){
					min = j;
				}
			}
			int temps = select[i];
			select[i] = select[min];
			select[min] = temps;
		}
		System.out.println(Arrays.toString(select));
		
				
		
		//  5개의 숫자 5, 2, 3, 1, 4를 삽입정렬, 오름차순정렬
		
		System.out.println("\n예제4=====================");
		
		int[] insert = new int[]{5, 2, 3, 1, 4};
	
		for(int i = 1; i < insert.length; i++){		
			int temps = insert[i];
			int j = 0;
			for(j = i - 1; j >= 0; j--){
				if(temps < insert[j]){
					insert[j + 1] = insert[j];
				}else{
					break;
				}
			}insert[j + 1] = temps;
		}System.out.println(Arrays.toString(insert));
		
		
		
		
		
		
	}

}
