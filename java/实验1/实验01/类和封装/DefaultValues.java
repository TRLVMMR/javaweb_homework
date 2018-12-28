//DefaultValues.java

class A{}

class B
{
	boolean bool;
	char c;
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	A  a;
	void output()
	{
		System.out.println(
			"数据类型      |     默认值\n"+
			"--------------|-----------\n"+
			"boolean       |     "+bool+"\n"+
			"char          |     "+c+"\n"+
			"byte          |     "+b+"\n"+
			"short         |     "+s+"\n"+
			"int           |     "+i+"\n"+
			"long          |     "+l+"\n"+
			"float         |     "+f+"\n"+
			"double        |     "+d+"\n"+
			"对象引用      |     "+a+"\n");
	}			
}

public class DefaultValues
{
	public static void main(String args[])
	{
		B  b=new B();
		b.output();
	}
}

