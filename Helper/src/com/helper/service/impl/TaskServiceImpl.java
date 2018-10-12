package com.helper.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.helper.dao.RecordingDao;
import com.helper.dao.TaskDao;
import com.helper.dao.UserDao;
import com.helper.pojo.Recording;
import com.helper.pojo.Task;
import com.helper.pojo.User;
import com.helper.service.MassageService;
import com.helper.service.RecordingService;
import com.helper.service.TaskService;
import com.helper.service.UserService;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

	@Resource
	private TaskDao taskDao ;
	
	@Resource
	private RecordingService recordingService ;
	
	@Resource
	private MassageService massageService ;
	
	@Resource
	private UserService userService ;
	
	public List<Task> selectTasks (int condition, String username) throws SQLException {
		
		return taskDao.select(condition, username);
	}
	
	public boolean addTask (Task task, String username) throws SQLException {
		
		if (taskDao.insert(task)) {
			//记录用户行为
			recordingService.addRecording (username, "发布了一条任务：[ " + task.getDemandAbstract() + " ]") ;
			return true;
		} else {
			return false;
		} 
	}
	
	public boolean receiveTask (int taskId, String receiveUsername) throws SQLException {
		
		List<Task> taskList = taskDao.selectByTaskId(taskId);
		if (taskList.size() > 0) {
			Task task = taskList.get(0);
			if (task.getReceiveUsername() == null) {
				//接受并更新任务
				task.setReceiveUsername(receiveUsername);
				task.setStatus(Task.ING);
				if (taskDao.update(task)) {
					//更新成功，通知接受者
					massageService.receivedNotifyForReleaser(task);
					//记录用户行为
					recordingService.addRecording(receiveUsername, "接受了一条任务：[ " + task.getDemandAbstract() + " ]");
					return true;
				} else {
					//更新失败
					return false;
				}
			} else {
				//已经有人接了
				return false;
			}
		} else {
			//没找到此任务
			return false;
		} 
	}
	
	public boolean deleteTask (int taskId) throws SQLException {
		
		List<Task> taskList = taskDao.selectByTaskId(taskId);
		if (taskList.size() > 0) {
			Task task = taskList.get(0);
			if (task.getReceiveUsername() == null) {
				//删除任务
				return taskDao.delete(taskId);
			} else {
				//已经有人接了，不允许删除
				return false;
			}
		} else {
			//没找到此任务
			return false;
		} 
	}
	
	public boolean abandonTask (int taskId, String abandonUsername) throws SQLException {
		
		List<Task> taskList = taskDao.selectByTaskId(taskId);
		if (taskList.size() > 0) {
			Task task = taskList.get(0);
			//放弃并更新任务
			task.setReceiveUsername(null);
			task.setStatus(Task.WAIT_RECEIVE);
			if (taskDao.update(task)) {
				//放弃成功
				massageService.abandonNotifyForReleaser(task, abandonUsername);
				//记录用户行为
				recordingService.addRecording(abandonUsername, "放弃了一条任务：[ " + task.getDemandAbstract() + " ]");
				return true;
			} else {
				//放弃失败
				return false;
			}
		} else {
			//没有找到此任务
			return false;
		} 
	}
	
	public boolean finishTask (int taskId, String releaseUsername, int evaluate) throws SQLException {
		
		List<Task> taskList = taskDao.selectByTaskId(taskId);
		if (taskList.size() > 0) {
			Task task = taskList.get(0);
			//完成并更新任务
			task.setStatus(Task.FINISHED);
			if (taskDao.update(task)) {
				//完成成功
				massageService.finishNotifyForReceiver(task);
				//记录用户行为
				recordingService.addRecording(releaseUsername, "完成了一条任务：[ " + task.getDemandAbstract() + " ]");
				recordingService.addRecording(task.getReceiveUsername(),
						"完成了一条任务：[ " + task.getDemandAbstract() + " ]");
				//更新用户数据
				User receiveUser = userService.selectUser(task.getReceiveUsername());
				receiveUser.setFinishTimes(receiveUser.getFinishTimes() + 1);
				receiveUser.setEvaluate((receiveUser.getEvaluate() + evaluate) / receiveUser.getFinishTimes());
				userService.updateUser(receiveUser) ;
				
				return true;
			} else {
				//完成失败
				return false;
			}
		} else {
			//没有找到任务
			return false;
		} 
	}
}
