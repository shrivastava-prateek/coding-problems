package com.codegladiator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Finale2 {
	
	static class Edge{
		int start,end,tortoiseT,hareT;

		public Edge(int start, int end, int tortoiseT, int hareT) {
			super();
			this.start = start;
			this.end = end;
			this.tortoiseT = tortoiseT;
			this.hareT = hareT;
		}


		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", tortoiseT=" + tortoiseT + ", hareT=" + hareT + "]";
		}
		
		
		
	}
	
	static class Cycle{
		List<Edge> edges;
		int noOfNodes;
		
		public Cycle(List<Edge> edges, int noOfNodes) {
			super();
			this.edges = edges;
			this.noOfNodes = noOfNodes;
		}

		@Override
		public String toString() {
			return "Cycle [edges=" + edges + ", noOfNodes=" + noOfNodes + "]";
		}
		
		
		
	}

	public static void main(String[] args)throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
		String[] firstLine = reader.readLine().split(" ");
		//int N = Integer.parseInt(firstLine[0]);
		int M = Integer.parseInt(firstLine[1]);
		List<Edge> edges = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			String[] edgeDetails = reader.readLine().split(" ");
			int start = Integer.parseInt(edgeDetails[0]);
			int end = Integer.parseInt(edgeDetails[1]);
			int tortoiseT = Integer.parseInt(edgeDetails[2]);
			int hareT = Integer.parseInt(edgeDetails[3]);
			Edge e = new Edge(start,end,tortoiseT,hareT);
			edges.add(e);
		}
		
		Comparator<Edge> c = new Comparator<Edge>() {

			@Override
			public int compare(Edge e1, Edge e2) {
				if(e1.start < e2.start) return -1;
				else if (e1.start > e2.start) return 1;
				else {
					if(e1.end < e2.end) return -1;
					else if (e1.end > e2.end) return 1;
					else return 0;
				}
			}
			
		};
		
		Collections.sort(edges, c);
		//System.out.println(edges);
		
		List<Cycle> minCycles = calculateMinCycles(edges,M);
		System.out.println(minCycles);
		
		int margin = calculateMaxMargin(minCycles);
		
		System.out.println(minCycles.get(0).noOfNodes + " "+ margin);
		

	}
	
	static List<Cycle> calculateMinCycles(List<Edge> edges,int M) {
        List<Cycle> cycles = new ArrayList<>();
        int minNoOfEdges = 250*249;
       // int maxMargin = 0;
		for(int i =0; i<M;i++) {
			Edge edgeI = edges.get(i);
			//if(edgeI.tortoiseT >= edgeI.hareT) continue;
			List<Edge> connectedEdges = new ArrayList<Edge>();
			connectedEdges.add(edgeI);
		
			Edge prevEdge = edgeI;
			for(int j = i+1;j<M;j++) {
				Edge edgeJ = edges.get(j);
				
			
				// check for connected edges
				if (prevEdge.end != edgeJ.start) break;
				//else if(edgeI.tortoiseT >= edgeI.hareT) continue;
				else {
					
					if(edgeJ.start<edgeJ.end) {
						prevEdge = edgeJ;
						connectedEdges.add(edgeJ);
					}
					//check for cycle
					else if (edgeI.start == edgeJ.end) {
						connectedEdges.add(edgeJ);
						int noOfEdges = connectedEdges.size();
						if(noOfEdges<=minNoOfEdges) {
							minNoOfEdges = noOfEdges;
							Cycle cycle = new Cycle(connectedEdges,noOfEdges);
							List<Cycle> tempCycles = new ArrayList<>();
							tempCycles.add(cycle);
							if(calculateMaxMargin(tempCycles) > 0) cycles.add(cycle);
						}
						
					}
					else if(edgeJ.start>edgeJ.end)
					 {
						List<Edge> tempEdges = new ArrayList<>();
						for(int k =0;k<i;k++) {
							Edge edgeK = edges.get(k);
							if (edgeK.start != edgeJ.end) continue;
							else {
								//prevEdge = edgeJ;
								tempEdges.add(edgeK);
								if(edgeK.end == edgeI.start) {
									int noOfEdges = connectedEdges.size()+tempEdges.size();
									if(noOfEdges<=minNoOfEdges) {
										List<Edge> newTemp = new ArrayList<Edge>();
										newTemp.addAll(connectedEdges);
										newTemp.addAll(tempEdges);
										minNoOfEdges = noOfEdges;
										Cycle cycle = new Cycle(newTemp,noOfEdges);
										List<Cycle> tempCycles = new ArrayList<>();
										tempCycles.add(cycle);
										if(calculateMaxMargin(tempCycles) > 0) cycles.add(cycle);
									}
								}
							}
						}
					}
				 
				}
			}
		}
		
		List<Cycle> minCycles = new ArrayList<>();
		for(Cycle c : cycles) {
			if(c.noOfNodes == minNoOfEdges) minCycles.add(c);
		}
		return minCycles;
	}
	
	static int calculateMaxMargin(List<Cycle> minCycles) {
		int maxMargin = 0;
		for(Cycle c:minCycles) {
			int totalHareT = 0;
			int totalTortoiseT =0;
			List<Edge> edges = c.edges;
			for(Edge e : edges) {
				totalHareT += e.hareT;
				totalTortoiseT += e.tortoiseT;
			}
			int margin = totalHareT - totalTortoiseT;
			if (margin > maxMargin) maxMargin = margin;
		}
		return maxMargin;
	}

}
