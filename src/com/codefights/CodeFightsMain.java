package com.codefights;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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



	/**************************************************************************/

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


	/**************************************************************************/

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

	/**************************************************************************/

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


	/**************************************************************************/
	/*
	 * Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.

Example

For

grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
        ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
        ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
        ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
        ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
        ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
        ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
the output should be
sudoku2(grid) = true;

For

grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
        ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
        ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
        ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
        ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
        ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
        ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
        ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
the output should be
sudoku2(grid) = false.

The given grid is not correct because there are two 1s in the second column. Each column, each row, and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.char grid

A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.

[output] boolean

Return true if grid represents a valid Sudoku puzzle, otherwise return false.
	 */ 
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

	/**************************************************************************/	

	/*
	 * A cryptarithm is a mathematical puzzle for which the goal is to find the correspondence between letters and digits, such that the given arithmetic equation consisting of letters holds true when the letters are converted to digits.

You have an array of strings crypt, the cryptarithm, and an an array containing the mapping of letters and digits, solution. The array crypt will contain three non-empty strings that follow the structure: [word1, word2, word3], which should be interpreted as the word1 + word2 = word3 cryptarithm.

If crypt, when it is decoded by replacing all of the letters in the cryptarithm with digits using the mapping in solution, becomes a valid arithmetic equation containing no numbers with leading zeroes, the answer is true. If it does not become a valid arithmetic solution, the answer is false.

Example

For crypt = ["SEND", "MORE", "MONEY"] and

solution = [['O', '0'],
            ['M', '1'],
            ['Y', '2'],
            ['E', '5'],
            ['N', '6'],
            ['D', '7'],
            ['R', '8'],
            ['S', '9']]
the output should be
isCryptSolution(crypt, solution) = true.

When you decrypt "SEND", "MORE", and "MONEY" using the mapping given in crypt, you get 9567 + 1085 = 10652 which is correct and a valid arithmetic equation.

For crypt = ["TEN", "TWO", "ONE"] and

solution = [['O', '1'],
            ['T', '0'],
            ['W', '9'],
            ['E', '5'],
            ['N', '4']]
the output should be
isCryptSolution(crypt, solution) = false.

Even though 054 + 091 = 145, 054 and 091 both contain leading zeroes, meaning that this is not a valid solution.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.string crypt

An array of three non-empty strings containing only uppercase English letters.

Guaranteed constraints:
crypt.length = 3,
1 ≤ crypt[i].length ≤ 14.

[input] array.array.char solution

An array consisting of pairs of characters that represent the correspondence between letters and numbers in the cryptarithm. The first character in the pair is an uppercase English letter, and the second one is a digit in the range from 0 to 9.

Guaranteed constraints:
solution[i].length = 2,
'A' ≤ solution[i][0] ≤ 'Z',
'0' ≤ solution[i][1] ≤ '9',
solution[i][0] ≠ solution[j][0], i ≠ j,
solution[i][1] ≠ solution[j][1], i ≠ j.

It is guaranteed that solution only contains entries for the letters present in crypt and that different letters have different values.

[output] boolean

Return true if the solution represents the correct solution to the cryptarithm crypt, otherwise return false.
	 */


	boolean isCryptSolution(String[] crypt, char[][] solution) {

		Map<Character, Character> map = new HashMap<>();
		for(int i=0; i< solution.length; i++){
			map.put(solution[i][0], solution[i][1]);
		}
		int j=0;
		String[] wordArr = new String[3];
		for(String str: crypt){
			StringBuilder s = new StringBuilder();
			for(char c: str.toCharArray()){
				s.append(map.get(c)+"");
			}
			wordArr[j] = s.toString();
			if(wordArr[j].startsWith("0") && wordArr[j].length()>1) return false;
			j++;
		} 

		long num1= Long.parseLong(wordArr[0]);
		long num2= Long.parseLong(wordArr[1]);
		long num3= Long.parseLong(wordArr[2]);
		if(num1+num2==num3) return true;
		return false;
	}

	
	/**************************************************************************/	
	
	/*
	 * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list, since this is what you'll be asked to do during an interview.

Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.

Example

For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
removeKFromList(l, k) = [1, 2, 4, 5];
For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
removeKFromList(l, k) = [1, 2, 3, 4, 5, 6, 7].
Input/Output

[execution time limit] 3 seconds (java)

[input] linkedlist.integer l

A singly linked list of integers.

Guaranteed constraints:
0 ≤ list size ≤ 105,
-1000 ≤ element value ≤ 1000.

[input] integer k

An integer.

Guaranteed constraints:
-1000 ≤ k ≤ 1000.

[output] linkedlist.integer

Return l with all the values equal to k removed.
	 */

	// Definition for singly-linked list:
	class ListNode<T> {
		ListNode(T x) {
			value = x;
		}
		T value;
		ListNode<T> next;
	}

	ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {


		if(l == null || l.value == k && l.next == null) return null;

		ListNode<Integer> previous = null;
		ListNode<Integer> current = l;

		while(current != null){

			if(current.value == k){
				if(previous == null) {
					if(current.next == null) {
						return null;
					}
					else{
						current = current.next;
						l = current;
					}
				}
				else{

					previous.next = current.next;
					current = current.next;
				}
			}
			else{
				previous = current;
				current = current.next;
			}

		}
		return l;
	}



}
