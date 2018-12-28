//Fighter.java

class Airplane
{
	private int speed;
	public Airplane(int s)
	{
		speed=s;
		System.out.println("���ù��췽��Airplane(int s)");
	}
 }

class Warplane extends Airplane
{
	public Warplane()
	{
		super(600);
		System.out.println("���ù��췽��Warplane()");
	}
	public Warplane(int s)
	{
		super(s);
		System.out.println("���ù��췽��Warplane(int s)");
	}	
}

public class Fighter extends Warplane
{
	public Fighter()
	{
		super();				//��ʡ��
		System.out.println("���ù��췽��Fighter()");
	}
	public Fighter(int s)
	{
		super(s);
		System.out.println("���ù��췽��Fighter(int s)");
	}
	public static void main(String[] args)
	{
		System.out.println("��������Fighter f1=new Fighter()");
		Fighter f1=new Fighter();
		System.out.println("\n��������Fighter f2=new Fighter(500)");
		Fighter f2=new Fighter(500);
	}
}
