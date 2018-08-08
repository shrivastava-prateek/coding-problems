package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Wissen1 {
private static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
    public static void main(String args[] ) throws Exception {

    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
        	
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(tk.nextToken());
            if (type == 1) {
                int val = Integer.parseInt(tk.nextToken());
                add_to_list(val);
            }
            else if (type == 2) {
                int val = Integer.parseInt(tk.nextToken());
                remove_from_list(val);
            }
            else if (type == 3) {
                int ans = find_least_frequency();
                System.out.println(ans);
            }
            else if (type == 4){
                int ans = find_highest_frequency();
                System.out.println(ans);
            }
        }
    }
    public static void add_to_list(int val){
        //Process queries of type 1 here

    	if(map.get(val)!= null) {
    		int value = map.get(val);
    		map.remove(val);
    		map.put(val, ++value);
    		//System.out.println("Map: "+ map+"  values: "+ val +", "+ value);
    	}
    	else map.put(val, 1);
    }

    public static void remove_from_list(int val){
        //Process queries of type 2 here
    	if(map.containsKey(val)) {
    		int value = map.get(val);
    		if(value==1) map.remove(val);
    		else map.put(val, --value);
    	}
    }

    public static int find_least_frequency(){
        //Process queries of type 3 here
    	int minimumFrequency = Integer.MAX_VALUE;
    	int largerKey = Integer.MIN_VALUE;
    	for(int i : map.keySet()) {
    		if(map.get(i) < minimumFrequency) {
    			minimumFrequency = map.get(i);
    			largerKey = i;
    		}
    		else if (map.get(i) == minimumFrequency) {
    			if(i>largerKey) largerKey = i;
    		}
    	}
    	
    	if(map.size() == 0) return -1;
    	else return largerKey;
    }

    public static int find_highest_frequency(){
    	
    	int maxFrequency = Integer.MIN_VALUE;
    	int smallerKey = Integer.MAX_VALUE;
    	for(int i : map.keySet()) {
    		if(map.get(i) > maxFrequency) {
    			maxFrequency = map.get(i);
    			smallerKey = i;
    		}
    		else if (map.get(i) == maxFrequency) {
    			if(i<smallerKey) smallerKey = i;
    		}
    	}
    	
    	if(map.size() == 0) return -1;
    	else return smallerKey;
    }
}
