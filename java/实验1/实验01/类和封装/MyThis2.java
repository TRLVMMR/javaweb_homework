//MyThis2.java

class Cat				
{	
	private int age;				
	private int weight;
	Cat(int age,int weight)
	{
		this.age=age;
		this.weight=weight;
	}
	int getAge()		
	{
		return age;
	}
	int getWeight()		
	{
		return weight;
	}
	void setAge(int age)		
	{
		this.age=age;
	}
	void setWeight(int weight)		
	{
		this.weight=weight;
	}		

}

public class MyThis2
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

