//TestOverride.java

class ParentClass
{
	public void f(int i)
	{
		System.out.println("f(int i) in ParentClass");
	}
	public void f(int i,int j)			//��������
	{
		System.out.println("f(int i,int j) in ParentClass");
	}
 }

public class TestOverride extends ParentClass
{
	public void f(double i)			//��������
	{
		System.out.println("f(double i) in TestOverride");
	}
	public void f(int i)				//��������
	{
		System.out.println("f(int i) in TestOverride");
	}
	public void print()	
	{
		f(1);						//������TestOverride�з���f(int i)
		f(1.1);					//������TestOverride�з���f(double i)
		super.f(1);				//������ParentClass�з���f(int i) 
		f(1,2);					//������ParentClass�з���f(int i,int j)
		super.f(1,2); 				//������ParentClass�з���f(int i,int j), super��ʡ��
	}
	public static void main(String[] args)
	{
		TestOverride t=new TestOverride();
		t.print();
	}
}


