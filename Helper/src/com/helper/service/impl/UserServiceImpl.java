package com.helper.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.helper.dao.TaskDao;
import com.helper.dao.UserDao;
import com.helper.pojo.Task;
import com.helper.pojo.User;
import com.helper.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService { 
	
	@Resource
	private UserDao userDao ;

	public User login (String username, String password) throws SQLException {
	
		return userDao.selectUsePassword(username, password) ;
	}
	
	public boolean register (User user) throws SQLException {
		
		return userDao.insert(user);
	}
	
	public boolean updateUser (User user)  throws SQLException {
		
		return userDao.update(user);
	}
	
	public User selectUser (String username) throws SQLException {
		
		return userDao.select(username);
	}
}
