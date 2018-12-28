package aa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class bbb
{
	public int[] day_inspect(Set<Integer> index){
		//List<Integer> day = new ArrayList<Integer>();
		int day[] = new int[7];
		
		for(int i = 0; i < 7; i++) {
			
			day[i] = 1;
			if(index.contains(i))
				day[i] = 0;
			/*
			if(index.contains(i))
				day.add(0);
			else
			{
				day.add(1);
			}
			*/
		}
		
		return day;
	}
}

public class aaa {
	
	public static void main(String arg[]) {
		Map<String, int[]> map = new HashMap<String,int[]>();
		Set<Integer> index = new HashSet<Integer>();
		index.add(0);
		index.add(1);
		//List<Integer> day = new ArrayList<Integer>();
		bbb b  = new bbb();
		
		map.put("1", b.day_inspect(index));
		//map.put("Monday", day);
		index.clear();
		
		//Set<Integer> index = new HashSet<Integer>();
		index.add(2);
		index.add(3);
		//day = b.day_inspect(index);
		System.out.print("  ");
		map.put("2", b.day_inspect(index));

		int[] item = map.get("1");
		for(int e : item)
		{
			System.out.println(e);
		}
		System.out.println();
		int[] item1 = map.get("2");
		for(int e : item1)
		{
			System.out.println(e);
		}
		//map.put("Tuesday", day);
		
	}
	

}



