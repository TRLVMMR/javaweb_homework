//ChildClass.java

class ParentClass
{
	protected int i=50;
	public void f()
	{
		System.out.println("f() in ParentClass");
	}
 }

public class ChildClass extends ParentClass
{
	private int i=100;
	public void print()	
	{
		f();
		super.f();			//省略关键字super，访问的是同一个方法。
		System.out.println("super.i="+super.i+"\ti="+i);	//关键字super不可省略
	}
	
	public static void main(String[] args)
	{
		ChildClass c=new ChildClass();
		c.print();
	}
}

