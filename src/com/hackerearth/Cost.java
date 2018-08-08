package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cost {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
    	int N = Integer.parseInt(strArr[0]);
    	long K = Long.parseLong(strArr[1]);
    	
    	String[] strArr2 = br.readLine().split(" ");
    	//Arrays.sort(strArr2);
    	long count =0;
    	long cost = 0;
    	boolean flag = true;
    	if(N%2 == 0) flag = false; 
    	for(int i=0;i<N;i++) {
    		int vali = Integer.parseInt(strArr2[i]);
    		if(vali*vali <= K) {count++; }
    		//else break;
    		if (i+1<N) {
    			int valj = Integer.parseInt(strArr2[i+1]); 
    			if(vali*valj <= K){cost = cost +vali*valj; if (cost <= K) count++; }
    		}
    		cost = 0;
    	}
    	if(flag) {
    		if(Integer.parseInt(strArr2[N-1]) <= K) count++;
    		
    	}
    	
    	System.out.println(count);

	}

}
