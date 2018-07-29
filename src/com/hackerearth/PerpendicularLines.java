package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Perpendicular Lines
Given 4 points of the form (xi, yi) in 2D plane, find out if the lines formed by (x1, y1), (x2, y2) and (x3, y3), (x4, y4) are perpendicular to each other.

NOTE:

It is NOT provided that the points are distinct i.e the first two or the last two points may be equal too!
INPUT FORMAT:

First line T is the number of test cases. Each test case is followed by 2 lines.

The first line of every test case contains four integers (x1, y1) and (x2, y2).

The second line contains four integers (x3, y3) and (x4, y4).

OUTPUT FORMAT:

For every test case :

print "YES" without quotes if the lines are perpendicular to each other
print "NO" without quotes if the lines are not perpendicular
print "INVALID" without quotes if there are less than 2 lines
CONSTRAINTS:

1 <= T <= 10^5

-10^18 <= xi <= 10^18

-10^18 <= yi <= 10^18

Sample Input
4
1 2 3 3 
3 3 1 7
3 4 8 9
13 5 13 5
5 7 12 9
1 5 9 15
7 9 10 12
10 14 17 21
Sample Output
YES
INVALID
NO
NO

Explanation
First Test case ->

Slope of first line = 0.5

Slope of Second line = -2

Produce of Slopes = -1

Hence they are perpendicular! Answer is "YES".

Second Test Case ->

The Second line is not formed. Hence the answer is "INVALID"
 * 
 */
public class PerpendicularLines {

	public static void main(String[] args)throws Exception {

		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			
			for(int t = 0;t<T; t++) {
			
				boolean horizontal1=false,horizontal2=false,vertical1=false,vertical2=false;
				double m1= Double.MIN_VALUE,m2=Double.MIN_VALUE;
				String[] firstLine = br.readLine().split(" ");
				double x11 = Double.parseDouble(firstLine[0]);
				double y11 = Double.parseDouble(firstLine[1]);
				double x12 = Double.parseDouble(firstLine[2]);
				double y12 = Double.parseDouble(firstLine[3]);
				
				
				double x1 = x12-x11;
				double y1 = y12-y11;
				
				if(y1==0 && x1==0) {
					System.out.println("INVALID");
					continue;
				}
				else if(x1 == 0 && y1 != 0) vertical1 = true;
				else if(x1 != 0 && y1 == 0) horizontal1 = true;
				else m1 = (y1)/(x1);
				
				//System.out.println("Slope of first line: "+m1);
				String[] secondLine = br.readLine().split(" ");
				double x21 = Double.parseDouble(secondLine[0]);
				double y21 = Double.parseDouble(secondLine[1]);
				double x22 = Double.parseDouble(secondLine[2]);
				double y22 = Double.parseDouble(secondLine[3]);
				
				double x2 = x22-x21;
				double y2 = y22-y21;
				
				if(y2==0 && x2==0) {
					System.out.println("INVALID");
					continue;
				}
				else if(x2 == 0 && y2 != 0) vertical2 = true;
				else if(x2 != 0 && y2 == 0) horizontal2 = true;
				else m2 = (y2)/(x2);			
				
				//System.out.println("Slope of second line: "+m2);
				
				if(horizontal1 == true && vertical2 == true && x22<= x12 && x22>= x11 && y11 <= y22 && y11 >= y21) System.out.println("YES");
				else if(horizontal2 == true && vertical1 == true && x12 <= x22 && x12>=x21 && y22 >= y11 && y22 <= y12) System.out.println("YES");
				else if (m2*m1 == -1) System.out.println("YES");
				//else if (m2 == m1) System.out.println("INVALID");
				else System.out.println("NO");
			}
			
		
	}

}
