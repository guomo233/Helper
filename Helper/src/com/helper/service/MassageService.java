package com.helper.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.helper.dao.MassageDao;
import com.helper.dao.TaskDao;
import com.helper.dao.UserDao;
import com.helper.pojo.Massage;
import com.helper.pojo.Task;
import com.helper.pojo.User;

public interface MassageService {
	
	boolean sendMassage (Massage massage) throws SQLException ;
	List<Massage> selectMassages (int condition, String username) throws SQLException ;
	boolean receivedNotifyForReleaser (Task task) throws SQLException ;
	boolean abandonNotifyForReleaser (Task task, String abandonUsername) throws SQLException ;
	boolean finishNotifyForReceiver (Task task) throws SQLException ;
}