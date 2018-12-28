//InitArray .java

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
public class InitArray
{
	public static void main(String[] args)
	{
		int[]  b={1,2,3};
		double[] d=new double[]{1.2,2.4,};
		A[] a1={new A(1),new A(2),};
		A[] a2;
		a2=new A[]{new A(2),new A(4),new A(6),};
		
		for(int i=0;i<b.length;i++)
			System.out.print("  b["+i+"]="+b[i]);
		System.out.println();
		for(int i=0;i<d.length;i++)
			System.out.print("  d["+i+"]="+d[i]);
		System.out.println();
		for(int i=0;i<a1.length;i++)
			System.out.print("  a1["+i+"].i="+a1[i].getI());
		System.out.println();
		for(int i=0;i<a2.length;i++)
			System.out.print("  a2["+i+"].i="+a2[i].getI());
		System.out.println();
	}
}



