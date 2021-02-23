import java.util.*;
class IntSet
{
	private final int set[];
	public IntSet(int set[])
	{
		this.set=set;
	}
	
	public boolean isMember(int number)
	{
		for(int i=0;i<set.length;i++)
		{
			if(set[i] == number)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isSubSet(IntSet s)
	{
		int flag;
		for(int i=0;i<s.set.length;i++)
		{
			flag=0;
			for(int j=0;j<this.set.length;j++)
			{
				if(this.set[i] == s.set[j])
				{
					flag=1;
					break;
				}
			}
			if( flag == 0)
			{
				return false;
			}
		}
		return true;
	}

	public int[] compliment()
	{
		int []complimentSet=new int[1000-set.length];
		int j=0;
		for(int i=1;i<=1000;i++)
		{
			if(isMember(i) == false)
			{
				complimentSet[j]=i;
				j+=1;
			}
		}
		return complimentSet;
	}

	public static int[] union(IntSet s1,IntSet s2)
	{
		ArrayList<Integer> se=new ArrayList<>();
		for(int i=0;i<s1.set.length;i++)
		{
			se.add(s1.set[i]);
		}
		for(int i=0;i<s2.set.length;i++)
		{
			if( se.contains(s2.set[i]) == false )
					se.add(s2.set[i]);
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
		int compliment[]=s1.compliment();
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

