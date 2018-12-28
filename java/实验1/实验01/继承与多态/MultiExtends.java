//MultiExtends.java

interface  A	
{ 
	void f();
}
interface B
{
	void g();
}

class C
{
	public void h()
	{
		System.out.println("h() in C");
	}
}

class D extends C implements A,B
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
}

public class MultiExtends
{
	static void runf(A a)
	{
		a.f();
	}
	static void rung(B b)
	{
		b.g();
	}
	static void runh(C c)
	{
		c.h();
	}
	public static void main(String[] args)
	{
		D d=new D();
		runf(d);		//自动类型转换，多态
		rung(d);		//自动类型转换，多态
		runh(d);		//自动类型转换，多态
	}
}




