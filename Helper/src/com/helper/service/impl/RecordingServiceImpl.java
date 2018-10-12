package com.helper.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.helper.dao.RecordingDao;
import com.helper.dao.TaskDao;
import com.helper.pojo.Recording;
import com.helper.service.RecordingService;

@Service("recordingService")
public class RecordingServiceImpl implements RecordingService {
	
	@Resource
	private RecordingDao recordingDao ;

	public boolean addRecording (String username, String action) throws SQLException {
		
		Recording recording = new Recording();
		recording.setUsername(username);
		recording.setAction(action);

		return recordingDao.insert(recording) ;
	}
	
	public List<Recording> selectRecording (String username) throws SQLException {
		
		return recordingDao.select(username) ;
	}
	
}
