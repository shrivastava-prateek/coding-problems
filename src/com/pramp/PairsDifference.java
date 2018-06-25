package com.pramp;

import java.util.HashSet;
import java.util.Set;

/*
Pairs with Specific Difference
Given an array arr of distinct integers and a nonnegative integer k, write a function findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr, 
such that x - y = k. If no such pairs exist, return an empty array.

Note: the order of the pairs in the output array should maintain the order of the y element in the original array.

Examples:

input:  arr = [0, -1, -2, 2, 1], k = 1
output: [[1, 0], [0, -1], [-1, -2], [2, 1]]

x-y = 1
0-y = 1
y =-1

[0, -1, -2, 2, 1]
0, y = -1
y in Set , yes  [0, -1],

-1, y = -2 , [-1,-2]

-2, y = -3 . 

2, y = 1, yes [2,1]

1, y = 0 [1,0]
*/

public class PairsDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0, -1, -2, 2, 1};
		int k = 1;
		int[][] pairs = findPairs(arr, k);
		
		for(int[] pair: pairs) {
			System.out.print("[");
			for(int i:pair) {
				System.out.print(i+ " ");
			}
			System.out.print("]");
			System.out.println();
		}

	}
	
	
	private static int[][] findPairs(int[] arr,int k){
	

	int[][] resultArr = new int[arr.length][2];
	int index = 0;
	Set<Integer> set = new HashSet<>();
	for(int i: arr){
	set.add(i);
	}
	//System.out.println(set);

	for(int i = 0;i<arr.length;i++){
	int x = k + arr[i];
 System.out.println("x: "+x+ "for element: "+ arr[i]);
	// do a binary search to check if the x is present in the array which will give overall time complexity of nlogn
	// or else maintain these elements in hashset

	if(set.contains(x)) {
	int[] pair = new int[2];
	pair[0] = x;
	pair[1] = arr[i];
	resultArr[index++] = pair;
	}

	}

	return resultArr;

	}

}
