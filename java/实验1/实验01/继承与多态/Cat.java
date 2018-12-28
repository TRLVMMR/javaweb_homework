//Cat.java

class Animal
{
	private int weight;
	private int age;
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

public class Cat extends Animal
{
	void meow()
	{
		System.out.println("Meow...");
	}
	public static void main(String args[])
	{
		Cat  c=new Cat();
		c.setAge(2);
		c.setWeight(5);
		System.out.println("CAT");
		c.meow();
		System.out.println("Age="+c.getAge()+"\tWeight="+c.getWeight());
	} 
}

