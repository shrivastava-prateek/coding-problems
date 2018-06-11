package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TreeAndSpecialNode 
{
	 
	    public static void main(String[] args)throws Exception{
	    	
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	int N = Integer.parseInt(br.readLine());
	    	
	    	List<Node> nodes = new ArrayList<>();
	    	String[] strValues = br.readLine().split(" ");
	    	for (int i =0;i<N;i++) {
	    	Node n = new Node(Integer.parseInt(strValues[i]),i+1);
	    	nodes.add(n);
	    	}
	    	
	    	 HashSet<Node> childSet;
		     HashMap<Node, HashSet<Node>> adjList = new HashMap<>();

	    	  for (int i=0;i<N-1;i++) {
	    		String[] str = br.readLine().split(" ");
	    		Node n = nodes.get(Integer.parseInt(str[0])-1);
	    		Node o = nodes.get(Integer.parseInt(str[1])-1);
	    		 if(adjList.containsKey(n)){
		                childSet = adjList.get(n);
		                childSet.add(o);
		                adjList.put(n, childSet);
		            }
		            // create a new subtree
		            else{
		                HashSet<Node> newSet = new HashSet<>();
		                newSet.add(o);
		                adjList.put(n, newSet);
		            }
	    		
	    	}
	    	  
	    	  System.out.println(adjList);
	    	  System.out.println(countUniqueValuesPaths(adjList));
	    	
	    }
	    
	    public static int countUniqueValuesPaths(HashMap<Node,HashSet<Node>> adjList) {
	    	int count =0;
	    	List<Integer> values = new ArrayList<>();
	    	List<Node> ignoreNodes = new ArrayList<>();
	    	List<Node> countedNodes = new ArrayList<>();
	    	for(Node key: adjList.keySet()) {
	    		boolean isPresent = false;
	    			if(values.contains(key.value)) {
	    				isPresent = true;
	    				break;
	    			}
	 
	    		if(isPresent) {
	    			ignoreNodes.addAll(adjList.get(key));
	    			continue;
	    		}
	    		if(ignoreNodes.contains(key)) continue;
	    		values.add(key.value);
	    		if(!countedNodes.contains(key)) {
	    			count++;
	    			countedNodes.add(key);
	    		}
	    		
	    		for(Node child: adjList.get(key)) {
	    			if(!(child.value==key.value)) {
	    				count++;
	    				countedNodes.add(child);
	    			}
	    		}
	    	}
	    	return count;
	    }
	}

	class Node{
		int name;
		int value;
	    Node(int value,int name){
	        this.value = value;
	        this.name = name;
	    }
	    
	    @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + name;
			//result = prime * result + value;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (name != other.name)
				return false;
			//if (value != other.value)
				//return false;
			return true;
		}

		@Override
		public String toString() {
			return "Node [name=" + name + ", value=" + value + "]";
		}

		
		
	}