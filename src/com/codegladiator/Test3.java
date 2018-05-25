package com.codegladiator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Test3 {

	public static int max = 1,time=0;
	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine());

		String[] strLength = reader.readLine().split(" ");
		String[] strTime = reader.readLine().split(" ");

		int arrivalTime[] = new int[N];
		int exitTime[] = new int[N];


		for(int i = 0; i<N;i++){
			arrivalTime[i] = Integer.parseInt(strTime[i]);
			exitTime[i] = arrivalTime[i] +  Integer.parseInt(strLength[i]);
		}

		findMaxSalmons(arrivalTime, exitTime, N);

		System.out.println(max);

	}

	public static void findMaxSalmons(int[] arrivalTime,int[] exitTime,int N) {
		List<Integer> startList  = new ArrayList<Integer>();
		int arrivalTimeCopy2[];
		int exitTimeCopy2[];
		int count = 0,k = 0;
		for(int i = 0 ; i < N;i++){
			
			List<Integer> arrivalTimeCopy = new ArrayList<Integer>();
			List<Integer> exitTimeCopy = new ArrayList<Integer>();
			if(!startList.contains(arrivalTime[i])){
				count = 1;
				k = 0;
				startList.add(arrivalTime[i]);
				for(int j = 0 ; j <N ;j++ ){

					if( j != i){
						if(arrivalTime[j]<= arrivalTime[i] && exitTime[j] >= arrivalTime[i]){
							count++;
						}
						else{
							arrivalTimeCopy.add(arrivalTime[j]);
							exitTimeCopy.add(exitTime[j]);
						}
					}

				}
				int size = arrivalTimeCopy.size();
				if(size>0){
					arrivalTimeCopy2 = new int[size];
					exitTimeCopy2 = new int[size];
					for(int l = 0 ;l<size;l++){
						arrivalTimeCopy2[l] = arrivalTimeCopy.get(l);
						exitTimeCopy2[l] = exitTimeCopy.get(l);
					}
					count += findMaxSal(arrivalTimeCopy2,exitTimeCopy2,size);
				}


				if(count >= max ){
					max = count;
				}
			}

		}
	}
	
	
	static int findMaxSal(int arrivalTime[], int exitTime[], int N)    
	{   
		Arrays.sort(arrivalTime);
		Arrays.sort(exitTime);


		int salmon_in = 1, max_salmon = 1;// time = arrivalTime[0];
		int i = 1, j = 0;


		while (i < N && j < N)
		{

			if (arrivalTime[i] <= exitTime[j])
			{
				salmon_in++;


				if (salmon_in > max_salmon)
				{
					max_salmon = salmon_in;
				}
				i++; 
			}
			else 
			{ 
				salmon_in--;
				j++;
			}
		}

		return max_salmon;
	}
}
