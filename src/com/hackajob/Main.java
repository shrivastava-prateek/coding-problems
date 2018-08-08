package com.hackajob;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(run(1,2));

	}
	
	
	public static String run(int N, int M) {
		/*
		* Some work here; return type and arguments should be according to the problem's requirements
		*/
		String sequence = "";
		for(int i=N;i<=M;i++){
			if(i%5 == 0 && i%3 == 0){
				sequence += "FizzBuzz,";
			}
			else if(i%5 == 0) sequence += "Buzz,";
			else if (i%3 == 0) sequence += "Fizz,";
			else sequence += i+",";
		}
		int length = sequence.length();
		return sequence.substring(0,length-1);
	}

	
}
