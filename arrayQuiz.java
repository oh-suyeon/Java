package study;

import java.util.Arrays;

public class arrayQuiz {

	public static void main(String[] args) {
		// 과제
		/*
		 * 2~5사이의 랜덤한 수를 만들어주세요.
		 * 그 수로 나누어 떨어지는 숫자로만 이루어진 배열을 정렬하여 출력해주세요.
		 * 
		 */
		System.out.println("배열 랜덤 값으로 초기화");
		
		int[] arr = new int[100];
		for(int i = 0; i < arr.length;i++){
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));
		
		int random = (int)(Math.random() * 4) + 2;
		
		int[] temp = new int[100];
		int count = 0;
		int x = 0;
		for(int j = 0; j < temp.length; j++){
			for(int i = x + 1; i < arr.length; i++){
				if(arr[i] % random == 0){
					x = i;					
					temp[j] = arr[i];
					count++;
					break;
				}
			}
		}
		int[] result = new int[count];
		for(int i = 0; i < result.length; i++){
			result[i] = temp[i];
		}System.out.println(random + "값으로 나뉘어 떨어지는 숫자\n" + Arrays.toString(result));
		
		// 정렬 - 버블
		
		for(int j = 1; j < result.length; j++){
			for(int i = 0; i < result.length - j; i++){
				if (result[i + 1] < result[i]){
					int tp = result[i + 1];
					result[i + 1] = result[i];
					result[i] = tp;		
				}
			}
		}System.out.println(random + "값으로 나뉘어 떨어지는 숫자\n" + Arrays.toString(result));
		
		// 정렬 - 선택
		
//		for(int i = 0; i < result.length - 1; i++){
//			int min = i;
//			for(int j = i + 1; j < result.length; j++){
//				if(result[j] < result[min]){
//					min = j;
//				}
//			}int temp2 = result[i];
//			result[i] = result[min];
//			result[min] = temp2;
//			
//		}System.out.println(random + "값으로 나뉘어 떨어지는 숫자\n" + Arrays.toString(result));
		
		
		// 정렬 - 삽입
		
//		for(int i = 1; i < result.length; i++){
//			int min = result[i];
//			int j = 0; 
//			for(j = i - 1; j >= 0; j--){
//				if(min < result[j]){
//					result[j + 1] = result[j];
//				}else{
//					break;
//				}
//			}result[j + 1] = min;
//		}System.out.println(random + "값으로 나뉘어 떨어지는 숫자 정렬\n" + Arrays.toString(result));
//		
		
		
		// 선생님 답안
		
		int[] tempArr = new int[100];
		int n = (int)(Math.random() * 4) + 2;
		count = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] % n == 0){
				tempArr[count++] = arr[i];
			}
		}
		
		int[] resultArr = new int[count];
		for(int i = 0; i < resultArr.length; i++){
			resultArr[i] = tempArr[i];
		}
		
		for(int i  = 0; i < resultArr.length - 1; i++){
			int min = i;
			for(int j = i + 1; j < resultArr.length; j++){
				if(resultArr[j] < resultArr[min]){
					min = j;
				}
			}
			int tmp = resultArr[i];
			resultArr[i] = resultArr[min];
			resultArr[min] = tmp;
		}
		System.out.println("n : " + n);
		System.out.println(Arrays.toString(resultArr));
		
		
	}

}
