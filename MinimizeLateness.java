import java.util.*;

class Job implements Comparable<Job>{
	public String name;
	public int processingTime;
	public int deadline;
	public int start;
	public int finish;

	public Job(String name, int processingTime, int deadline){
		this.name=name;
		this.processingTime=processingTime;
		this.deadline=deadline;
	}
	
	@Override				//Compare based on earliest deadline
	public int compareTo(Job job) {
		return this.deadline - job.deadline;
	}
	
	@Override
	public String toString(){
		return "[Job " + name + ":  Processing Time="+processingTime + ", due="+deadline + ",   (start="+start + ", finish="+finish + ")]";
	}
}

public class MinimizeLateness {
	public static void  findMinLateness(Job[] jobs){
		Arrays.sort(jobs);		//Sort by earliest deadline

		int currentIntervalEndTime = 0;
		for(Job job : jobs){
			job.start = currentIntervalEndTime;
			job.finish = currentIntervalEndTime + job.processingTime;
			currentIntervalEndTime += job.processingTime;
		}

		//Loop over jobs to find any that are late and find the maximum lateness value
		int maxLateness=0;
		String maxLateJob = "";		//Initialize to empty string in case no job is late
		for(Job job : jobs){
			int lateness = job.finish - job.deadline;	//Calculate lateness. Negative means it's NOT late
			if(lateness > maxLateness){
				maxLateness = lateness;
				maxLateJob = job.name;
			}
		}

		System.out.print("Max Lateness = " + maxLateness);
		if(!maxLateJob.equals("")){				//Only printed if a job was found. Skipped if no jobs are late
			System.out.print("  From Job " + maxLateJob);
		}
		System.out.println("\nJob Assignment Order");
		for(Job job : jobs){
			System.out.println(job);
		}
	}
	
	
	public static void main(String[] args) {
		Job[] jobs = {
				new Job("1", 3, 6),
				new Job("2", 3, 14),
				new Job("3", 1, 9),
				new Job("4", 4, 9),
				new Job("5", 2, 8),
				new Job("6", 2, 15),
		};
		MinimizeLateness.findMinLateness(jobs);
	}
}