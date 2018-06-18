package com.codefights;

import java.util.HashSet;
import java.util.Set;

public class AllInOne {

	public static void main(String[] args) {

		int a[][] = {{1,2,3}, 
		 {4,5,6}, 
		 {7,8,9}};
		
		rotateImage(a);
		
		for(int i = 0;i<a.length;i++) {
			for(int j = 0 ; j<a[i].length;j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
	
	
	static int[][] rotateImage(int[][] a) {

	    int n = a.length;
	    //int N = a[0].length-1;
	    //System.out.println("M: "+M+" N:"+N);
	    for(int layer = 0;layer <= n/2;layer++){
	    	int first = layer;
	    	int last = n-1-layer;
	        for(int i = first; i<last;i++){
	        	//System.out.println("i: "+i+" j: "+j);
	        	int offset = i - first;
	            int top = a[first][i];
	            a[first][i] = a[last-offset][first];
	            a[last-offset][first] = a[last][last-offset];
	            a[last][last-offset] = a[i][last];
	            a[i][last] = top;	        
	            }
	       
	    }
	    return a;
	}
	
	static int firstDuplicate(int[] a) {
		int len = a.length;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<len;i++){
		    if(set.contains(a[i])) return a[i];
		   set.add(a[i]);
		}
		    return -1;
		}
	
	
	static char firstNotRepeatingCharacter(String s) {

	    for(char a:s.toCharArray()){
	        int i = s.indexOf(a);
	        int j = s.lastIndexOf(a);
	        if(i == j) return a;
	    }
	    
	    return '_';
	}
	



}
