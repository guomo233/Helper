package com.helper.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.helper.dao.TaskDao;
import com.helper.dao.UserDao;
import com.helper.pojo.Task;
import com.helper.pojo.User;

public interface UserService {

	User login (String username, String password) throws SQLException ;
	boolean register (User user) throws SQLException ;
	boolean updateUser (User user)  throws SQLException ;
	User selectUser (String username) throws SQLException ;
	
}
