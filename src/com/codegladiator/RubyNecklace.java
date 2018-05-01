package com.codegladiator;

import java.util.Scanner;

public class RubyNecklace {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		int r = sc.nextInt();
		int y = sc.nextInt();
		int g = sc.nextInt();
		sc.close();
		
	
		
		if (b > 0 || r > 0) {
			int lb = calculateLength("BLUE", b,r,y,g,0);
			int lr = calculateLength("RED", b,r,y,g, 0);
			
			int len = (lb > lr)? lb:lr;
			System.out.println(len);
		}
		else if( y> 0 || g > 0) {
			int ly = calculateLength("YELLOW", b,r,y,g, 0);
			int lg = calculateLength("GREEN", b,r,y,g, 0);
			
			int len = (ly > lg)? ly:lg;
			System.out.println(len);
		}
		else System.out.println(0);
		

	}
	
	public static int calculateLength(String color,int b,int r,int y,int g, int length) {
		
			switch( color) {
			case "BLUE":{
				 if(b == 0) {
					 return length;
				 }
				 else {
					 b = b-1;
			    int l1 =  calculateLength("BLUE", b,r,y,g,length + 1);
			    int l2 =  calculateLength("RED",  b,r,y,g, length + 1);
			    return (l1 > l2)? l1:l2;
				 }
			}
			
			case "RED":{
				 if(r == 0) {
					 return length;
				 }
				 else {
					 r = r-1;
			     int l1= calculateLength("GREEN", b,r,y,g,length + 1);
			     int l2 = calculateLength("YELLOW",  b,r,y,g, length + 1);
			     return (l1 > l2)? l1:l2;
			     }
			     }
			
			case "YELLOW":{
				 if(y == 0) {
					 return length;
				 }
				 else {
					 y = y-1;
			     int l1=  calculateLength("BLUE", b,r,y,g,length + 1);
			     int l2 = calculateLength("RED",  b,r,y,g, length + 1);
			     return (l1 > l2)? l1:l2;
			     }
			     }
			
			case "GREEN":{
				 if(g == 0) {
					 return length;
				 }
				 else {
					 g = g-1;
			     int l1 = calculateLength("GREEN", b,r,y,g,length + 1);
			     int l2 = calculateLength("YELLOW",  b,r,y,g, length + 1);
			     return (l1 > l2)? l1:l2;
			     }
			     }
			}
			return 0;
		
	}

}
