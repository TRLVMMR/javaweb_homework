package app.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import app.Model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	//在此定义接口，jpa会自己实现其sql语句
	User findByUserName(String userName);
	User findByUserNameAndUserPwd(String userName, String password);
}
