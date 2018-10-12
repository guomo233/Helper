package com.helper.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.helper.pojo.Massage;
import com.helper.pojo.User;

@MapperScan("massageDao")
public interface MassageDao {
	
	public static final int SENDED = 1, RECEIVED = 2 ;

	boolean insert (Massage massage) throws SQLException ; 
//	boolean delete (int massageId) throws SQLException ;
	boolean update (Massage massage) throws SQLException ;
	List<Massage> select (@Param("condition") int condition, @Param("username") String username) throws SQLException ;
}
