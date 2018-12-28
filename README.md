# javaweb_homework
## 此项目是实现一个非常简单的博客

### 使用的框架以及工具
	使用spring boot MVC框架, JPA ORM框架， mysql数据库,  freemarker
	静态文件放在文件夹中templates中
### 设置
	设置文件为application.properties

### 主函数
#### 声明作为spring boot的一个app，也即主函数
    @SpringBootApplication
    public class BlogApp {
      public static void main(String[] args){
        SpringApplication.run(BlogApp.class, args);
        }
    }



### 模型层

#### User Model 用户管理博客用户的模型

    @Entity
    @Table(name = "t_user")
    public class User implements Serializable{

        private static final long serialVersionUID = 905654767215999L;

        public User(String userName) {
          super();
          this.userName = userName;
        }
        public User() {}
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer Id;

        @Column(name = "user_name", length = 100)
        private String userName;
        @Column(name = "user_pwd", length = 20)
        private String userPwd;
        @Column(name = "email", length = 20, unique = true)
        private String email; 
    }
 
#### Ariicle Model 博客文章模型
  
    @Entity
    @EntityListeners(AuditingEntityListener.class)
    @Table(name = "article")
    public class Article implements Serializable{
  
      private static final long serialVersionUID = 888654767215999L;
      public Article(){}

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "id")
      private Integer id;
      @Column(name = "title")
      private String title;
      @Column
      private String content;
      @Column
      private String author;
      // 创建时间
      @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
      private Date ctime;
      //最后一次修改时间
      @LastModifiedDate
      @Column
      private Date last;
    }
  
  #### JPA处理与数据库的交互
 
    public interface ArticleRepository extends JpaRepository<Article, Long> {

        //在此定义接口，jpa会自己实现其sql语句
        List<Article> findByTitle(String title);
        Article findById(Integer Id);
        void deleteById(Integer Id);
        List<Article> findByAuthor(String author);
    }

    public interface UserRepository extends JpaRepository<User, Long> {

          //在此定义接口，jpa会自己实现其sql语句
          User findByUserName(String userName);
          User findByUserNameAndUserPwd(String userName, String password);
    }

### 控制层
##### 声明作为spring boot的controller，作为控制层
    @Controller
    public class BlogsController{}
    @Controller
    public class loginController{}

#### 注册
##### 若注册用户名已存在。则报错，否则，注册用户
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

#### 登录
###### 若用户名跟密码对应，则登录，并把已登录的用户设为此用户
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
	
  #### 注销
  ##### 直接把已登录用户设为null
  	@GetMapping(value = "/logout")
	public String logout() {
		request.getSession().setAttribute("isLogin", null);
		return "/success";
	}
  
  #### 用户页面
  ##### 登录后转入用户页面，可查看自己的博客跟创建博客，若未登录，跳转到登录页面
  	@GetMapping(value = "/profile")
	public String profile(Model model){
      /*
       * 显示用户的账户情况
       */
      Object user = request.getSession().getAttribute("isLogin");
      if(user != null) {
        model.addAttribute("user", user);
        return "/profile";
      }
      return "/goto_login";
	}

#### 查看博客详情
##### 可以查看博客的标题，内容以及作者。不需要用户登录
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
    
#### 创建博客
##### 创建博客，作者会自动设置为以登录用户 若未登录，则会跳转到登录页面
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
	}
  
  #### 查看自己的博客
  ##### 查看用户自己的文章，可进行查看，编辑，删除。若未登录，则跳转登录
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
  
  #### 更新文章
  ##### 若文章进行了修改，则修改数据库内对应的内容
  	
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
  
  #### 删除文章
  ##### 删除对应id的文章，必须加上@Modifying以及@Transactional装饰器，否则会报错
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
  
  #### 主页
  ##### 若用户未登录，则user为null，提醒登录，若已登录，则在前端显示其登录
  	@GetMapping(value = "/index")
	public String indexPage(Model model) {
		User u = (User)request.getSession().getAttribute("isLogin");
		model.addAttribute("user", u);
		return "/index";
	}
  
  
  #### 验证作者
  ##### 用于验证作者是否是已登录用户
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
	
### 视图层
#### 倒计时跳转
##### 跳转使用JavaScript代码实，这样id为sp的就具有此js效果，跳转文字，时间跟链接可自行修改
	   <script type="text/javascript">
        onload=function(){
            setInterval(go, 1000);
        };
        var x=3; //利用了全局变量来执行
        function go(){
        x--;
            if(x > 0){
            document.getElementById("sp").innerHTML="还有" + x + "秒后跳转到主页";
            }else{
            location.href='http://localhost:8080/index';
            }
        }
    </script>

#### 当用户登录时显示用户名，使用if判断已登录用户user是否为空，freemarker语法是后面加两个问号？？
	<#if user??>
		<h1>欢迎登录, ${user.getUserName()}</h1>
		<p><a href="http://localhost:8080/profile">我的账户</a></p>
     <#else>
     	<h2>您还没有登录，请前往登录</h1>
     </#if>
#### freemakeer循环语句，或者说遍历列表
	<#list articles as item>
		<h2>标题 ${item.getTitle()} </h2><p><a href="http://localhost:8080/blog/${item.getID()}">查看</a>
		<a href="http://localhost:8080/update/${item.getID()}">编辑</a>
		<a href="http://localhost:8080/delete/${item.getID()}">删除</a></p>
		<br>
	</#list>
