package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TotalPower {

	static long sum =0;
	public static void main(String[] args) throws Exception{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	for(int t=0;t<T;t++) {
    		String[] strArr = br.readLine().split(" ");
    		int N = Integer.parseInt(strArr[0]);
    		int M = Integer.parseInt(strArr[1]);
    		int K = Integer.parseInt(strArr[2]);
    		//int[][] matrix = new int[N][M];
    		Map<String,Integer> matrix = new HashMap<>();
      		for(int k=0;k<K;k++) {
    			String[] strArr2 = br.readLine().split(" ");
    			int x = Integer.parseInt(strArr2[0]);
    			int y = Integer.parseInt(strArr2[1]);
    			int p = Integer.parseInt(strArr2[2]);
    			//matrix[x-1][y-1] = p;
    			matrix.put((x-1)+""+(y-1), p);
    			}
    	try {
    		//System.out.println(matrix);
    		powerSum(matrix,N-1,M-1);
    		System.out.println(sum);
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    	}
    	}

	}
	
	static long powerSum(Map<String,Integer>matrix,int m, int n) {
		if(m<0 || n<0) return 0;
		//sum = sum+matrix[m][n];
		int temp = matrix.get(m+""+n) == null?0:matrix.get(m+""+n);
	  //  System.out.println(m+""+n);
		sum = sum + temp;
		return powerSum(matrix, m-1,n)+powerSum(matrix,m,n-1);
	}

}
