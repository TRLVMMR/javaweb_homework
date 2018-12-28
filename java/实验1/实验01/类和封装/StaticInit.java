//StaticInit.java

class Cat				
{	
	Cat(int i)
	{
		System.out.println("Cat("+i+")");
	}
	void f(int i)
	{
		System.out.println("f("+i+")");
	}
}
 
class Cats
{
	static Cat c1;
	static Cat c2;
	static
	{
		c1=new Cat(1);
		c2=new Cat(2);
	}
	Cats()
	{
		System.out.println("Cats()");
	}
}

public class StaticInit
{
	public static void main(String args[])
	{
		System.out.println("main()");
		Cats.c1.f(7);
	}
//	static Cats c=new Cats();	
}