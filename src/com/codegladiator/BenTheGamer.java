package com.techgig.codegladiator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class BenTheGamer {
	//static Set<Integer> costs= new TreeSet<Integer>();
	static int finalCost = 401;
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
		    levels.add(l);
		}
		sc.close();
		
        permute(levels, 0, levels.size()-1);
       
		//System.out.println(Integer.valueOf(costs.toArray()[0].toString()));
        System.out.println(finalCost);
	}
	static class Level{
		
		private String[] values;
		private List<Integer> weaponsIndexes;
		
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
	
	
	public static void permute(List<Level> levels,int l,int r){
	   
		if(l==r){
	
			  int cost = 0; 
	        int count =0;
	        List<Integer> allWeaponsIndexes = new ArrayList<>();
						
			for(Level level : levels) {
				List<Integer> indexes = level.weaponsIndexes;
				
				count = 0;
				
				for(int i : indexes) {
				    if (allWeaponsIndexes.contains(i)) {
							continue;
						}
					
				else {
						allWeaponsIndexes.add(i);
						count++;
					}
				}
				
				cost = cost + (count*count);
	if (cost> finalCost) {
		break;
	}
						
		}
			//System.out.println(levels+" Cost:"+cost+ " All Weapons Index: "+allWeaponsIndexes);
			//costs.add(cost);
			if(cost<finalCost) {
				finalCost = cost;
			}
		}
		else{
			for (int i = l; i <= r; i++)
            {
                levels = swap(levels,l,i);
                permute(levels, l+1, r);
                levels = swap(levels,l,i);
            }
		}
		
		
		
	}
	
	public static List<Level> swap(List<Level> levels,int i,int j){
		Level temp;
		Level temp2;
		temp = levels.get(i);
		temp2= levels.get(j);
		levels.set(i,temp2);
		levels.set(j, temp);
		
		return levels;
	}
	
}
