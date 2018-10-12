package com.helper.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.helper.dao.RecordingDao;
import com.helper.dao.TaskDao;
import com.helper.pojo.Recording;

public interface RecordingService {

	boolean addRecording (String username, String action) throws SQLException ;
	List<Recording> selectRecording (String username) throws SQLException ;
}
