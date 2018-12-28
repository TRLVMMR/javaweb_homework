//ObjectArray.java

class A
{
	private int i;
	public A(int a)
	{
		i=a;
	}
	public int getI()
	{
		return i;
	}
}
public class ObjectArray
{
	public static void main(String[] args)
	{
		A[] a=new A[3];
		System.out.println("  a.length="+a.length);
		for(int i=0;i<a.length;i++)
			System.out.print("  a["+i+"]="+a[i]);
		System.out.println();
		for(int i=0;i<a.length;i++)
			a[i]=new A(2*i);
		for(int i=0;i<a.length;i++)
			System.out.print("  a["+i+"].i="+a[i].getI());
		System.out.println();
	}
}



