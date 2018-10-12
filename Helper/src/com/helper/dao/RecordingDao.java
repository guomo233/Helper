package com.helper.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.helper.pojo.Recording;

@MapperScan("recordingDao")
public interface RecordingDao {

	boolean insert (Recording recording)  throws SQLException ;
	List<Recording> select (@Param("username") String username)  throws SQLException ;
}
