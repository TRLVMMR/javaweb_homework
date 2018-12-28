//ArrayCopy.java

import java.util.*;

class A
{
	int i;
	public A(int a)
	{
		i=a;
	}
	public String toString()
	{
		return Integer.toString(i);
	}
}
public class ArrayCopy
{
	public static void main(String[] args)
	{
		int[] a1=new int[10];
		int[] a2=new int[a1.length];
		Arrays.fill(a1,1);
		Arrays.fill(a2,2);
		System.out.println("a1="+Arrays.toString(a1));
		System.out.println("a2="+Arrays.toString(a2));
		System.arraycopy(a1,0,a2,0,a1.length);
		System.out.println("a2="+Arrays.toString(a2));
		a1[1]=10;
		System.out.println("a1="+Arrays.toString(a1));
		System.out.println("a2="+Arrays.toString(a2));
		
		
		A[] a3=new A[10];
		A[] a4=new A[5];
		Arrays.fill(a3,new A(3));
		Arrays.fill(a4,new A(4));
		System.out.println("a3="+Arrays.toString(a3));
		System.out.println("a4="+Arrays.toString(a4));
		System.arraycopy(a3,0,a4,0,a4.length);
		System.out.println("a4="+Arrays.toString(a4));
		a3[0].i=30;
		System.out.println("a3="+Arrays.toString(a3));
		System.out.println("a4="+Arrays.toString(a4));

		int[][] a5=new int[2][3];
		int[][] a6=new int[2][3];
		Arrays.fill(a5,new int[]{5,5,5});
		Arrays.fill(a6,new int[]{6,6,6});
		System.out.println("a5="+Arrays.deepToString(a5));
		System.out.println("a6="+Arrays.deepToString(a6));
		System.arraycopy(a5,0,a6,0,a5.length);
		System.out.println("a6="+Arrays.deepToString(a6));
		a5[0][0]=50;
		System.out.println("a5="+Arrays.deepToString(a5));
		System.out.println("a6="+Arrays.deepToString(a6));
	}
}

