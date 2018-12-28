package app.controll;

import java.util.HashMap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.Model.ArticleRepository;
import app.Model.User;
import app.Model.Article;

@Controller
public class BlogsController {

	
	@Autowired
	private ArticleRepository articlerepository;	//用于处理关于Article的数据库操作
	
	@Autowired
	private HttpServletRequest request;
	
	
	@GetMapping(value = "blog/{Id}")
	public String detail(@PathVariable Integer Id, Model model) {
		//Article art = new Article();
		Article art = articlerepository.findById(Id);
		if(art == null) {
			//这里没有实现。反正返回结果是404
			return "404";
		}
		model.addAttribute("u", art);
		model.addAttribute("test", "ces");
		return "/detail";
	}
	
	@GetMapping(value = "/create")
	public String createPage() {
		Object flag = request.getSession().getAttribute("isLogin");
		if(flag != null)
		{
			return "/create_article";
		}
		return "/goto_login";
		
	}
	
	@PostMapping(value = "/create")
	public String createForm(@RequestParam("title") String title, 
			@RequestParam("content") String content) {
		User u = (User)request.getSession().getAttribute("isLogin");
		Article art = new Article();
		art.setContent(content);
		art.setTitle(title);
		art.setAuthor(u.getUserName());
		articlerepository.save(art);
		
		return "/success";
	}
	
	
	@RequestMapping(value = "/myblog")
	public String myblog(HashMap<String, Object> map) {
		/*
		 * 显示登录用户的全部文章，若未登录，跳转登录
		 */
		User u = (User)request.getSession().getAttribute("isLogin");
		if(u != null) {
			List<Article> articles = articlerepository.findByAuthor(u.getUserName());
			//model.addAttribute("articles", articles);
			map.put("articles", articles);
			return "/article_list";
		}
		return "/goto_login";
	}
	
	@GetMapping(value = "/index")
	public String indexPage(Model model) {
		User u = (User)request.getSession().getAttribute("isLogin");
		model.addAttribute("user", u);
		return "/index";
	}
	@Modifying
	@Transactional
	@GetMapping(value="/delete/{id}")
	public String deletePage(@PathVariable("id") Integer id) {
		//若登录者是作者，则可以删除
		if(userVaild(id)) {
			articlerepository.deleteById(id);
			return "/success";
		}
		return "/user_vaild";
	}
	
	@GetMapping(value="/update/{id}")
	public String updatePage(@PathVariable("id") Integer id, Model model) {
		if(userVaild(id)){
			Article art = articlerepository.findById(id);
			model.addAttribute("title", art.getTitle());
			model.addAttribute("content", art.getContent());
			return "/update_article";
		}
		return "/user_vaild";
	}
	
	@PostMapping(value="/update/{id}")
	public String updatePost(@RequestParam("title") String title, 
			@RequestParam("content") String content, @PathVariable("id") Integer id){
		Article art = articlerepository.findById(id);
		art.setTitle(title);
		art.setContent(content);
		//由于主键已存在，所以是更新
		articlerepository.saveAndFlush(art);
		
		return "/success";
	}
	
	private boolean userVaild(Integer id) {
		/*
		 * 用于判断已登录用户是否是文章作者
		 */
		User u = (User)request.getSession().getAttribute("isLogin");
		//如果没有登录，直接返回false
		if(u == null)
			return false;
		
		Article art = articlerepository.findById(id);
		System.out.println(art.getAuthor());
		System.out.println(u.getUserName());
		if(art.getAuthor().equals(u.getUserName()))
			return true;
		return false;
	}
}
