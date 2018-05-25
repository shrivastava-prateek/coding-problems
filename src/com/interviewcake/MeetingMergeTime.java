package com.interviewcake;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingMergeTime {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Meeting> meetings = new ArrayList<Meeting>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i<N;i++) {
			String[] strArr= br.readLine().split(" ");
			Meeting m = new Meeting(Integer.parseInt(strArr[0]),Integer.parseInt(strArr[1]));
			meetings.add(m);
		}
		Collections.sort(meetings);
		System.out.println(meetings);
		List<Meeting> m = mergeMeetings(meetings, N);
		System.out.println(m);
		//System.out.println("The End");
		br.close();
		//System.exit(0);
	
	}

	public static List<Meeting> mergeMeetings(List<Meeting> meetings,int N){
		int k=0;
		List<Meeting> mergedMeetings = new ArrayList<Meeting>();
		for (int i = 0;i<N;i++) {
			k=i;
			Meeting mi = meetings.get(i);
			int newStartTime= mi.startTime,newEndTime=mi.endTime;
			for (int j = i+1;j<N;j++) {
				Meeting mj = meetings.get(j);
				if(mi.isOverlap(mj)) {
					int newStartTime2 = mi.startTime<mj.startTime?mi.startTime:mj.startTime;
					int newEndTime2 = mi.endTime>mj.endTime?mi.endTime:mj.endTime;
					if(newStartTime2< newStartTime) newStartTime = newStartTime2;
					if(newEndTime2> newEndTime) newEndTime = newEndTime2;	
					k=j;
				}
			}
			mergedMeetings.add(new Meeting(newStartTime,newEndTime));
			//System.out.println(k);
			i=k;
		}
		return mergedMeetings;
	}
	
	  static class Meeting implements Comparable<Meeting> {

		

			private int startTime;
		    private int endTime;

		    public Meeting(int startTime, int endTime) {
		        // number of 30 min blocks past 9:00 am
		        this.startTime = startTime;
		        this.endTime   = endTime;
		    }

		    public int getStartTime() {
		        return startTime;
		    }

		    public void setStartTime(int startTime) {
		        this.startTime = startTime;
		    }

		    public int getEndTime() {
		        return endTime;
		    }

		    public void setEndTime(int endTime) {
		        this.endTime = endTime;
		    }
		    
		    public boolean isOverlap(Meeting m) {
		    	if (m.startTime >= this.startTime && m.startTime <= this.endTime)return true;
		    	else return false;
		    }

			@Override
			public int compareTo(Meeting m) {
				if (this.startTime < m.startTime) return -1;
				else if(this.startTime > m.startTime) return 1;
				else return 0;
			}
			
		    @Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + endTime;
				result = prime * result + startTime;
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
				Meeting other = (Meeting) obj;
				if (endTime != other.endTime)
					return false;
				if (startTime != other.startTime)
					return false;
				return true;
			}

			@Override
			public String toString() {
				return "Meeting [startTime=" + startTime + ", endTime=" + endTime + "]";
			}
		}
}
