package com.psl.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;



public class NetworkInstallation {

	static Set<Integer> costs= new TreeSet<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n= sc.nextInt();
		int[][] plot = new int[m][n];
		for (int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				plot[i][j] = sc.nextInt();
			}
			}
		sc.close();
		System.out.println(getMinimumCost(m,n,plot));
		}
		
	
	public static int getMinimumCost(int m,int n,int[][] plot){
		
		List<Coordinates> elements = new ArrayList<Coordinates>();
		
		for (int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(plot[i][j] == 1){
				elements.add(new Coordinates(i, j));
			}
			}
		}
		permute(elements, 0, elements.size()-1);
		
		return (Integer.valueOf(costs.toArray()[0].toString()));
	}
	
	public static void permute(List<Coordinates> elements,int l,int r){
		if(l==r){
	
	        int totalCost = 0;        
			int last=elements.size()-1;
			while(last>=0){
			Coordinates lastTower = elements.get(last);
			int xLast = lastTower.getX();
			int yLast = lastTower.getY();
			
			int cost=0;
			for(int i =0;i<=last;i++){
				Coordinates tower = elements.get(i);
				int x1= Math.abs(tower.getX()-xLast);
				int y1=Math.abs(tower.getY()-yLast);
				int cost1 = Math.max(x1, y1);
				if(cost<cost1){
					cost=cost1;
				}
				
			}
			totalCost = totalCost + cost;
			last--;
			
		}
			
			costs.add(totalCost);
		}
		else{
			for (int i = l; i <= r; i++)
            {
                elements = swap(elements,l,i);
                permute(elements, l+1, r);
                elements = swap(elements,l,i);
            }
		}
		
		
	}
	
	public static List<Coordinates> swap(List<Coordinates> elements,int i,int j){
		Coordinates temp;
		Coordinates temp2;
		temp = elements.get(i);
		temp2= elements.get(j);
		elements.set(i,temp2);
		elements.set(j, temp);
		
		return elements;
	}
}




class Coordinates{
	private int x;
	private int y;
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Coordinates(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Coordinates [x=" + x + ", y=" + y + "]";
	}
	
	
	
}
