package com.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
	
	static class Entry{
		Entry previous;
		Entry next;
		Character key;
	}
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int cacheSize = Integer.parseInt(input[0]);
        //System.out.println(cacheSize);
        Map<Character, Entry> cache = new HashMap<>();
        Entry start,end;start=end=null;
        String[] accessRequests = input[1].split("!");
        for(String seq: accessRequests){
            for(char c: seq.toCharArray()){
                if(cache.containsKey(c)) {
                  Entry en = cache.get(c);
                 // cache.remove(c);
                  if(en.previous != null)  en.previous.next = en.next;
                  else start = en.next;
                  if(en.next!= null) en.next.previous = en.previous;
                  en.previous = end;
                  end.next = en;
                  en.next = null;
                  end = en;
                  //System.out.println("Contains Key: start: "+ (start!=null?start.key:"") +"..... end: "+(end!=null?end.key:""));
                  //System.out.println(cache.size());
                }
                else if(cache.size()==cacheSize) {
                	cache.remove(start.key);	
                	start = start.next;
                	Entry entry = new Entry();
                	entry.key = c;
                	entry.previous = end;
            		entry.next = null;
            		end.next = entry;
            		end = entry;
            		cache.put(c, entry);
                	//System.out.println("Size Full: start: "+ (start!=null?start.key:"") +"..... end: "+(end!=null?end.key:""));
                	//System.out.println(cache.size());
                }
                else {
                	Entry entry = new Entry();
                	entry.key = c;
                	if(start == null) {
                    	entry.previous = null;
                    	entry.next = null;
                    	start = entry;
                    	end = entry;
                    	 //System.out.println("Start is Null: start: "+ (start!=null?start.key:"") +"..... end: "+(end!=null?end.key:""));
                    	 cache.put(c, entry);
                    	 //System.out.println(cache.size());
                	}
                	else {
                		entry.previous = end;
                		entry.next = null;
                		end.next = entry;
                		end = entry;
                		//System.out.println("Start is not Null: start: "+ (start!=null?start.key:"") +"..... end: "+(end!=null?end.key:""));
                		cache.put(c, entry);
                		//System.out.println(cache.size());
                	}
                	
                	
                }
                
            }
            Entry temp = start;
            
            while(temp != null) {
            	System.out.print(temp.key);
            	temp = temp.next;
            }
            System.out.print(" ");
            
        }
    }
}