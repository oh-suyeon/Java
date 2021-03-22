package study;

import java.util.Arrays;

public class MutiDimensionalArray {

	public static void main(String[] args) {

//		int[][] scores = new int[3][5];		// 3명, 5과목
//		int[] sum = new int[scores.length];
//		double[] avg = new double[scores.length];
//		for(int i = 0; i < scores.length; i++){
//			for(int j = 0;j < scores[i].length; j++){
//				scores[i][j] = (int)(Math.random() * 100);
//			}
//			System.out.println(Arrays.toString(scores[i]));
//		}
		
		int[][] scores = new int[3][5];
		int[] sum = new int[scores.length];
		double[] avg = new double[scores.length];
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < scores[i].length; j++){
				scores[i][j] = (int)(Math.random() * 100);
			}
			System.out.println(Arrays.toString(scores[i])); // 2차원 배열을 출력하기. 출력 역시 반복문 안에 포함되어야 한다. 
			for(int j = 0; j < scores[i].length; j++){
				sum[i] += scores[i][j];
			}avg[i] = (Math.round((double)sum[i] / scores[i].length * 100.0) / 100.0);
			 System.out.println("합계 : " + sum[i] + " 평균 : " + avg[i]);
		}
		

		
		
		
	}

}
