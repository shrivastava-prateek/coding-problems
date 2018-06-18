package com.pramp;

public class SpiralArray {

	public static void main(String[] args) {
		// 4 X 4
int[][] matrix = {
		{1,2,3,4},
		{5,6,7,8},
		{9,10,11,12},
		{13,14,15,16}
};

		// 4 X 3
/*int[][] matrix = {
		{1,2,3},
		{5,6,7},
		{9,10,11},
		{13,14,15}
};*/

		// 3 X 4
/*int[][] matrix = {
{1,2,3,4},
{5,6,7,8},
{9,10,11,12}
};*/
printSpiralArray(matrix);
	}
	
	static void printSpiralArray(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		int limit = rows/2;
		if(!(rows%2 == 0)) {
			limit = limit + 1;
		}
		//layers iterations
		for(int layer = 0;layer<limit;layer++) {
			System.out.println("layer: " + layer);
			//printing top
			int k =0,l=0;
			for(int i = layer; i<columns-layer;i++) {
				System.out.print(matrix[layer][i]+" ");
				k++;
			}
			System.out.println();
			
			//Printing the right column
			for(int j = layer+1; j<rows-layer;j++) {
				System.out.print(matrix[j][columns-layer-1]+" ");
				l++;
			}
			System.out.println();
			
			//Printing the bottom
			for(int i = k-2; i>=layer;i--) {
				System.out.print(matrix[rows-layer-1][i]+" ");
			}
			System.out.println();
			
			//Printing the left column
			for(int j = l-1; j>layer;j--) {
				System.out.print(matrix[j][layer]+" ");
			}
			System.out.println();
			
		}
	}

}
