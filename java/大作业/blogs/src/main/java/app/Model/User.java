package app.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 指明该类是一个实体Bean，可以通过jpa与数据库表建立映射关系
 * 每个成员代表数据库字段名称
 * 实体Bean的每个实例代表数据表中的一行数据
 */
@Entity
/**
 * 为被@Entity注释的类所要映射带数据库表
 * 其中@Table.name()用来指定表的表名。如果缺省@Table注释，系统默认采用类名作为映射表的表名
 */
@Table(name = "t_user")
public class User implements Serializable{

	private static final long serialVersionUID = 905654767215999L;

	public User(String userName) {
		super();
		this.userName = userName;
	}
	public User() {}
	
	/**
	 * @Id:指定表的主键
	 * @GeneratedValue:定义了标识字段生成方式
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;
	
	@Column(name = "user_name", length = 100)
	private String userName;
	@Column(name = "user_pwd", length = 20)
	private String userPwd;
	//@OneToOne(cascade = CascadeType.PERSIST)
	//@PrimaryKeyJoinColumn
	@Column(name = "email", length = 20, unique = true)
	private String email;
	
	
	public Integer getUserId() {
		return Id;
	}

	public void setUserId(Integer Id) {
		this.Id = Id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPwd() {
		return userPwd;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}