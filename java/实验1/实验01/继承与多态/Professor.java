//Professor.java

class People
{
	public People()
	{
		System.out.println("����People�Ĺ��췽��");
	}
 }

class Teacher extends People
{
	public Teacher()
	{
		System.out.println("����Teacher�Ĺ��췽��");
	}
}

public class Professor extends Teacher 
{
	public Professor()
	{
		System.out.println("����Professor�Ĺ��췽��");
	}
	public static void main(String[] args)
	{
		Professor p=new Professor();
	}
}

	