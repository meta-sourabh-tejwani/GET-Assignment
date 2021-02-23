import java.util.*;
import java.lang.Math;
class Poly
{
	private final int degree;
	private final int cofficient[];
	public Poly(int degree,int cofficient[])
	{
		this.degree=degree;
		this.cofficient=cofficient;
	}

	public int getDegree()
	{
		return degree;
	}
	
	
	public float evaluate(float variable)
	{
		float f=0;
		for(int i=0;i<=degree;i++)
		{
			f+=cofficient[i]*Math.pow(variable,degree-i);
		}
		return f;
	}
	
	
	public static int[] addPoly(Poly p1,Poly p2)
	{
		int sum[];
		int d1=p1.getDegree();
		int d2=p2.getDegree();
		int maxd=Math.max(d1, d2);
		sum=new int[maxd+1];
		if(d1>=d2)
		{
			int j=0,k=0;
			for(int i=d1;i>=0;i--)
			{
				if(i>d2)
					sum[k]=p1.cofficient[k];
				else
					sum[k]=p1.cofficient[k]+p2.cofficient[j++];
				k+=1;

			}
		}
		else
		{
			int j=0,k=0;
			for(int i=d2;i>=0;i--)
			{
				if(i>d1)
					sum[k]=p2.cofficient[k];
				else
					sum[k]=p2.cofficient[k]+p1.cofficient[j++];
				k+=1;
			}
		}
		return sum;
	}
	
	public static int[] mulPoly(Poly p1,Poly p2)
	{
		int d1=p1.getDegree();
		int d2=p2.getDegree();
		int total=d1+d2;
		int mul[]=new int[total+1];
		for(int i=d1;i>=0;i--)
		{
			for(int j=d2;j>=0;j--)
			{
				mul[total-(i+j)]+=p1.cofficient[d1-i]*p2.cofficient[d2-j];
			}
		}
		return mul;
	}
}

public class Question2 {
	public static void main(String...k)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter degree.....");
		int degree=sc.nextInt();
		int cofficient[]=new int[degree+1];
		for(int i=0;i<=degree;i++)
		{
			System.out.println("Enter cofficient at degree "+(degree-i));
			cofficient[i]=sc.nextInt();
		}
		Poly p1=new Poly(degree,cofficient);
		System.out.println(p1.evaluate(2));
		System.out.println("Enter degree.....");
		degree=sc.nextInt();
		cofficient=new int[degree+1];
		for(int i=0;i<=degree;i++)
		{
			System.out.println("Enter cofficient at degree "+(degree-i));
			cofficient[i]=sc.nextInt();
		}
		Poly p2=new Poly(degree,cofficient);

		int add[]=Poly.addPoly(p1, p2);
		for(int i=0;i<add.length;i++)
		{
			if(i!=add.length-1)
			{
			if(add[i]!=0)
				System.out.print(add[i]+"x^"+(add.length-i-1)+" + ");
			}
			else
				System.out.print(add[i]+"x^"+(add.length-i-1));
		}
		System.out.println();
		int mul[]=Poly.mulPoly(p1, p2);
		for(int i=0;i<mul.length;i++)
		{
			if(i!=mul.length-1)
			{
			if(mul[i]!=0)
				System.out.print(mul[i]+"x^"+(mul.length-i-1)+" + ");
			}
			else
				System.out.print(mul[i]+"x^"+(mul.length-i-1));
		}
		
	sc.close();	
	}
}