//TestInnerClass.java 

class A
{
	private int i=10;
	public int getI()
	{
		return i;
	}
}

class OuterClass
{
	private int j=5,k=6;
	
	private class InnerClass1 extends A		//内部类可以声明为private或protected
	{	
		public void g()
		{
			System.out.println("调用私有内部类的方法g()");
		}
	}
	
	class InnerClass2	
	{
		private int m;
		InnerClass2(int n)
		{
			m=n;			
		}
		public void h()
		{
			f1();		//内部类中可以直接访问外部类的方法
			j++;		//内部类中可以直接访问外部类的数据成员
			k++;
			System.out.println("j="+j+"\tk="+k+"\tm="+m+"\tin InnerClass2");
		}
	}
	
	static class M{}			//内部类可以声明为static
	
	public void f1()
	{
		System.out.println("j="+j+"\tk="+k+"\tin OuterClass");
	}
	public A f2()
	{
		return new InnerClass1();
	}
	public static void f3()
	{
		OuterClass out=new OuterClass();
//在外部类的静态方法中创建内部类对象，必须采用“外部类名.内部类名”形式
//指定对象的类型，并且非静态内部类的对象必须通过外部类对象来创建
		OuterClass.InnerClass2 in2=out.new InnerClass2(30);	
		out.f1();
	//	out.h();		//错误，不能通过外部类对象名访问内部类成员
	//	in2.f1();		//错误，不能通过内部类对象名访问外部类成员	
		in2.h();
	//	h();			//错误，不能在外部类中访问内部类成员
	}
}

public class TestInnerClass
{
	public static void main(String[] args)
	{
		OuterClass t=new OuterClass();
		A a=t.f2();
		System.out.println("a.i="+a.getI());
//在外部类之外创建内部类对象，必须采用“外部类名.内部类名”形式
//指定对象的类型，并且非静态内部类的对象必须通过外部类对象来创建
		OuterClass.InnerClass2 tin2=t.new InnerClass2(20);
		tin2.h();
//静态内部类的对象可以直接采用“外部类名.内部类名”形式创建
		OuterClass.M mm=new OuterClass.M();
		OuterClass.f3();
//下述语句错误，在包含私有内部类的外部类之外无法访问这个内部类
//		OuterClass.InnerClass1 tin1=t.new InnerClass1();	
	}
}
