package aa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControll{
	
	@Autowired
	HelloWorldService myService;
	
	@RequestMapping("/hello")
	public String First() {
		return myService.getHelloMessage();
	}
}
