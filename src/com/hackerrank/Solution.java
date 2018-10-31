package com.hackerrank;

import java.io.*;
public class Solution {
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    float x = Float.parseFloat(br.readLine());
    System.out.println(findHighestPowerP(x));
}
    // for positive numbers
    static int findHighestPowerP(float x){
        int p = Integer.MIN_VALUE;
        float limit = (float)Math.sqrt(x);
        
        if(x > 1){
        	p=1;
        int exp = 2;
        for(long base = 2;base <= limit; base++){
            float tempX = (float)Math.pow(base,exp);
            while(tempX < x){
                tempX = (float)Math.pow(base,exp);
                exp++;
            }
            if(x == tempX){
                if(exp > p){
                    p= exp-1;
                    break;
                }
            }
         }
        }
        if(x < 1){
        	System.out.println("inside method");
        	//int exp = Math.log10(x)/Math.log(2);
        	if(x < 1){
                int exp = -1;
                for(long base = 2;base <= limit; base++){
                float tempX = (float)Math.pow(base,exp);
                    System.out.println(tempX);
                while(tempX < x){
                    tempX = (float)Math.pow(base,exp);
                    System.out.println(tempX+" "+exp);
                    exp--;
                }
                if(x == tempX){
                    if(exp > p){
                        p= exp+1;
                        break;
                    }
                }
             }
                
            }

        }
        if(p == Integer.MIN_VALUE) return 1;
        else return p;
    }
}