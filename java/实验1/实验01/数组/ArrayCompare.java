//ArrayCompare.java

import java.util.*;

class A
{
	int i;
	public A(int a)
	{
		i=a;
	}
}
		


class B
{
	int i;
	public B(int b)
	{
		i=b;
	}
	public boolean equals(Object obj)
	{
		
		if(obj instanceof B)
			return ((B)obj).i==i; 
		return false;
	}
}

public class ArrayCompare
{
	public static void main(String[] args)
	{
		int[] a1=new int[10];
		int[] a2=new int[10];
		Arrays.fill(a1,1);
		Arrays.fill(a2,1);
		System.out.println(Arrays.equals(a1,a2));
		a1[0]=2;
		System.out.println(Arrays.equals(a1,a2));
		
		A[] a3=new A[5];
		A[] a4=new A[5];
		Arrays.fill(a3,new A(3));
		Arrays.fill(a4,new A(3));
		System.out.println(Arrays.equals(a3,a4));
		
		B[] a5=new B[5];
		B[] a6=new B[5];
		Arrays.fill(a5,new B(5));
		Arrays.fill(a6,new B(5));
		System.out.println(Arrays.equals(a5,a6));
		a5[0].i=6;
		System.out.println(Arrays.equals(a5,a6));
		
		int[][] a7=new int[2][3];
		Arrays.fill(a7,new int[]{7,7,7});
		int[][] a8=new int[2][3];
		Arrays.fill(a8,new int[]{7,7,7});
		System.out.println(Arrays.equals(a7,a8));
		System.out.println(Arrays.deepEquals(a7,a8));
	}
}

