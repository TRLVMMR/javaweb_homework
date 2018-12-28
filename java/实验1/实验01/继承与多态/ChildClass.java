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
		super.f();			//ʡ�Թؼ���super�����ʵ���ͬһ��������
		System.out.println("super.i="+super.i+"\ti="+i);	//�ؼ���super����ʡ��
	}
	
	public static void main(String[] args)
	{
		ChildClass c=new ChildClass();
		c.print();
	}
}

