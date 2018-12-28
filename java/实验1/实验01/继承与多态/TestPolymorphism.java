//TestPolymorphism.java

class Animal
{
	public void speak()
	{
		System.out.println("Animal speak...");
	}
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

public class TestPolymorphism
{
	public static void makeSpeak(Animal a)
	{
		a.speak();
	}
	public static void main(String[] args)
	{
		Cat c=new Cat();
		Dog d=new Dog();
		makeSpeak(c);
		makeSpeak(d);		
	}
}

