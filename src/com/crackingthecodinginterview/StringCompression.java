package com.crackingthecodinginterview;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringCompression {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String toBeCompressed = br.readLine();
	
		char lastChar = toBeCompressed.charAt(0);
		String compressed = "";
		int count = 1;
		char[] charArr = toBeCompressed.toCharArray();
		
		for (int i = 1;i < charArr.length; i ++){
			if (charArr[i] == lastChar) {
				count++;
			}
			else {
				compressed+= lastChar+""+count+"";
				count = 1;
				lastChar = charArr[i];
			}
					
		}
		compressed+= lastChar+""+count+"";
		
		System.out.println(compressed);
		
	}

}
