import java.util.Scanner;

class JobScheduler
{
	private int completionTime[];
	private int waitingTime[];
	private int turnAroundTime[];
	private int averageWaitingTime;
	private int maxWaitingTime=0;
	JobScheduler(int process[][])
	{
		//Completion Time
		int totalprocess=process.length;
		completionTime=new int[totalprocess];
		completionTime[0]=process[0][1];
		for(int i=1;i<process.length;i++)
		{
			if(completionTime[i-1]<=process[i][0])
			{
				completionTime[i]=process[i][1]+process[i][0];
			}
			else
			{
				completionTime[i]=completionTime[i-1]+process[i][1];
			}
		}
		
		//TimeAround
		turnAroundTime=new int[totalprocess];
		for(int i=0;i<totalprocess;i++)
		{
			turnAroundTime[i]=completionTime[i]-process[i][1];
		}
		//Waiting Time
		waitingTime=new int[totalprocess];
		int total=0;
		for(int i=0;i<totalprocess;i++)
		{
			waitingTime[i]=turnAroundTime[i]-process[i][0];
			total+=waitingTime[i];
			if(waitingTime[i]>maxWaitingTime)
			{
				maxWaitingTime=waitingTime[i];
			}
		}
		averageWaitingTime=total/totalprocess;
	}
	
	public int[] returncompleteTime()
	{
		return completionTime;
	}
	
	public int[] returnwaitingTime()
	{
		return waitingTime;
	}
	
	public int[] returnAroundTime()
	{
		return turnAroundTime;
	}
	public int maxWaitedTime()
	{
		return maxWaitingTime;
	}
	public int avgWaitingTime()
	{
		return averageWaitingTime;
	}
	
}

public class QuestionSecond {
	public static void main(String...k)
	{
		int process[][];
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter how much process You have");
		int n=sc.nextInt();
		process=new int[n][2];
		System.out.println("Enter Arriving Time and BurstTime");
		for(int i=0;i<n;i++)
		{
			process[i][0]=sc.nextInt();
			process[i][1]=sc.nextInt();
		}
		JobScheduler job=new JobScheduler(process);
		int waiting[]=job.returnwaitingTime();
		for(int i=0;i<n;i++)
		{
			System.out.println("P"+(i+1)+" waiting Time "+waiting[i]);
		}
		int TurnAround[]=job.returnAroundTime();
		for(int i=0;i<n;i++)
		{
			System.out.println("P"+(i+1)+" Around Time "+TurnAround[i]);
		}int completion[]=job.returncompleteTime();
		for(int i=0;i<n;i++)
		{
			System.out.println("P"+(i+1)+" Completion Time " +completion[i]);
		}
		System.out.println("Maimum Waiting Time "+job.maxWaitedTime());
		System.out.println("Average Waiting Time "+job.avgWaitingTime());
		
		sc.close();	
	}
}
