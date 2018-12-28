//ArraySort.java

import java.util.*;

class A  implements Comparable
{
	int i,j;
	public A(int a1,int a2)
	{
		i=a1;
		j=a2;
	}
	public int compareTo(Object obj)
	{
		int k=((A)obj).i;
		if(k>i)
			return -1;
		else if(k<i)
			return 1;
		else 
			return 0;
	}
	public String toString()
	{
		return "("+i+","+j+")";
	}
}

public class ArraySort
{
	public static void main(String[] args)
	{
		int[] a1={5,2,6,4,3,8,1,7};
		System.out.println("排序前:"+Arrays.toString(a1));
		Arrays.sort(a1,0,3);
		System.out.println("位置0~2的元素排序后:"+Arrays.toString(a1));
		Arrays.sort(a1);
		System.out.println("全部排序后:"+Arrays.toString(a1));
		
		A[] a2={new A(5,2),new A(2,3),new A(3,1)};
		System.out.println("排序前:"+Arrays.toString(a2));
		Arrays.sort(a2);
		System.out.println("排序后:"+Arrays.toString(a2));
	}
}

