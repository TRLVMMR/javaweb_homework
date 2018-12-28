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
	int getAge()		//读取方法，用于读取age
	{
		return age;
	}
	int getWeight()		//读取方法，用于读取weight
	{
		return weight;
	}
	void setAge(int a)		//设置方法，用于设置age
	{
		age=a;
	}
	void setWeight(int w)		//设置方法，用于设置weight
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
