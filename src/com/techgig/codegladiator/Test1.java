package com.techgig.codegladiator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test1 {

	static class Salmon{
		int headT;
		int tailT;

		public Salmon(int headT, int tailT) {
			super();
			this.headT = headT;
			this.tailT = tailT;
		}
		
		public boolean isOverlap(Salmon salmon){
			if(this.headT >= salmon.headT && this.headT <= salmon.tailT) return true;
			//if(this.tailT == salmon.tailT) return true;
			return false;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + headT;
			result = prime * result + tailT;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Salmon other = (Salmon) obj;
			if (headT != other.headT)
				return false;
			if (tailT != other.tailT)
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "Salmon [headT=" + headT + ", tailT=" + tailT + "]";
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(reader.readLine());
	        String[] strLength = reader.readLine().split(" ");
        	String[] strTime = reader.readLine().split(" ");
        	
        	List<Salmon> salmonList = new ArrayList<Salmon>();
        	
	        for(int i=0;i<N;i++) {
	        	int headT = Integer.parseInt(strTime[i]);
	        	int length = Integer.parseInt(strLength[i]);
	        	int tailT = headT + length-1;
	        	Salmon s = new Salmon(headT,tailT);
	        	salmonList.add(s);
	        } 
	       
	        Comparator<Salmon> c = new Comparator<Salmon>() {

				@Override
				public int compare(Salmon s1, Salmon s2) {
				    if(s1.headT < s2.headT)
					return -1;
				    else if (s1.headT > s2.headT) return 1;
				    else return 0;
				}
	        	
	        };
	        Collections.sort(salmonList,c);
	        System.out.println(salmonList);
	        
	       // Map<Salmon,List<Salmon>> map = checkOverlapping(salmonList);
	        
	    /*    
	        int count1 = calculateMaxSalmons(map);
	        if (count1 == salmonList.size()) {
	        	System.out.println(count1);
	        }
	        else {
	        int count2 = calculateMaxSalmons(map);
	        System.out.println(count1+count2);
	        }*/
	        
	        if (salmonList.size()>1) {
	        	System.out.println(calculateMaxSalmons(checkOverlapping(salmonList)));	
	        }
	        else System.out.println(1);
	        
	}
	

	
	public static List<List<Salmon>> checkOverlapping(List<Salmon> salmonList){
	    List<List<Salmon>> salmonIntervals = new ArrayList<List<Salmon>>();
		for(int i = 0 ; i < salmonList.size(); i++){
			List<Salmon> soln = new ArrayList<Salmon>();
			soln.add(salmonList.get(i));
			for(int j = 0; j < salmonList.size(); j++){
				if(salmonList.get(i).isOverlap(salmonList.get(j)) && !(salmonList.get(i).equals(salmonList.get(j)))){
					//System.out.println(salmonList.get(i) + " overlaps " + salmonList.get(j));
					soln.add(salmonList.get(j));
				}
			}
			salmonIntervals.add(soln);
		}
		//System.out.println(mapSalmonIntervals);
		return salmonIntervals;
	}
	

	public static int calculateMaxSalmons( List<List<Salmon>> solnList) {
		int count=0,max= 0;
		
		for(int i = 0;i<solnList.size();i++) {
			List<Salmon> soln1 = solnList.get(i);
			for (int j = i+1;j<solnList.size();j++) {
				List<Salmon> soln2 = new ArrayList<>(solnList.get(j));
			    soln2.removeAll(soln1);
				count = soln1.size()+soln2.size();
				if(count> max) max = count;
			}
		}
	
		
		return max;
	}
	
	
	/*	public static Map<Salmon,List<Salmon>> checkOverlapping(List<Salmon> salmonList){
	Map<Salmon, List<Salmon>> mapSalmonIntervals = new HashMap<Salmon, List<Salmon>>();
	for(int i = 0 ; i < salmonList.size()-1; i++){
		mapSalmonIntervals.put(salmonList.get(i), new ArrayList<Salmon>());
		for(int j = 0; j < salmonList.size(); j++){
			if(salmonList.get(i).isOverlap(salmonList.get(j)) && !(salmonList.get(i).equals(salmonList.get(j)))){
				//System.out.println(salmonList.get(i) + " overlaps " + salmonList.get(j));
				mapSalmonIntervals.get(salmonList.get(i)).add(salmonList.get(j));
			}
		}
	}
	//System.out.println(mapSalmonIntervals);
	return mapSalmonIntervals;
}*/
	/*public static int calculateMaxSalmons( Map<Salmon,List<Salmon>> map) {
	int count=0,max= 0;List<Salmon> usedSalomns = null; Salmon extra = null;
	for(Salmon s : map.keySet()) {
		count = map.get(s).size();
		
		if (max < count) {
			max = count;
			usedSalomns = map.get(s);
			extra = s;
		}
	}
	if (usedSalomns!=null) {
		usedSalomns.add(extra);
		List<Salmon> salmonsUsed = new ArrayList<>(usedSalomns);
		for(Salmon s : map.keySet()) {
			List<Salmon> salmons = map.get(s);
			List<Salmon> duplicate = new ArrayList<>(salmons);
			for (Salmon used : salmonsUsed) {
				for (Salmon sal: duplicate) {
					if(sal.equals(used)) salmons.remove(sal);
				}
			}
		}
	}

	
	return max+1;
}*/
	
}
