//ObjectComparable.java

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
		int k=((A)obj).j;
		if(k>j)
			return -1;
		else if(k<j)
			return 1;
		else 
			return 0;
	}
	public String toString()
	{
		return "("+i+","+j+")";
	}
}

public class ObjectComparable 
{
	public static void main(String[] args)
	{
		A a1=new A(2,4);
		A a2=new A(5,3);
		if(a1.compareTo(a2)>0)
			System.out.println(a1+">"+a2);
		else if(a1.compareTo(a2)<0)
			System.out.println(a1+"<"+a2);
		else 
			System.out.println(a1+"=="+a2);	
	}
}



