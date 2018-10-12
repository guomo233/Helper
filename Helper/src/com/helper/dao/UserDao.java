package com.helper.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.helper.pojo.User;

@MapperScan("userDao")
public interface UserDao {

	boolean insert (User user)  throws SQLException ;
	boolean delete (@Param("username") String username)  throws SQLException ;
	boolean update (User user)  throws SQLException ;
	User select (@Param("username") String username)  throws SQLException ;
	User selectUsePassword (@Param("username") String username, @Param("password") String password)  throws SQLException ;
	
}
