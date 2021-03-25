package study;

public class practice {

	public static void main(String[] args) {
		
		class Solution {
		    public int[] solution(int[] array, int[][] commands) {
		        
		        for(int i = 0; i < commands.length; i++){
		            for(int j = 0; j < commands[i][1] - commands[i][0] + 1; j++){
		                int temp[i] = array[commands[i][0] - 1];        
		            }
		            temp2[i] = temp[commands[i][2]];
		        }        
		        
		        int[] answer = new int[temp2.length];
		        for(int i = 0; i < temp2.length; i++){
		            answer[i] = temp2[i];
		        }
		        
		        return answer;
		    }
		}

	}

}
