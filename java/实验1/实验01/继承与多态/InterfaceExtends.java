//InterfaceExtends.java

interface A			
{
	 void f();
}

interface B
{
	void g();
}

interface C extends A
{
	void h();
}

interface D extends B,C
{
	void i();
}

class E implements  D
{
	public void f()
	{
		System.out.println("f() in D");
	}
	
	public void g()
	{
		System.out.println("g() in D");
	}	
	public void h()
	{
		System.out.println("h() in D");
	}
	public void i()
	{
		System.out.println("i() in D");
	}
}

public class InterfaceExtends
{
	public static void runf(A a)
	{
		a.f();
	}
	public static void rung(B b)
	{
		b.g();
	}
	public static void runh(C c)
	{
		c.h();
	}
	public static void runi(D d)
	{
		d.i();
	}
	public static void main(String[] args)
	{
		E e=new E();
		runf(e);
		rung(e);
		runh(e);
		runi(e);
	}
}
