package com.helper.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.helper.dao.RecordingDao;
import com.helper.dao.TaskDao;
import com.helper.dao.UserDao;
import com.helper.pojo.Recording;
import com.helper.pojo.Task;
import com.helper.pojo.User;

public interface TaskService {

	List<Task> selectTasks (int condition, String username) throws SQLException ;
	boolean addTask (Task task, String username) throws SQLException ;
	boolean receiveTask (int taskId, String receiveUsername) throws SQLException ;
	boolean deleteTask (int taskId) throws SQLException ;
	boolean abandonTask (int taskId, String abandonUsername) throws SQLException ;
	boolean finishTask (int taskId, String releaseUsername, int evaluate) throws SQLException ;
}
