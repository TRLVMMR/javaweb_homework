//TestOverride.java

class ParentClass
{
	public void f(int i)
	{
		System.out.println("f(int i) in ParentClass");
	}
	public void f(int i,int j)			//方法重载
	{
		System.out.println("f(int i,int j) in ParentClass");
	}
 }

public class TestOverride extends ParentClass
{
	public void f(double i)			//方法重载
	{
		System.out.println("f(double i) in TestOverride");
	}
	public void f(int i)				//方法覆盖
	{
		System.out.println("f(int i) in TestOverride");
	}
	public void print()	
	{
		f(1);						//调用类TestOverride中方法f(int i)
		f(1.1);					//调用类TestOverride中方法f(double i)
		super.f(1);				//调用类ParentClass中方法f(int i) 
		f(1,2);					//调用类ParentClass中方法f(int i,int j)
		super.f(1,2); 				//调用类ParentClass中方法f(int i,int j), super可省略
	}
	public static void main(String[] args)
	{
		TestOverride t=new TestOverride();
		t.print();
	}
}


