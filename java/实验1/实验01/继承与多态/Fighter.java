//Fighter.java

class Airplane
{
	private int speed;
	public Airplane(int s)
	{
		speed=s;
		System.out.println("调用构造方法Airplane(int s)");
	}
 }

class Warplane extends Airplane
{
	public Warplane()
	{
		super(600);
		System.out.println("调用构造方法Warplane()");
	}
	public Warplane(int s)
	{
		super(s);
		System.out.println("调用构造方法Warplane(int s)");
	}	
}

public class Fighter extends Warplane
{
	public Fighter()
	{
		super();				//可省略
		System.out.println("调用构造方法Fighter()");
	}
	public Fighter(int s)
	{
		super(s);
		System.out.println("调用构造方法Fighter(int s)");
	}
	public static void main(String[] args)
	{
		System.out.println("创建对象：Fighter f1=new Fighter()");
		Fighter f1=new Fighter();
		System.out.println("\n创建对象：Fighter f2=new Fighter(500)");
		Fighter f2=new Fighter(500);
	}
}
