package com.controller;

import java.util.HashMap;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Model.ArticleRepository;
import com.Model.Article;

@Controller
public class BlogsController {

	@Autowired
	private ArticleRepository articlerepository;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@GetMapping(value = "blog/{Id}")
	public String detail(@PathVariable Integer Id, Model model) {
		//Article art = new Article();
		Article art = articlerepository.findById(Id);
		//Article u = art.stream().findFirst().orElse(null);
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
		//return "请前往登录";
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
		Article art = new Article();
		art.setContent(content);
		art.setTitle(title);
		articlerepository.save(art);
		
		return "/success";
	}
	
	
	@GetMapping(value = "/index")
	public String indexPage(Model model) {
		return "/index";
	}
	
	@GetMapping(value="/update/{id}")
	public String updatePage(@PathVariable("id") Integer id, Model model) {
		Article art = articlerepository.findById(id);
		model.addAttribute("title", art.getTitle());
		model.addAttribute("content", art.getContent());
		return "/update_article";
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
	
}
