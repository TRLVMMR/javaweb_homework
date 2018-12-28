//Professor.java

class People
{
	public People()
	{
		System.out.println("调用People的构造方法");
	}
 }

class Teacher extends People
{
	public Teacher()
	{
		System.out.println("调用Teacher的构造方法");
	}
}

public class Professor extends Teacher 
{
	public Professor()
	{
		System.out.println("调用Professor的构造方法");
	}
	public static void main(String[] args)
	{
		Professor p=new Professor();
	}
}

	