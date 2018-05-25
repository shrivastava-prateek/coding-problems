package com.codegladiator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BenTheGamer2 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.next();

		List<Level> levels = new ArrayList<Level>();
		for(int i = 0;i < N;i ++) {
			String str = sc.nextLine();
			str = str.trim();
			int c=0;
			List<Integer> weaponsIndexes = new ArrayList<>();
			for (char s: str.toCharArray()){
				if(c == M){
					break;
				}
				if (s=='1') {
					weaponsIndexes.add(c);
				}
				c++;
			}

			Level l= new Level();
			l.values = str;
			l.weaponsIndexes = weaponsIndexes;
			l.totalWeapons = weaponsIndexes.size();
			
			levels.add(l);
		
		}
		

		Comparator<Level> c = new Comparator<Level>() {

			@Override
			public int compare(Level l1, Level l2) {
				if(l1.totalWeapons > l2.totalWeapons)
					return 1;
				else if (l1.totalWeapons < l2.totalWeapons)
					return -1;
				else return 0;
				

			}

		};

		Collections.sort(levels, c);

		//System.out.println(levels);

		System.out.println(calculateCost(levels));
		sc.close();
	}

	public static int calculateCost(List<Level> levels) {
		List<Integer> indexes = new ArrayList<Integer>();
		//int count;
		int minCost = 0;
		int cost =0;
		int finalcost = 0;
		int vistedLevels = 1;
		Level temp = null;
		boolean flag = false;
		
		Level first = levels.get(0);
		finalcost = calculateCost(first, indexes);
		addIndexes(first, indexes);
		first.isVisited = true;
		
	 //  System.out.println("Initial Final Cost: "+finalcost + " Indexes: "+indexes);
		
		while(vistedLevels != levels.size()){
			for(int i = 0;i<levels.size();i++){
				//count = 0;
				Level l = levels.get(i);
				if (l.isVisited){
					continue;
				}
				else{
				
				minCost = calculateCost(l, indexes);
				//System.out.println("Minimum cost: "+ minCost+ " Level: "+l);
				if(!flag){
					cost = minCost;
					flag = true;
					temp = l;
				}
				if(minCost <= cost){
					cost = minCost;
					temp = l;
					
				}
			}
			}
			
			//System.out.println("--Minimum cost: "+ cost+ " Level: "+temp);
			temp.isVisited = true;
			finalcost = finalcost + cost;
			vistedLevels++;
			addIndexes(temp, indexes);
			cost =0;
			flag=false;

		}
		return finalcost;
	}

	public static int calculateCost(Level level,List<Integer> indexes){
		int count = 0;
		//int cost = 0;
		List<Integer> weaponsIndex = level.weaponsIndexes;
		for(int j : weaponsIndex) {
			if(indexes.contains(j)) {
				continue;
			}
			else {
				count++;
			}
		}
		//cost = cost + count*count;
		return count*count;
		
	}
	
	public static void addIndexes(Level level,List<Integer> indexes){
		
		List<Integer> weaponsIndex = level.weaponsIndexes;
		for(int j : weaponsIndex) {
			if(indexes.contains(j)) {
				continue;
			}
			else {
				indexes.add(j);
			}
		}
	}



	static class Level{

		private String values;
		private List<Integer> weaponsIndexes;
		private int totalWeapons;
		boolean isVisited;

		public Level() {

		}

		@Override
		public String toString() {
			return "{"+values +"-"+ weaponsIndexes+"}";
		}


	}
}
