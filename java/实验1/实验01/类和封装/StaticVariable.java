//StaticVariable.java

class A
{
	static int i=10;
}

class B
{
	static int i=20;
}

public class StaticVariable
{
	public static void main(String args[])
	{
		System.out.println("A.i="+A.i);
		B b1=new B();
		B b2=new B();
		B.i++;
		b1.i++;
		System.out.println("B.i="+B.i);
		System.out.println("b1.i="+b1.i);
		System.out.println("b2.i="+b2.i);
	}
}
