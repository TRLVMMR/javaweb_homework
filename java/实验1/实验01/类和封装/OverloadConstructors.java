//OverloadConstructors.java

class Cat				
{
	int age;				
	int weight;	
	
	Cat()
	{
		age=2;
		weight=4;
		System.out.println("in Cat()");
	}
	
	Cat(int a,int w)
	{
		age=a;
		weight=w;
		System.out.println("in Cat(int a,int w)");
	}
	void meow()			
	{
		System.out.println("Meow...");
	}
}

public class OverloadConstructors
{
	public static void main(String args[])
	{
		Cat  cat1=new Cat();
		System.out.println("CAT 1   age:"+cat1.age+"\tweight:"+cat1.weight);
		Cat  cat2=new Cat(5,10);
		System.out.println("CAT 2   age:"+cat2.age+"\tweight:"+cat2.weight);
	}
}
