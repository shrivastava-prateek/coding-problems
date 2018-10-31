package com.hackerrank;

public class EdgeVerve1 {

	//Perfect pth power
	public static void main(String[] args) {

		long n = 17;
		
		if(n<0) {
			
			System.out.println(findLargestPNegative(n));
		}
		else {
			
			System.out.println(findLargetPPositive(n));
		}
	}
	
	static int findLargetPPositive(long n) {
		int p = 1;
		int exp = 2;
		long limit = (long) Math.sqrt(n);
		for(long base=limit;base >= 2;base--) {
			long tempN = limit;
			while(tempN < n) {
				tempN = (long)Math.pow(base, exp);
				System.out.println(exp +" "+ tempN);
				exp++;
		
			}
			System.out.println("checking equality");
				if(tempN == n) {
					exp--;
					if(exp > p) {
						p = exp;
						break;
					}
				}
				exp =2;
			}
		
		return p;
	}
	
	static int findLargestPNegative(long n) {
		int p = 1;
		int exp = 2;
		long limit = (long) Math.sqrt(n*-1);
		for(long base=-limit;base <= -2;base++) {
			long tempN = -limit;
			while(tempN > n) {
				tempN = (long)Math.pow(base, exp);
				System.out.println(exp +" "+ tempN);
				exp++;
		
			}
			System.out.println("checking equality");
				if(tempN == n) {
					exp--;
					if(exp > p) {
						p = exp;
						break;
					}
				}
				exp =2;
			}
		
		return p;
	}

}
