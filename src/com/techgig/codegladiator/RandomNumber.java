package com.techgig.codegladiator;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		int r = 0;
		for (int i = 0; i<1000; i++) {
			//int r =0;
		    r = (int)(Math.random()*1000000000);
			//double r = Math.random();
			//System.out.print(Math.pow(10, 6)*r+ " ");
			//Random random = new Random();
			//System.out.print(random.nextInt((int)Math.pow(10, 9))+" ");
		    System.out.print(r+" ");
		}

	}

}
