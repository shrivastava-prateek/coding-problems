
/* 
   You can use System.out.println for debugging purposes, e.g.
   System.out.println("this is a debug message");
*/

package com.psl.mindspark;

public class NetworkInstallationDPSoln {
    //function to find maximum distance of current tower with existing along a col from top to bottom
    public static int maxCostAlongCol(int col, int top, int bottom, int width, int plot[][])
    {
        int i,costAlongCol = 0,tempWidth;
        for( i = top; i <= bottom; ++i ){
    		if( plot[i][col] != 0) {
    		//if there is some tower installed far away from the width of the current rectangle then take that as max distance
    		tempWidth = width;
    		if ( tempWidth < i - top ) 
    			tempWidth = i - top;
    		if ( tempWidth < bottom - i ) 
    			tempWidth = bottom - i;
    		costAlongCol += tempWidth;
    		}
    	}
        return costAlongCol;
    }
    //function to find maximum distance of current tower with existing along a row from left to right
    public static int maxCostAlongRow(int row, int left, int right, int height, int plot[][])
    {
        int i,costAlongRow = 0,tempHeight;
        for( i = left; i <= right; ++i ){
    		if( plot[row][i] != 0) {
    		//if there is some tower installed far away from the height of the current rectangle then take that as max distance
    		tempHeight = height;
    		if ( tempHeight < i - left ) 
    		tempHeight = i - left;
    		if ( tempHeight < right - i ) 
    		tempHeight = right - i;
    		costAlongRow += tempHeight;
    		}
    	}
        return costAlongRow;
    }

	public static int getMinimumCost(int m, int n,int[][] plot){
		
    	/* Write your code here
    	   Do not write System.out.println here or any other printing statements
           Your code may get 0 marks if you do not follow above instruction. 
    	*/
    	/*
    	#Dynamic_Programming_is_awesome.
    	This problem is really a tough one.
    	
    	If you are reading this comment then it means you are seeking answer for this problem.
    	Great!!! It's good to keep learning.
    	Please look upon my comments to understand the logic which I have used.
    	
    	Two key points to understand in this problem:
    		1. You should use BFS to move to next tower for installation, 
    			i.e. if in term of distance A<B<C then after installing tower A you should not install tower C before tower B as it would only increase the cost
    		2. If you try to find the solution by considering all possible arrangement then it would to K! (K factorial execution) just to find all the combination
    			Thus you should use DP to save results of previously calculated cost for sub problem
    			
    	*/
        int top,left,bottom,right,width,height,installationCost,tempCost;
    	int DP[][][][]= new int[m][n][51][51]; //(A 4D array to store minimum installationCost to install towers within the rectangle formed by all the 4 keys)
    	
    	//create a rectangular boundary for each possible height and width and install the tower within it, if possible
    	
        for( height = 0; height < m; ++height ){
    		for( width = height==0?1:0; width < n; ++width) { 
    		    /*when height = 0 then width should be 1 at least otherwise rectangle would be of area = 0 
    			*/
    			/*for each height and width create a rectangle from each possible cell and store the installationCost of installing towers within that rectangle in the DP 
    			*/
    			for( top = 0; top+height < m; ++top){
    				bottom = top + height;
    				for( left = 0; left+width < n; ++left) {
    					installationCost = 200000;
    					right = left + width;
    					
    					/*each rectangular region could be expand from 1 of the possible 4 edge which gives least installationCost(using modified BFS)
    					*/
    					if( height != 0) {
    						//expand from top
    						tempCost = DP[top+1][left][bottom][right] + maxCostAlongRow(top,left,right,height,plot);
    						if( tempCost < installationCost ) 
    							installationCost = tempCost;
    						
    						//expand from bottom
    						tempCost = DP[top][left][bottom-1][right] + maxCostAlongRow(bottom,left,right,height,plot);
    						if( tempCost < installationCost ) 
    							installationCost = tempCost;
    					}
    					if( width != 0) {
    						//expand from left
    						tempCost = DP[top][left+1][bottom][right] + maxCostAlongCol(left,top,bottom,width,plot);
    						if( tempCost < installationCost ) 
    							installationCost = tempCost;
    						
    						//expand from right
    						tempCost = DP[top][left][bottom][right-1] + maxCostAlongCol(right,top,bottom,width,plot);
    						if( tempCost < installationCost ) 
    							installationCost = tempCost;
    					}
    					/*set minimal installationCost to install all towers within rectangle in DP
    					*/
    					DP[top][left][bottom][right] = installationCost;
    				}
    			}
    		}
    	}
    //return minimal installationCost of whole grid
        return DP[0][0][m-1][n-1];
	}
	public static void main(String args[])
	{
	    /*
	        You can use Console input as well with the help of Scanner or BufferedReader classes.
		Please provide input data in Input box on right side of window.
	    */
       int m = 3, n = 8;
		int[][] plot = {{1,0,0,0,0,0,1,0},
		{0,0,1,0,0,0,0,0},
		{0,0,0,0,0,1,0,0}
		};    
		
	   System.out.println(getMinimumCost(m,n,plot));
	}

}


