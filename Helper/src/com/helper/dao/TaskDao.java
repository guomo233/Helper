package com.helper.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.helper.pojo.Task;
import com.helper.pojo.User;

@MapperScan("taksDao")
public interface TaskDao {
	
	public static final int WAIT_RECEIVE = 0, RELEASED = 1, RECEIVED = 2 ;

	boolean insert (Task task)  throws SQLException ;
	boolean delete (@Param("taskId") int taskId) throws SQLException ;
	List<Task> select (@Param("condition") int condition, @Param("username") String username) throws SQLException ;
	List<Task> selectByTaskId (@Param("taskId") int taskId) throws SQLException ;
	boolean update (Task task) throws SQLException ;
	
}
