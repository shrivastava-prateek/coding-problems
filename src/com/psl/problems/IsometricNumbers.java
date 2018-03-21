package com.psl.problems;

public class IsometricNumbers {

	
	public static int getIsometricValue(int n,int m){
		
	/* Write your code here
	   Do not write System.out.println here or any other printing statements
       Your code may get 0 marks if you do not follow above instruction. 
	*/
	if(n< 0 || m > 1000){
		return 0;
	}
	int max = 0;
	while(n<=m){
		int number,lastDigit;
		//Part (a)
		number = n*n;
		int sodA = 0;
		while(number>0){
			lastDigit = number%10;
			//System.out.println("Last Digit:" + lastDigit);
			sodA = sodA + lastDigit;
			number = number/10;
		}
		//System.out.println("Sum of Digits by (a): "+sodA);
		
		//Part (b)
		number = n;
		int sodB1 = 0;
		int square;
		while(number>0){
			lastDigit = number%10;
			//System.out.println("Last Digit:" + lastDigit);
			square = lastDigit * lastDigit;
			sodB1 = sodB1 + square;
			number = number/10;
		}
		number = sodB1;
		int sodB2=0;
		while(number>0){
			lastDigit = number%10;
			sodB2 = sodB2 + lastDigit;
			number = number/10;
		}
		//System.out.println("Sum of Digits by (b): "+sodB2);
		// Compare results
		if(sodA == sodB2){
			int sum=0;
			number = n;
			while(number>0){
				lastDigit = number%10;
				sum = sum + lastDigit;
				number = number/10;
			}
			//System.out.println("Isometric Value: " +sum);
			if(sum > max){
				max = sum;
				//System.out.println("Changed Isometric Value now :" + max);
			}
		}
		n++;
	}
	return max;
	
	}
	public static void main(String args[])
	{
	    /*
	        You can use Console input as well with the help of Scanner or BufferedReader classes.
		Please provide input data in Input box on right side of window.
	    */
        int n=8, m=12;
		
	    System.out.println(getIsometricValue(n, m));
	}
	
}
