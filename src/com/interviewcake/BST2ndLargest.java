package com.interviewcake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BST2ndLargest {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nos = br.readLine().split(" ");
		BinaryTreeNode rootNode = new BinaryTreeNode(Integer.parseInt(nos[0]));
		createBinarySearchTree(nos, rootNode);
		levelTraversal(rootNode);
		System.out.println();
		System.out.println(findingSecondLargest(rootNode));

	}
	
	public static int findingSecondLargest(BinaryTreeNode rootNode){
		BinaryTreeNode tempNode=null;
		while(rootNode !=null){
			tempNode = rootNode.right;
			if(tempNode.right == null) {
				if(tempNode.left == null) return rootNode.value;
				else rootNode = tempNode.left;			}
			else rootNode = tempNode.right;
		}
		return 0;
	}

	public static void createBinarySearchTree(String[] nos,BinaryTreeNode rootNode){
	int len = nos.length;
	BinaryTreeNode tempNode = rootNode;
		for(int i = 1;i<len;i++){
			int val = Integer.parseInt(nos[i]);
			tempNode = rootNode;
			while(true)
		    {
		    	if(val > tempNode.value){
		    		
		    		if (tempNode.right == null) {
		    			tempNode.right = tempNode.insertRight(val);
		    			System.out.println("Inserted at right: "+val + "of "+tempNode.value);
		    			break;
		    		}
		    		else tempNode = tempNode.right;
		    	}
		    	else {
		    		if (tempNode.left == null){
		    			tempNode.left = tempNode.insertLeft(val);
		    			System.out.println("Inserted at left: "+val + "of "+tempNode.value);
		    			break;
		    		}
		    		else tempNode = tempNode.left;
		    	}
		    }
			
		}
	}
	
	public static void levelTraversal(BinaryTreeNode rootNode){
		Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        System.out.println(queue);
        while(!queue.isEmpty()){
        	BinaryTreeNode node = queue.poll();
        	System.out.print(node.value +" ");
     		BinaryTreeNode left = node.left;
     		BinaryTreeNode right = node.right;
     		
     		if(left != null) queue.add(left);
     		if(right!=null) queue.add(right);
        }
       
		
	}
	static class BinaryTreeNode{
		public int value;
		public BinaryTreeNode left;
		public BinaryTreeNode right;
		
		public BinaryTreeNode(int value){
			this.value = value;
		}
		
		public BinaryTreeNode insertLeft(int leftValue){
			this.left = new BinaryTreeNode(leftValue);
			return this.left;
		}
		
		public BinaryTreeNode insertRight(int rightValue){
			this.right = new BinaryTreeNode(rightValue);
			return this.right;
		}
		
		
	}
	
}
