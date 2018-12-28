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
	
	private class InnerClass1 extends A		//�ڲ����������Ϊprivate��protected
	{	
		public void g()
		{
			System.out.println("����˽���ڲ���ķ���g()");
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
			f1();		//�ڲ����п���ֱ�ӷ����ⲿ��ķ���
			j++;		//�ڲ����п���ֱ�ӷ����ⲿ������ݳ�Ա
			k++;
			System.out.println("j="+j+"\tk="+k+"\tm="+m+"\tin InnerClass2");
		}
	}
	
	static class M{}			//�ڲ����������Ϊstatic
	
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
//���ⲿ��ľ�̬�����д����ڲ�����󣬱�����á��ⲿ����.�ڲ���������ʽ
//ָ����������ͣ����ҷǾ�̬�ڲ���Ķ������ͨ���ⲿ�����������
		OuterClass.InnerClass2 in2=out.new InnerClass2(30);	
		out.f1();
	//	out.h();		//���󣬲���ͨ���ⲿ������������ڲ����Ա
	//	in2.f1();		//���󣬲���ͨ���ڲ�������������ⲿ���Ա	
		in2.h();
	//	h();			//���󣬲������ⲿ���з����ڲ����Ա
	}
}

public class TestInnerClass
{
	public static void main(String[] args)
	{
		OuterClass t=new OuterClass();
		A a=t.f2();
		System.out.println("a.i="+a.getI());
//���ⲿ��֮�ⴴ���ڲ�����󣬱�����á��ⲿ����.�ڲ���������ʽ
//ָ����������ͣ����ҷǾ�̬�ڲ���Ķ������ͨ���ⲿ�����������
		OuterClass.InnerClass2 tin2=t.new InnerClass2(20);
		tin2.h();
//��̬�ڲ���Ķ������ֱ�Ӳ��á��ⲿ����.�ڲ���������ʽ����
		OuterClass.M mm=new OuterClass.M();
		OuterClass.f3();
//�����������ڰ���˽���ڲ�����ⲿ��֮���޷���������ڲ���
//		OuterClass.InnerClass1 tin1=t.new InnerClass1();	
	}
}
