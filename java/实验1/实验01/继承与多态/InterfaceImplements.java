//InterfaceImplements.java

interface Animal
{
	int AGE=1;
	void speak();
 }

class Cat implements  Animal
{
	int age=AGE;				//利用接口中定义的常量赋值
	public void speak()			//实现接口中的抽象方法
	{
		System.out.println("Cat Meow...   age:"+age);
	}
}

class Tomcat extends Cat
{
	public void speak()			//覆盖类Cat中的方法
	{
		System.out.println("Tomcat Meow...");
	}
}

public class InterfaceImplements
{
	public static void makeSpeak(Animal a)
	{
		a.speak();
	}
	public static void main(String[] args)
	{
		Tomcat t=new Tomcat();
		makeSpeak(t);	//自动类型转换，多态
			
		Cat c=new Cat();
		makeSpeak(c);	//自动类型转换，多态
	}
}

