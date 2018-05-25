package com.techgig.codegladiator;

import java.util.Scanner;

public class RUbyNecklace2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		int r = sc.nextInt();
		int y = sc.nextInt();
		int g = sc.nextInt();
		sc.close();
		
		int length = 0;
		
		if (b == 0 && r == 0) {
			if (y == 0) length = g;
			else length = g+1;
		}
		else if(b != 0 && r == 0) length = b;
		else if(b == 0 && r != 0) {
			if(y == 0) length = g+1;
			else if (r > y) length = 2*y+g+1;
			else length = 2*r+g;
		}
		else if(b != 0 && r != 0) {
			if (y == 0) length = b+1+g;
			else if (r > y) length =2*y+g+1+b;
			else length = 2*r+g+b;
		}
		
		System.out.println(length);
		
		
		}
	}
