import java.util.*;
final class IntSet
{
	private int count=0;
	private final int set[];
	public IntSet(int set[])
	{
		this.set=new int[1001];
		for(int i=0;i<set.length;i++)
		{
			if(set[i]>=1 && set[i]<=1000)
			{
				count++;
				this.set[set[i]]=1;
			}
		}
	}
	/*Accept int number and check it is member of set or not*/
	public boolean isMember(int number)
	{
		if(number>=1 && number<=1000)
		{
			if(set[number]==1)
			{
				return true;
			}
		}
		return false;
	}
	/*Accept Subset and check is subset or not*/
	public boolean isSubSet(IntSet s)
	{
		for(int i=0;i<s.set.length;i++)
		{
			if(set[s.set[i]]==1)
			{
				return true;
			}
		}
		return false;
	}

	/*return compliment of set*/
	public int[] getComplement()
	{
		int []complementSet=new int[1000-count];
		int j=0;
		for(int i=1;i<=1000;i++)
		{
			if(isMember(i) == false)
			{
				complementSet[j]=i;
				j+=1;
			}
		}
		return complementSet;
	}

	/* Return union of two sets*/
	public static int[] union(IntSet s1,IntSet s2)
	{
		ArrayList<Integer> se=new ArrayList<>();
		for(int i=1;i<=1000;i++)
		{
			if(s1.isMember(i) == true || s2.isMember(i) == true)
			{
				se.add(i);
			}
		}
		int union[]=new int[se.size()];
		Collections.sort(se);
		int i=0;
		for(int num:se)
		{
			union[i++]=num;
		}
		return union;
	}
}


public class Question1 {
	public static void main(String...k)
	{
		int a[]={1,2,3,4,5};
		IntSet s1 = new IntSet(a);
		int b[]={1,2,3,11,12,67,1000,12,23,545};
		IntSet s2= new IntSet(b);
		System.out.println(s1.isMember(20));
		System.out.println(s1.isMember(4));
		System.out.println(s1.isSubSet(s2));
		int compliment[]=s1.getComplement();
		for(int i=0;i<compliment.length;i++)
		{
			System.out.print(compliment[i]+" ");
		}
		System.out.println();
		int union[]=IntSet.union(s1, s2);
		for(int i=0;i<union.length;i++)
		{
			System.out.print(union[i]+" ");
		}
	}
}

