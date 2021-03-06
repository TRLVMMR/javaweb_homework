package com.Model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	//在此定义接口，jpa会自己实现其sql语句
	List<Article> findByTitle(String title);
	Article findById(Integer Id);
	Article deleteById(Integer Id);
	List<Article> findByAuthor(String author);
}
