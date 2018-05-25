package com.spoj;

import java.io.*;
public class EnormousInputTest {


	
		public static void main (String[] args) throws java.lang.Exception
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			int count =0;
			while(n!=0){
				int no = Integer.parseInt(br.readLine());
				if((no%k)==0){
					count++;
				}
				n--;
			}
			System.out.println(count);
		}
	}

