package app.controll;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.Model.User;
import app.Model.UserRepository;

@Controller
public class loginController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HttpServletRequest request;
	
	//@PostMapping(value = "/login")
	@PostMapping(value = "/register")
    public String addNewUser (@RequestParam("password") String password, 
    		@RequestParam("username") String username, 
    		@RequestParam("email") String email) {
		User exsit = userRepository.findByUserName(username);
    	if(exsit != null)
    		return "/register_error";
        User user = new User();
        user.setUserName(username);
        user.setEmail(email);
        user.setUserPwd(password);
        userRepository.save(user);

        return "/success";
    }
	
	@GetMapping(value = "/register")
	public String registerPage() {
	    return "/register";
	}
	
	@PostMapping(value = "/login")
    public String loginUser (@RequestParam("password") String password, 
    		@RequestParam("username") String username, Model model) {
		
    	User result = userRepository.findByUserName(username);
    	model.addAttribute("user", result);
    	if(result != null) {
    		//获取list第一个元素
    		//User u = result.stream().findFirst().orElse(null);
    		if(result.getUserPwd().equals(password)) {
    			request.getSession().setAttribute("isLogin", result);
    			return "/success";
    		}
    	}
    	return "/login_error";
    }
	
	@GetMapping(value = "/login")
	public String loginPage() {
		return "/login";
	}
	
	@GetMapping(value = "/profile")
	public String profile(Model model){
		/*
		 * 显示用户的账户情况
		 */
		//return "测试";
		Object user = request.getSession().getAttribute("isLogin");
		if(user != null) {
			model.addAttribute("user", user);
			return "/profile";
		}
		return "/goto_login";
	}
	
	@GetMapping(value = "/logout")
	public String logout() {
		request.getSession().setAttribute("isLogin", null);
		return "/success";
	}
}
