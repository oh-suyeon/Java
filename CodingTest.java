package study;

import java.util.ArrayList;

public class CodingTest {
	
	public static void main(String[] args) {
		
		int[] numbers = {3, 30, 34, 5, 9};
		String answer = "";
        
		ArrayList<String> nums = new ArrayList<>();
		
		for(int i = 0; i < numbers.length; i++){
			nums.add(String.valueOf(numbers[i]));
		}
		System.out.println(nums);
		
		String a = nums.get(0).substring(0, 1);
		String b = nums.get(1).substring(0, 1);
		
		System.out.println(a + b);
		
		int a2 = Integer.parseInt(nums.get(0).substring(0, 1));
		int b2 = Integer.parseInt(nums.get(1).substring(0, 1));
		
		System.out.println(a2 + b2);
		
		if(a2 < b2){
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	 
}
