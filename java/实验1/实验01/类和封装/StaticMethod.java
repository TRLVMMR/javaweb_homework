//StaticMethod.java

class Cat
{
	private static Cat c=new Cat();
	private int age=0;
	private Cat(){}
	static Cat birthCat()
	{
		return new Cat();
	}
	static Cat getCat()
	{
		return c;
	}
	void setAge(int a)
	{
		age=a;
	}
	int getAge()
	{
		return age;
	}

}
	
public class StaticMethod
{
	public static void main(String args[])
	{
		Cat  c=Cat.birthCat();	
		Cat.getCat().setAge(1);
		System.out.println("CAT 1 age="+c.getAge());
		System.out.println("CAT 2 age="+Cat.getCat().getAge());
	}
}



