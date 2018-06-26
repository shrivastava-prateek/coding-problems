package com.codefights;

import java.util.HashSet;
import java.util.Set;

public class CodeFightsMain {

	public static void main(String[] args) {

		int a[][] = {{1,2,3}, 
		 {4,5,6}, 
		 {7,8,9}};
		
		rotateImage(a);
		
		for(int i = 0;i<a.length;i++) {
			for(int j = 0 ; j<a[i].length;j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		
		
		//for Sudoku2
		/*char[][] grid = {{'.','.','.','.','.','.','.','.','2'}, 
				 {'.','.','.','.','.','.','6','.','.'}, 
				 {'.','.','1','4','.','.','8','.','.'}, 
				 {'.','.','.','.','.','.','.','.','.'}, 
				 {'.','.','.','.','.','.','.','.','.'}, 
				 {'.','.','.','.','3','.','.','.','.'}, 
				 {'5','.','8','6','.','.','.','.','.'}, 
				 {'.','9','.','.','.','.','4','.','.'}, 
				 {'.','.','.','.','5','.','.','.','.'}};
		
		System.out.println(sudoku2(grid));*/
	}
	
	
	
	/*
	 * Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview.

You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).

Example

For

a = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
the output should be

rotateImage(a) =
    [[7, 4, 1],
     [8, 5, 2],
     [9, 6, 3]]
Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.integer a

Guaranteed constraints:
1 ≤ a.length ≤ 100,
a[i].length = a.length,
1 ≤ a[i][j] ≤ 104.

[output] array.array.integer
	 */
	static int[][] rotateImage(int[][] a) {

	    int n = a.length;
	    //int N = a[0].length-1;
	    //System.out.println("M: "+M+" N:"+N);
	    for(int layer = 0;layer <= n/2;layer++){
	    	int first = layer;
	    	int last = n-1-layer;
	        for(int i = first; i<last;i++){
	        	//System.out.println("i: "+i+" j: "+j);
	        	int offset = i - first;
	            int top = a[first][i];
	            a[first][i] = a[last-offset][first];
	            a[last-offset][first] = a[last][last-offset];
	            a[last][last-offset] = a[i][last];
	            a[i][last] = top;	        
	            }
	       
	    }
	    return a;
	}
	
	
	
	/*
	 * Given an array a that contains only numbers in the range from 1 to a.length, find the first duplicate number for which the second occurrence has the minimal index. In other words, if there are more than 1 duplicated numbers, return the number for which the second occurrence has a smaller index than the second occurrence of the other number does. If there are no such elements, return -1.

Example

For a = [2, 1, 3, 5, 3, 2], the output should be
firstDuplicate(a) = 3.

There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a smaller index than the second occurrence of 2 does, so the answer is 3.

For a = [2, 4, 3, 5, 1], the output should be
firstDuplicate(a) = -1.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer a

Guaranteed constraints:
1 ≤ a.length ≤ 105,
1 ≤ a[i] ≤ a.length.

[output] integer

The element in a that occurs in the array more than once and has the minimal index for its second occurrence. If there are no such elements, return -1.
	 */
	static int firstDuplicate(int[] a) {
		int len = a.length;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<len;i++){
		    if(set.contains(a[i])) return a[i];
		   set.add(a[i]);
		}
		    return -1;
		}
	
	
	/*
	 * Note: Write a solution that only iterates over the string once and uses O(1) additional memory, since this is what you would be asked to do during a real interview.

Given a string s, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.

Example

For s = "abacabad", the output should be
firstNotRepeatingCharacter(s) = 'c'.

There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.

For s = "abacabaabacaba", the output should be
firstNotRepeatingCharacter(s) = '_'.

There are no characters in this string that do not repeat.

Input/Output

[execution time limit] 3 seconds (java)

[input] string s

A string that contains only lowercase English letters.

Guaranteed constraints:
1 ≤ s.length ≤ 105.

[output] char

The first non-repeating character in s, or '_' if there are no characters that do not repeat.
	 */
	static char firstNotRepeatingCharacter(String s) {

	    for(char a:s.toCharArray()){
	        int i = s.indexOf(a);
	        int j = s.lastIndexOf(a);
	        if(i == j) return a;
	    }
	    
	    return '_';
	}
	
	static boolean sudoku2(char[][] grid) {
		
		Set<Character> set = new HashSet<>();
		Set<Character> subGrid = new HashSet<>();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				
				if((i==0||i==3||i==6) && (j==0||j==3||j==6)) {
					for(int l=i;l<i+3;l++) {
						for(int m=j;m<j+3;m++) {
							if(grid[l][m] == '.') continue;
				          	if(subGrid.contains(grid[l][m])) return false;
				          	else subGrid.add(grid[l][m]);
						}
					}
					subGrid.clear();
				}
				if(grid[i][j] == '.') continue;
	          	if(set.contains(grid[i][j])) return false;
	          	else set.add(grid[i][j]);
			}
			set.clear();
			for(int k=0;k<9;k++) {
				if(grid[k][i] == '.') continue;
				if(set.contains(grid[k][i])) return false;
	          	else set.add(grid[k][i]);
			}
			set.clear();
			
		}

		return true;
	}



}
