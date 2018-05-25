package com.hackerearth.basicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LifeUniverseEverything {

	public static void main(String[] args) throws IOException {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
        	int no = Integer.parseInt(br.readLine());
        	if(no == 42) {
        		break;
        	}
        	System.out.println(no);
        }
        
	}

}
