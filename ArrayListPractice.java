package study;

import java.util.ArrayList;

public class ArrayListPractice {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(new Integer(10));
		System.out.println(list);
		list.add(1, 20);
		list.add(2, 30);
		System.out.println(list);
		
		int before = list.set(1, 200);
		System.out.println("before : " + before + " / after : " + list.get(1));
		
		list.set(1, 20);
		for(int i = 0; i < list.size(); i++){
			System.out.println(i + " : " + list.get(i));
		}
		
		ArrayList<Integer> list2 = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			int rn = (int)(Math.random() * 100) + 1;
			list2.add(i, rn);
		}System.out.println(list2);
		
		int min = list2.get(0);
		int max = list2.get(0);
		
		for(int i = 0; i < list2.size(); i++){
			if(min > list2.get(i)){
				min = list2.get(i);
			}
			if(max < list2.get(i)){
				max = list2.get(i);
			}
		}System.out.println("min : " + min + " / max : " + max);	
		
		for(int i = 0; i < list2.size() - 1; i++){
			int m = i;
			for(int j = i + 1; j < list2.size(); j++){
				if(list2.get(m) > list2.get(j)){
					m = j;
				}
			}
			int temp = list2.set(i, list2.get(m));
			list2.set(m, temp);
		}System.out.println(list2);
		
		ArrayList<ArrayList<Integer>> list3 = new ArrayList<>();
		
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(1);
		list4.add(2);
		list4.add(3);
		list3.add(list4);
		
		ArrayList<Integer> list5 = new ArrayList<>();
		list5.add(10);
		list5.add(20);
		list5.add(30);
		list3.add(list5);
		System.out.println(list4);
		System.out.println(list5);
		System.out.println(list3);
		
		for(int i = 0; i < list3.size(); i++){
			for(int j = 0; j < list3.get(i).size(); j++){
				System.out.print(list3.get(i).get(j) + "\t");
			}System.out.println();
		}
		
		
		
	}
	
	
	
	
	
}
