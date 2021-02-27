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
		
		//TurnAround Time
		turnAroundTime=new int[totalprocess];
		for(int i=0;i<totalprocess;i++)
		{
			turnAroundTime[i]=completionTime[i]-process[i][1];
		}
		//Waiting Time
		waitingTime=new int[totalprocess];
		int total=0;
		for(int i=1;i<totalprocess;i++)
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
	
	//Return completion Time
	public int getCompletionTime(int index)
	{
		return completionTime[index];
	}
	
	//return Waiting Time
	public int getWaitingTime(int index)
	{
		return waitingTime[index];
	}
	
	//Return TurnAround Time
	public int getTurnAroundTime(int index)
	{
		return turnAroundTime[index];
	}
	//Return Maximum Waited Time
	public int getMaxWaitedTime()
	{
		return maxWaitingTime;
	}
	
	//Return Average waited Time
	public int getAverageWaitingTime()
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
		String processor=String.format("%18s","Process");
		String arriving=String.format("%18s","Arriving Time");
		String bursttime=String.format("%18s","Burst Time");
		String completiontime=String.format("%18s","Completion Time");
		String waitingtime=String.format("%18s","Waiting Time");
		String turnaroundtime=String.format("%18s","TurnAround Time");
		System.out.println(processor+arriving+bursttime+completiontime+waitingtime+turnaroundtime);
		for(int i=0;i<n;i++)
		{

			processor=String.format("%16s","P"+(i+1));
			arriving=String.format("%16s",process[i][0]);
			bursttime=String.format("%16s",process[i][1]);
			completiontime=String.format("%16s",job.getCompletionTime(i));
			waitingtime=String.format("%16s",job.getWaitingTime(i));
			turnaroundtime=String.format("%16s",job.getTurnAroundTime(i));
			System.out.println(processor+arriving+bursttime+completiontime+waitingtime+turnaroundtime);
		}
		
		System.out.println("Maimum Waiting Time "+job.getMaxWaitedTime());
		System.out.println("Average Waiting Time "+job.getAverageWaitingTime());
		
		sc.close();	
	}
}
