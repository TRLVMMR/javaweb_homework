//MyAccessSpec.java

class Cat				
{	
	private int age;				
	private int weight;
	Cat(int a,int w)
	{
		age=a;
		weight=w;
	}
	int getAge()		//��ȡ���������ڶ�ȡage
	{
		return age;
	}
	int getWeight()		//��ȡ���������ڶ�ȡweight
	{
		return weight;
	}
	void setAge(int a)		//���÷�������������age
	{
		age=a;
	}
	void setWeight(int w)		//���÷�������������weight
	{
		weight=w;
	}		
	
	void meow()			
	{
		System.out.println("Meow...");
	}

}

public class MyAccessSpec
{
	public static void main(String args[])
	{
		Cat  cat=new Cat(1,1);
		System.out.println("CAT    age:"+cat.getAge()+"\tweight:"+cat.getWeight());
		cat.setAge(2);
		cat.setWeight(3);
		System.out.println("CAT    age:"+cat.getAge()+"\tweight:"+cat.getWeight());
	}
}
