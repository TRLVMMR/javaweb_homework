package comm.controll;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InspectionController {
	@RequestMapping("/inspect")
	public String inspect(HashMap<String,Object> map) {
		
		Set<Integer> index = new HashSet<Integer>();
		index.add(0);
		index.add(1);
		//List<Integer> day = new ArrayList<Integer>();
		//int[] day = ;
		//System.out.print(day);
		map.put("Monday",day_inspect(index));
		
		
		//Set<Integer> index1 = new HashSet<Integer>();
		index.clear();
		index.add(2);
		index.add(3);
		//day = day_inspect(index1);
		map.put("Tuesday", day_inspect(index));
		
		index.clear();
		index.add(4);
		index.add(5);
		map.put("Wednesday", day_inspect(index));
		
		index.clear();
		index.add(0);
		index.add(1);
		map.put("Thursday", day_inspect(index));
		
		index.clear();
		index.add(2);
		index.add(3);
		map.put("Friday", day_inspect(index));
		
		index.clear();
		map.put("Saturday", day_inspect(index));
		
		index.clear();
		index.add(0);
		index.add(1);
		index.add(4);
		index.add(5);
		map.put("Sunday", day_inspect(index));
		
		return "/inspect";
	}
	
	private int[] day_inspect(Set<Integer> index){
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
