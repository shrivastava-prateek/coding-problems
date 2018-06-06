package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryTreeMinimizeValue {
	
	static class Node{
		int value;
		Node left;
		Node right;
	}

	public static void main(String[] args)throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = br.readLine().split(" ");
		
		int nodes = Integer.parseInt(firstLine[0]);
		int newNodevalue = Integer.parseInt(firstLine[1]);
		String[] nodeValues = br.readLine().split(" ");
		
		
		for (String value: nodeValues) {
			Node n = new Node();
			n.value = Integer.parseInt(value);
		}
		for(int i=0;i<nodes-1;i++) {
			String[] edges = br.readLine().split(" ");
			
		}
		

	}
	
	public static void createBinaryTree() {
		
	}

}
