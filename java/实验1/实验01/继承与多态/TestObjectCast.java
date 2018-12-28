//TestObjectCast.java

class Airplane
{
	private int speed=500;
	protected void setSpeed(int s)
	{
		speed=s;
	}
	protected int getSpeed()
	{
		return speed;
	}
 }

class Warplane extends Airplane
{
	private int missileNumber=8;
	protected void setMissileNumber(int n)
	{
		missileNumber=n;
	}
	protected int getMissileNumber()
	{
		return missileNumber;
	}
}

class Fighter extends Warplane
{
	public void print()
	{
		System.out.println("It is a fighter!");
	}	
}

public class TestObjectCast
{
	public static void main(String[] args)
	{
		Airplane p1=new Warplane();
		Airplane p2=new Fighter();
		Warplane w1,w2;
		Fighter f1,f2;
		p2.setSpeed(600);
		if(p1 instanceof Warplane)
		{
			System.out.println("p1连接的是一个Warplane对象");
			w1=(Warplane)p1;
			System.out.println("w1.speed="+w1.getSpeed()+
							   "\tw1.missileNumber="+w1.getMissileNumber()+"\n");
		}
		else
			System.out.println("p1连接的不是一个Warplane对象\n");
		if(p2 instanceof Warplane)
		{
			System.out.println("p2连接的是一个Warplane对象");
			w2=(Warplane)p2;
			w2.setMissileNumber(12);
			System.out.println("w2.speed="+w2.getSpeed()+
							   "\tw2.missileNumber="+w2.getMissileNumber()+"\n");
		}
		else
			System.out.println("p2连接的不是一个Warplane对象\n");
		if(p1 instanceof Fighter)
		{
			System.out.println("p1连接的是一个Fighter对象");
			f1=(Fighter)p1;
			f1.print();
			System.out.print("\n");
		}
		else
			System.out.println("p1连接的不是一个Fighter对象\n");
		if(p2 instanceof Fighter)
		{
			System.out.println("p2连接的是一个Fighter对象");
			f2=(Fighter)p2;
			f2.print();
		}
		else
			System.out.println("p2连接的不是一个Fighter对象");
	}
}



