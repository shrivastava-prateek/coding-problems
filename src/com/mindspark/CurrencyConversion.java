package com.mindspark;

import java.util.Scanner;

public class CurrencyConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int coin = sc.nextInt();
System.out.println(findMaxValue(coin));
sc.close();
	}
	
	public static int findMaxValue(int coin){
		int sum=0;
		
		if(coin <= 0){
			return 0;
		}
		else{
		sum = findMaxValue(coin/2)+findMaxValue(coin/3)+findMaxValue(coin/4);
		
		if(sum > coin){
		return sum;
		}
		else{
			return coin;
		}
		}
	}

}
