//AnonymousClass.java

interface I
{
	int f();
}

public class AnonymousClass
{
	public I getI()
	{
		return new I()
			{
				private int j=1;
				public int f()
				{
					return j;
				}
			};
	}
	public static void main(String args[])
	{
		AnonymousClass a=new AnonymousClass();
		I i=a.getI();
		
		System.out.println("j="+i.f());
	}
}



	