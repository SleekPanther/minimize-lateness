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
		return "[" + name + ": " + processingTime + " due="+deadline + "]";
	}
}

public class MinimizeLateness {
	public static void  findMinLateness(Job[] jobs){
		System.out.println(Arrays.toString(jobs));
		Arrays.sort(jobs);
		System.out.println(Arrays.toString(jobs));
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