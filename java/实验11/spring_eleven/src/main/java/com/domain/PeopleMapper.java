package com.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PeopleMapper {
	@Select("select * from people")
	List<People> selectAll();
}
