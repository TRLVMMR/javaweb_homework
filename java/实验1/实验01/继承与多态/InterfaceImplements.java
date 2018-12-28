//InterfaceImplements.java

interface Animal
{
	int AGE=1;
	void speak();
 }

class Cat implements  Animal
{
	int age=AGE;				//���ýӿ��ж���ĳ�����ֵ
	public void speak()			//ʵ�ֽӿ��еĳ��󷽷�
	{
		System.out.println("Cat Meow...   age:"+age);
	}
}

class Tomcat extends Cat
{
	public void speak()			//������Cat�еķ���
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
		makeSpeak(t);	//�Զ�����ת������̬
			
		Cat c=new Cat();
		makeSpeak(c);	//�Զ�����ת������̬
	}
}

