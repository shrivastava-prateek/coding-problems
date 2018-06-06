package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BobTheForest {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		int nRow = Integer.parseInt(strArr[0]);
		int nColumn = Integer.parseInt(strArr[1]);
		
		char[][] matrix = new char[nRow][nColumn];
		for(int i=0;i<nRow;i++) {
			for (int j = 0;j<nColumn;j++) {
				matrix[i][j] = (char)br.read();
			}
			br.readLine();
		}
		
		/*for(int i=0;i<nRow;i++) {
			for (int j = 0;j<nColumn;j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}*/

		
		int count = Integer.parseInt(br.readLine());
		int sum=0;
	    for(int i=0;i<count;i++) {
	    	int size = Integer.parseInt(br.readLine());
	    	sum = sum + getSubMatrixCount(matrix, nRow-1, nColumn-1, size);
	    	System.out.println(sum);
	    }
	    
	}
	
	public static int getSubMatrixCount(char[][] matrix,int nRow,int nColumn,int size) {
		int count =0;
		for(int i=0;i<=nRow;i++) {
			for(int j= 0;j<=nColumn;j++) {
				if(checkMatrix(matrix,i,i+size-1,j, j+size-1,nRow,nColumn)) count++;
			}
		}
		
		return count;
	}
	
	public static boolean checkMatrix(char[][] matrix,int startRow, int endRow, int startColumn,int endColumn,int row,int column) {
		if(startRow < 0||endRow > row || startColumn < 0 || endColumn > column) return false;
		for(int i=startRow;i<=endRow;i++) {
			for(int j=startColumn;j<=endColumn;j++) {
				
				if(matrix[i][j]=='*') {
					//System.out.println(i+","+j);
					continue;
				}
				else return false;
			}
			//System.out.println();
		}
		return true;
	}
}
