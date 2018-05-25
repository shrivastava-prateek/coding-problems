package com.hackerearth.basicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cipher {

	public static void main(String[] args)throws Exception {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String name = br.readLine(); 
	        int k = Integer.parseInt(br.readLine());
	        int len = name.length();
	        String output = "";
	        for (int i =0;i<len;i++) {
	        	int c = name.charAt(i);
	        	if((c>=65 && c <=90)) {
	        		c = c+ k%26;
	        		if(c>90)c = 65 + c%90 -1;
	        	}else if(c>=48 && c<= 57) {
	        		c = c+ k%10;
	        		if(c>57)c = 48+c%57 - 1;
	        	}else if(c>=97 && c<= 122) {
	        		c = c+ k%26;
	        		if(c>122)c = 97 + c%122 - 1;
	        	}
	        		
	        	//System.out.println(c);
	        	output = output+(char)c;
	        	
	        }
	        System.out.println(output);

	}

}
