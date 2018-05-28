package com.interviewcake;

import java.util.Arrays;
import java.util.Comparator;

public class CakeThief {

	public static void main(String[] args) {
		  CakeType[] cakeTypes = new CakeType[] { 
				    new CakeType(7, 160),
				    new CakeType(3, 90),
				    new CakeType(2, 15),
				};

				int capacity = 20;

				Comparator<CakeType> c = new Comparator<CakeType>() {

					@Override
					public int compare(CakeType c1, CakeType c2) {
						double c1perKg = c1.value/c1.weight;
						double c2perKg = c2.value/c2.weight;
						
						if (c1perKg > c2perKg) return -1;
						else if (c1perKg < c2perKg) return 1;
						else return 0;
					}
					
				};
				
				Arrays.sort(cakeTypes, c);
				for (CakeType cake: cakeTypes) {
					System.out.println(cake);
				}
				
				System.out.println(maxDuffelBagValue(cakeTypes, capacity));

	}

	public static int maxDuffelBagValue(CakeType[] cakeTypes,int capacity) {
		int allowedCapacity= capacity;
		int totalost = 0;
		for (int i=0;i<cakeTypes.length;i++) {
			if(allowedCapacity < cakeTypes[i].weight || cakeTypes[i].weight == 0) continue;
			else {
				totalost = totalost + cakeTypes[i].value;
				allowedCapacity = allowedCapacity - cakeTypes[i].weight;
				i = i-1;
			}
		}
		return totalost;
	}
	 static class CakeType {

		    int weight;
		    int value;

		    public CakeType(int weight, int value) {
		        this.weight = weight;
		        this.value  = value;
		    }

			@Override
			public String toString() {
				return "CakeType [weight=" + weight + ", value=" + value + "]";
			}
		    
		    
		}
}
