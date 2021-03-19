package study;

import java.util.Arrays;

public class ArrayStudy2 {

	public static void main(String[] args) {
		int[] score = new int[7];
		
		for(int i = 0; i < score.length; i++){
			score[i] = (int)(Math.random() * 100);
		}System.out.println(Arrays.toString(score));
		
		int sum = 0;
		for(int i = 0; i < score.length; i++){
			sum += score[i];
		}
		double avg = Math.round((double)sum / score.length * 100.0) / 100.0;
		System.out.println("합  : " + sum + " 평균 : " + avg);
		
		int min = 0;
		for(int i = 0; i < score.length - 1; i++){
			if(score[min] > score[i + 1]){
				min  = i + 1;
			}
		}System.out.println("최소값 : " + score[min]);
		
		int max = 0;
		for(int i = 0; i < score.length - 1; i++){
			if(score[max] < score[i + 1]){
				max = i + 1;
			}
		}System.out.println("최대값 : " + score[max]);
		
		System.out.println();
		
		int[] students = new int[5];
		int[] rank = new int[5];
		
		for(int i = 0; i < students.length; i++){
			students[i] = (int)(Math.random() * 100);
		}
		
		for(int i = 0; i < rank.length; i++){
			rank[i]++;
		}
		
		for(int j = 0; j < students.length - 1; j++){
		int high = j;
			for(int i = j + 1; i < students.length ; i++){
				if(students[high] < students[i]){
					high = i;
				}
			}int temp = students[j];
			students[j] = students[high];
			students[high] = temp; 	
		}
		
		for(int j = 0; j < students.length; j++){
			for(int i = 0; i < students.length - 1; i++){
				if(students[j] < students[i]){
					rank[j]++;
				}
			}
		}
		System.out.println(Arrays.toString(students));
		System.out.println(Arrays.toString(rank));
		
		for(int i = 0; i < students.length; i++){
			System.out.println("점수 : " + students[i] + " / 석차 : " + rank[i]);
		}
	}
}
