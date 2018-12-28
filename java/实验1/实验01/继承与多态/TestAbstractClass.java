//TestAbstractClass.java

abstract class Animal
{
	private int weight;
	private int age;

	protected int getAge()				
	{
		return age;
	}
	protected int getWeight()			
	{
		return weight;
	}
	protected void setAge(int a)		
	{
		age=a;
	}
	protected void setWeight(int w)
	{
		weight=w;
	}		
	abstract public void speak();
 }

class Dog extends Animal
{
	public void speak()			
	{
		System.out.println("Bowwow...");
	}
}

class Cat extends Animal
{
	public void speak()
	{
		System.out.println("Meow...");
	}
}

public class TestAbstractClass
{
	public static void makeSpeak(Animal a)
	{
		a.speak();
	}
	public static void main(String[] args)
	{
		Cat c=new Cat();
		c.setAge(1);c.setWeight(2);
		System.out.println("CAT  age="+c.getAge()+"\twight="+c.getWeight());
		makeSpeak(c);
		
		Dog d=new Dog();
		d.setAge(2);d.setWeight(5);
		System.out.println("\nDOG  age="+d.getAge()+"\twight="+d.getWeight());
		makeSpeak(d);		
	}
}

