package study;

import java.util.Arrays;

public class ScorePractice {

	public static void main(String[] args) {
		String[] names = {"강유진", "강지수", "곽재우", "구본성", "권수연", "김보영", "김소희", "김지수",
				"백지혜", "송유경", "신희철", "심선주", "오수연", "윤희중", "이경준", "이석호", "이승구",
				"이여강", "이영민", "이영우", "이용석", "이정범", "최기문", "최소은", "최윤지"};
		String[] subjects = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};
		int[][] scores = new int[names.length][subjects.length];
		
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < subjects.length; j++){
				scores[i][j] = (int)(Math.random() * 101);
			}
		}
		
		int sumName[] = new int[scores.length];
		double avgName[] = new double[scores.length];
		for(int i = 0; i < scores.length; i++){
			for(int j = 0; j < subjects.length; j++){
				sumName[i] += scores[i][j];
			}
			avgName[i] = Math.round((double)sumName[i] / (double)subjects.length * 100.0) / 100.0;
		}
		
		
		int[] rank = new int[scores.length];
		for(int i = 0; i < scores.length; i++){
			rank[i] = 1;
			for(int j = 0; j < scores.length; j++){
				if(avgName[i] < avgName[j]){
					rank[i]++;
				}	 
			}
		}
		
		int[] sumSub = new int[subjects.length];
		double[] avgSub = new double[subjects.length];
		for(int i = 0; i < subjects.length; i++){
			for(int j = 0; j < scores.length; j++){
				sumSub[i] += scores[j][i];
			}
			avgSub[i] = Math.round((double)sumSub[i] / (double)scores.length * 100.0) / 100.0;
		}
		
		for(int i = 0; i < subjects.length; i++){
			System.out.print("\t" + subjects[i]);
		}System.out.print("\t합계" + "\t평균" + "\t석차");
		
		for(int i = 0; i < scores.length; i++){
			System.out.print("\n" + names[i]);
			for(int j = 0; j < subjects.length; j++){
				System.out.print("\t" + scores[i][j]);
			}System.out.print("\t" + sumName[i] + "\t" + avgName[i] + "\t" + rank[i]);
		}
		
		System.out.print("\n과목 합계");
		for(int i = 0; i < subjects.length; i++){
			System.out.print("\t" + sumSub[i]);
		}
		
		System.out.print("\n과목 평균");
		for(int i = 0; i < subjects.length; i++){
			System.out.print("\t" + avgSub[i]);
		}
	}
}
