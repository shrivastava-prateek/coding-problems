package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PalindromicNumber {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0;i<T;i++) {
			System.out.println(getMaxCountLowestInt(br.readLine()));
		
		}
		
	}
	
	
	public static int getMaxCountLowestInt(String sb) {
		int[] CONST_INT = new int[10];
		
		for (char ch:sb.toCharArray()) {
			CONST_INT[Integer.parseInt(ch+"")]++;
		}
		int maxIndex=0,maxCount =0;
		for(int i =0;i<10;i++) {
			if(maxCount < CONST_INT[i]) {
				maxCount = CONST_INT[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	

}
