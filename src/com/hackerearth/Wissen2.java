package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class Wissen2 {

	private static class Dimension{
		int length;
		int breadth;
		public Dimension(int length, int breadth) {
			super();
			this.length = length;
			this.breadth = breadth;
		}
		
		
	}

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Dimension> dimensions = new ArrayList<Dimension>();
        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(tk.nextToken());
            int R = Integer.parseInt(tk.nextToken());
            dimensions.add(new Dimension(L,R));
        }
        align_rectangles(dimensions);
        for(Dimension d: dimensions) {
            System.out.println(d.length + " " + d.breadth);
        }
    }
    public static void align_rectangles(List<Dimension> dimensions){
        //Not that you neeed to update the arrays L and R as per the new aligned order
    	Comparator<Dimension> c = new Comparator<Dimension>() {

			@Override
			public int compare(Dimension o1, Dimension o2) {
				if(o1.length < o2.length) return -1;
				if(o1.length > o2.length) return 1;
				else if(o1.length*o1.breadth > o2.length*o2.breadth) return -1;
				else if(o1.length*o1.breadth < o2.length*o2.breadth) return 1;
				else return 0;
			}

			
    	};
    	
    	Collections.sort(dimensions, c);
    	
    }
    
}
