package com.techgig.codegladiator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Test2 {

	static class Tree{
		int xi,yi,mi,ti,index;
        List<Tree> connected,disconnected;
        Tree next;
		public Tree(int xi, int yi, int mi, int ti, int index) {
			super();
			this.xi = xi;
			this.yi = yi;
			this.mi = mi;
			this.ti = ti;
			this.index = index;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + mi;
			result = prime * result + ti;
			result = prime * result + xi;
			result = prime * result + yi;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tree other = (Tree) obj;
			if (index != other.index)
				return false;
			if (mi != other.mi)
				return false;
			if (ti != other.ti)
				return false;
			if (xi != other.xi)
				return false;
			if (yi != other.yi)
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "Tree [xi=" + xi + ", yi=" + yi + ", mi=" + mi + ", ti=" + ti + ", index=" + index + "]";
		}
		
	}

	public static void main(String[] args) throws Exception {
		  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		  String[] strArr = reader.readLine().split(" ");
	        int N = Integer.parseInt(strArr[0]);
	        double C = Double.parseDouble(strArr[1]);
	        
	        List<Tree> trees = new ArrayList<Tree>();
	        int countThreshold = 0;
	        for(int i = 0;i<N;i++) {
	        	strArr  = reader.readLine().split(" ");
	        	int xi = Integer.parseInt(strArr[0]);
	        	int yi = Integer.parseInt(strArr[1]);
	        	int mi = Integer.parseInt(strArr[2]);
	        	int ti = Integer.parseInt(strArr[3]);
	        	if (mi > ti) countThreshold++;
	        	Tree t = new Tree(xi,yi,mi,ti,i);
	        	trees.add(t);
	        }
	        boolean print = false;
	        if (countThreshold == 2) {
	        	System.out.println("-1");
	        	print = true;
	        }
	        
	        List<Tree> meetTrees = new ArrayList<>();
	        
	        for(Tree t : trees) {
	       List<Tree> duplicateList = new ArrayList<>();
	        	for (Tree temp:trees) {
	        		Tree temp2 = new Tree(temp.xi,temp.yi,temp.mi,temp.ti,temp.index);
	        		duplicateList.add(temp2);
	        	}
	        	Tree duplicateTree = new Tree (t.xi,t.yi,t.mi,t.ti,t.index);
	        	//System.out.println(duplicateList);
	        	if(isAMeetTree(duplicateTree,duplicateList,C)) {
	        		meetTrees.add(t);
	        	}
	        	
	        }
	        
	        if (meetTrees.size() > 0) {
	        	Comparator<Tree> c = new Comparator<Tree>() {

					@Override
					public int compare(Tree t1, Tree t2) {
						if (t1.index < t2.index) return -1;
						else if (t1.index > t2.index) return 1;
						else return 0;
					}
		        };
		        
		        Collections.sort(meetTrees, c);
		        String result = "";
		        for (Tree t : meetTrees) {
		        	result = result + t.index+" ";
		        }
		        System.out.println(result.trim());
	        }
	        else if (!print)System.out.println("-1");

	}
	
	public static boolean isAMeetTree(Tree tree,List<Tree> trees, double C) {
		List<Tree> connected = new ArrayList<>();
		List<Tree> disconnected = new ArrayList<>();
        trees.remove(tree);
		for (Tree tr : trees) {
			int x = tree.xi;
			int y = tree.yi;
			int xi = tr.xi;
			int yi = tr.yi;
			int ti = tr.ti;
			int mi = tr.mi;
			
			if (tr.equals(tree)) continue;
			if (mi > ti) {
				disconnected = null;
				connected = null;
				return false;
			}
			
			double distance = Math.sqrt((x-xi)*(x-xi)+(y-yi)*(y-yi));
			//System.out.println("distance" + distance);
			if (C < distance) {
				disconnected.add(tr);
			}
			else {
				if (tree.next != null) {
					if(tree.ti>= tr.mi+tree.mi) {
						
						tr.ti = tr.ti-tr.mi;
						tree.mi = tree.mi+tr.mi;
						tr.mi = 0;
						tr.next = tree;
						connected.add(tr);
						assignWeights(tree.next, tree);
					}
					else {
						 tr.mi= tr.mi-(tree.ti-tree.mi);
						 tr.ti = tr.ti-(tree.ti-tree.mi);
						 tree.mi = tree.ti;
						 assignWeights(tree.next, tree);
					}
					
				}
				else {
					//System.out.println("check in tree.next is null");
					
					tr.ti = tr.ti-tr.mi;
					tree.mi = tree.mi+tr.mi;
					tr.mi = 0;
					tr.next = tree;
					connected.add(tr);
				}
				
			}
		}
		
		// continue here for disconnected
		trees.removeAll(connected);
		//if (trees.size() == 0) return true;
		if (connected.size()>0)tree.connected = connected;
		if (disconnected.size()>0)tree.disconnected = disconnected;
	
		for (Tree connectedTree : connected) {
		    isAMeetTree(connectedTree,trees,C);
			Tree parent = connectedTree.next;
			Tree child = connectedTree;
			while(parent != null) {
				assignWeights(parent, child);
				child = parent;
				parent = child.next;
			}
			
			if (connectedTree.mi == 0) {
				if (connectedTree.ti == 0)continue;
				else isAMeetTree(connectedTree, trees, C);
				
			}
			else if (connectedTree.ti == 0 && connectedTree.mi > 0) return false;
			else if (connectedTree.ti < connectedTree.mi) return false;
			else trees.add(connectedTree);
		}
		
		return (trees.size()==0);
	}
	public static void assignWeights(Tree tree, Tree tr) {
		if (tree.next != null) {
			if(tree.ti>= tr.mi+tree.mi) {
				tr.ti = tr.ti-tr.mi;
				tree.mi = tree.mi+tr.mi;
				tr.mi = 0;
				tr.next = tree;
				
			}
			else {
				 tr.mi= tr.mi-(tree.ti-tree.mi);
				 tr.ti = tr.ti-(tree.ti-tree.mi);
				 tree.mi = tree.ti;
			}
			
		}
		else {
			
			tr.ti = tr.ti-tr.mi;
			tree.mi = tree.mi+tr.mi;
			tr.mi = 0;
			tr.next = tree;
			
		}
	}

}
