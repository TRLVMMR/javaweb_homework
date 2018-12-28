//MyThis1.java

class Cat				
{
	private int age=0;
	Cat grow()
	{
		age++;
		return this;
	}
	void print()
	{
		System.out.println("Ã¨µÄÄêÁäÊÇ"+age);
	}

}

public class MyThis1
{
	public static void main(String args[])
	{
		Cat  cat=new Cat();
		cat.grow().grow().grow().grow().print();
	}
}

