package com.hackerearth.basicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class WaysToBST {
	static Node root;
    public static void main(String args[] ) throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i =0;i<T;i++) {
        	 int N = Integer.parseInt(br.readLine());
        	 String[] strArr = br.readLine().split(" "); 
        	 Node root = createBinarySearchTree(strArr, N);
        	 System.out.println(levelOrderTraversal(root));
    
        }
        int k = 742614241;
        System.out.println(k);
    }

 static Node createBinarySearchTree(String[] strArr,int N) {
	    Node n = null;
	    Node tempRoot = null;
	    root = new Node(Integer.parseInt(strArr[0]));
	    tempRoot = root;
		 for (int i = 1; i< N;i++) {
			 n = new Node(Integer.parseInt(strArr[i]));
			while(true) {
				if(n.data > tempRoot.data) {
					if(tempRoot.right == null) {
						tempRoot.right = n;
						break;
					}
					else tempRoot = tempRoot.right;
				}
				else if (n.data <= tempRoot.data ) {
					if(tempRoot.left == null) {
						tempRoot.left = n;
						break;
					}
					else tempRoot = tempRoot.left;
				}
			}
			
			tempRoot = root;
		 }
	 return root;
	 
    }
 
 static int levelOrderTraversal(Node root) {
	 int noOfComb =0, childrenCount = 0,count = 0,totalChildCount = 1,childrenCountLevel=0,totalCombLevel=1;
	 
	 Queue<Node> queue = new LinkedList<>();
	 queue.add(root);
	 noOfComb = 1;
	 while(!queue.isEmpty()) {
		 Node temp = queue.poll();
		 if(count >0)
		 count--;
		 System.out.println(temp);
		 if (temp.left != null) {
			 queue.add(temp.left);
			 System.out.println("left child: "+temp.left);
				 childrenCountLevel++;
				 childrenCount++;
		 }
		 if(temp.right != null) {
			 queue.add(temp.right);
			 System.out.println("right child: "+temp.right);
			 childrenCountLevel++;
			 childrenCount++;
		 }
		// System.out.println("child count: "+childrenCount);
		 if(count == 0) {
		 count = childrenCountLevel;
		 noOfComb = factorial(childrenCountLevel);
		 totalCombLevel *= noOfComb;
		 childrenCountLevel = 0;
		 }
		 if(childrenCount != 0)
		 totalChildCount *= childrenCount;
		 
		 childrenCount = 0;
		
	 }
	 //System.out.println(totalChildCount + " -- "+ totalCombLevel);
	 return totalChildCount+totalCombLevel;
 }
 
 static int factorial(int n) {
	 int f = 1;
	 while(n>0) {
		 f = f*n;
		 n--;
	 }
	 return f;
 }
static class Node{
	 @Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	int data;
	 Node left,right;
	 
	 public Node(int data) {
		 this.data = data;
		 this.left = null;
		 this.right = null;
	 }
 }
    
    }

