//ObjectOperation.java

class Number				
{
	int i;				
}

public class ObjectOperation
{
	public static void main(String args[])
	{
		Number n1=new Number();
		Number n2=new Number();
		n1.i=1;
		n2.i=1;
		System.out.println("n1.i="+n1.i+", n2.i="+n2.i);
		System.out.println("n1==n2:"+(n1==n2));
		System.out.println("n1!=n2:"+(n1!=n2));
		n2.i=2;
		System.out.println("\nn1.i="+n1.i+", n2.i="+n2.i);
		n1=n2;
		System.out.println("经过n1=n2运算后:");
		System.out.println("n1.i="+n1.i+", n2.i="+n2.i);
		System.out.println("n1==n2:"+(n1==n2));
		System.out.println("n1!=n2:"+(n1!=n2));
		n2.i=3;
		System.out.println("经过n2.i=3运算后:");
		System.out.println("n1.i="+n1.i+", n2.i="+n2.i);
	}
}