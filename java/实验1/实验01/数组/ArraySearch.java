//ArraySearch.java

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

public class ArraySearch
{
	public static void main(String[] args)
	{
		int loc;
		int[] a1={5,2,6,4,3,8,1,7};
		Arrays.sort(a1);
		System.out.println("a1="+Arrays.toString(a1));
		int i=6,j=10;
		loc=Arrays.binarySearch(a1,i);
		if(loc>=0)
			System.out.println("a1["+loc+"]="+i);
		else
			System.out.println("Ã»ÓÐÔÚÊý×éÖÐÕÒµ½"+i);
		loc=Arrays.binarySearch(a1,j);
		if(loc>=0)
			System.out.println("a1["+loc+"]="+j);
		else
			System.out.println("Ã»ÓÐÔÚÊý×éÖÐÕÒµ½"+j);	
		
		A[] a2={new A(5,2),new A(2,3),new A(3,1)};
		Arrays.sort(a2);
		System.out.println("a2="+Arrays.toString(a2));
		A  aobj1=new A(3,1);
		A  aobj2=new A(4,2);
		loc=Arrays.binarySearch(a2,aobj1);
		if(loc>=0)
			System.out.println("a2["+loc+"]="+aobj1);
		else
			System.out.println("Ã»ÓÐÔÚÊý×éÖÐÕÒµ½"+aobj1);
		loc=Arrays.binarySearch(a2,aobj2);
		if(loc>=0)
			System.out.println("a2["+loc+"]="+aobj2);
		else
			System.out.println("Ã»ÓÐÔÚÊý×éÖÐÕÒµ½"+aobj2);
	}
}

