package com.techgig.codegladiator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
			if(this.headT > salmon.headT ) return false;
			if(this.tailT < salmon.tailT) return false;
			return true;
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
	       
	}
	
	public static Map<Salmon,List<Salmon>> checkOverlapping(List<Salmon> salmonList){
		Map<Salmon, List<Salmon>> mapSalmonIntervals = new HashMap<Salmon, List<Salmon>>();
		for(int i = 0 ; i < salmonList.size()-1; i++){
			mapSalmonIntervals.put(salmonList.get(i), new ArrayList<Salmon>());
			for(int j = i+1; j < salmonList.size(); j++){
				if(salmonList.get(i).isOverlap(salmonList.get(j))){
					System.out.println(salmonList.get(i) + " overlaps " + salmonList.get(j));
					mapSalmonIntervals.get(salmonList.get(i)).add(salmonList.get(j));
				}
			}
		}
		return mapSalmonIntervals;
	}

}
