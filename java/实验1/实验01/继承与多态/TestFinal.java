//TestFinal.java

public class TestFinal
{
	static final int J=1;
	public static final int K=2;
	final int m;
	TestFinal(int i)
	{
		m=i;
	}
	public static void main(String[] args)
	{
		TestFinal tf1=new TestFinal(1);
		TestFinal tf2=new TestFinal(2);
		System.out.println("tf1.m="+tf1.m+"\ttf2.m="+tf2.m);
	}
}

