//PassObject.java

class Number
{
	int i;
}

public class PassObject
{
	public static void main(String args[])
	{
		Number n=new Number();
		int x=10;
		n.i=0;
		System.out.println("调用方法前：n.i="+n.i+"\tx="+x);
		f(n,x);
		System.out.println("调用方法后：n.i="+n.i+"\tx="+x);
	}
	static void f(Number num,int y)
	{
		while(y>0)
		{
			num.i+=y;
			y--;
		}
		System.out.println("退出方法时：num.i="+num.i+"\ty="+y);
	}
}