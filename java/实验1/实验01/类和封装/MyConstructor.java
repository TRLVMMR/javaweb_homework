//MyConstructor.java

class Cat				
{
	int age;				
	int weight;	
	
	Cat(int a,int w)
	{
		age=a;
		weight=w;
	}
	void meow()			
	{
		System.out.println("Meow...");
	}
}

public class MyConstructor
{
	public static void main(String args[])
	{
		Cat  cat=new Cat(5,10);
		System.out.println("CAT    age:"+cat.age+"\tweight:"+cat.weight);
	}
}
