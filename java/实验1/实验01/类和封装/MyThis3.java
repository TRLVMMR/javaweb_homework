//MyThis3.java

class Cat				
{
	private int age;				
	private int weight;
	Cat()
	{
		this(2,4);
		System.out.println("in Cat()");
	}
	Cat(int a,int w)
	{
		age=a;
		weight=w;
		System.out.println("in Cat(int a,int w)");
	}
	int getAge()		
	{
		return age;
	}
	int getWeight()		
	{
		return weight;
	}
	void setAge(int a)		
	{
		age=a;
	}
	void setWeight(int w)		
	{
		weight=w;
	}		

}

public class MyThis3
{
	public static void main(String args[])
	{
		Cat  cat1=new Cat();
		System.out.println("CAT 1   age:"+cat1.getAge()+"\tweight:"+cat1.getWeight());
		Cat  cat2=new Cat(5,10);
		System.out.println("CAT 2   age:"+cat2.getAge()+"\tweight:"+cat2.getWeight());
	}
}
