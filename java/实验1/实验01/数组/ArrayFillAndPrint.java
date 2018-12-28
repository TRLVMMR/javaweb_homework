//ArrayFillAndPrint.java

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
	public String toString()
	{
		return Integer.toString(i);
	}
}

public class ArrayFillAndPrint
{
	public static void main(String[] args)
	{
		int[] a1=new int[10];
		Arrays.fill(a1,1);
		System.out.println("a1="+Arrays.toString(a1));
		Arrays.fill(a1,0,a1.length/2,10);
		System.out.println("a1="+Arrays.toString(a1));
	
		A[] a2=new A[2];
		Arrays.fill(a2,new A(2));
		System.out.println("a2="+Arrays.toString(a2));
		
		B[] a3=new B[5];
		Arrays.fill(a3,new B(3));
		System.out.println("a3="+Arrays.toString(a3));
		a3[0].i=30;
		System.out.println("a3="+Arrays.toString(a3));
		
		int[][] a4=new int[2][];
		Arrays.fill(a4,new int[]{4,4,4});
		System.out.println("a4="+Arrays.toString(a4));
		System.out.println("a4="+Arrays.deepToString(a4));
		a4[0][0]=40;
		System.out.println("a4="+Arrays.deepToString(a4));
		
		B[][] a5=new B[2][];
		Arrays.fill(a5,new B[]{new B(5),new B(50)});
		System.out.println("a5="+Arrays.toString(a5));
		System.out.println("a5="+Arrays.deepToString(a5));
	}
}

