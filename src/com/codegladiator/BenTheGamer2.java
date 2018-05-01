package com.codegladiator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BenTheGamer2 {
static List<Level> globalLevels = new ArrayList<Level>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		
		List<Level> levels = new ArrayList<Level>();
		for(int i = 0;i < N;i ++) {
			String str = sc.nextLine();
			String[] strArr = str.split("");
			
			Level l= new Level();
		    List<Integer> weaponsIndexes = new ArrayList<>();
 		    for(int j=0;j<M;j++) {
			
				if (strArr[j].equals("1")) {
				    weaponsIndexes.add(j);
				}
			
			}
		    
		    l.values = strArr;
		    l.weaponsIndexes = weaponsIndexes;
		    l.totalWeapons = weaponsIndexes.size();
		    levels.add(l);
		    globalLevels.add(l);
		}
		sc.close();
		
		Comparator<Level> c = new Comparator<Level>() {

			@Override
			public int compare(Level l1, Level l2) {
				if(l1.totalWeapons > l2.totalWeapons)
				return 1;
				else if (l1.totalWeapons < l2.totalWeapons)
					return -1;
				else {
					List<Level> sameLevel = new ArrayList<Level>();
					
					//System.out.println("Levels: "+ l1 + " and "+ l2);
					for (Level l:globalLevels) {
						if(l.totalWeapons == l1.totalWeapons) {
							sameLevel.add(l);
						}
					}
					int countl1=0;
					List<Integer> weaponsL1 = l1.weaponsIndexes;
					int countl2 = 0;
					List<Integer> weaponsL2 = l2.weaponsIndexes;
					for (Level l3 : sameLevel) {
						List<Integer> weaponsL3 = l3.weaponsIndexes;
						
						for (int i : weaponsL1) {
							if(weaponsL3.contains(i)) {
								countl1++;
							}
						}
					}
					
					for (Level l3 : sameLevel) {
						List<Integer> weaponsL3 = l3.weaponsIndexes;
						
						for (int i : weaponsL2) {
							if(weaponsL3.contains(i)) {
								countl2++;
							}
						}
					}
					System.out.println("Levels: "+ countl1 + " and "+ countl2);
				/*	List<Level> temp1 = new ArrayList<Level>();
					temp1.add(l1);
					temp1.add(l2);
					int cost1 = calculateCost(temp1);
					List<Level> temp2 = new ArrayList<Level>();
					temp2.add(l2);
					temp2.add(l1);
					int cost2 = calculateCost(temp2);*/
					if(countl1 > countl2) return 1;
					else return -1;
				
				}
				
			}
			
		};

		Collections.sort(levels, c);
		
	System.out.println(levels);
		System.out.println(calculateCost(levels));
	}
	
	
	public static int calculateCost(List<Level> levels) {
		List<Integer> indexes = new ArrayList<Integer>();
		int count;
		int cost = 0;
		for(Level l: levels) {
			count = 0;
			List<Integer> weapons = l.weaponsIndexes;
			for(int i : weapons) {
				if(indexes.contains(i)) {
					continue;
				}
				else {
					indexes.add(i);
					count++;
				}
			}
			cost = cost + count*count;
		}
		return cost;
	}
	static class Level{
		
		private String[] values;
		private List<Integer> weaponsIndexes;
		private int totalWeapons;
		
		public Level() {
			
		}
		
		@Override
		public String toString() {
		
			String appended="";
			for (String a : values) {
				appended = appended + a;
			}
			return "{"+appended +"-"+ weaponsIndexes+"}";
		}
		

}
}
