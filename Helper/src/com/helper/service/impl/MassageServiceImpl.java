package com.helper.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.helper.dao.MassageDao;
import com.helper.dao.TaskDao;
import com.helper.dao.UserDao;
import com.helper.pojo.Massage;
import com.helper.pojo.Task;
import com.helper.pojo.User;
import com.helper.service.MassageService;

@Service("massageService")
public class MassageServiceImpl implements MassageService {
	
	@Resource
	private MassageDao massageDao ;
	
	public boolean sendMassage (Massage massage) throws SQLException {
		
		return massageDao.insert(massage);
	}
	
	public List<Massage> selectMassages (int condition, String username) throws SQLException {
		
		return massageDao.select(condition, username);	
	}
	
	public boolean receivedNotifyForReleaser (Task task) throws SQLException {
		
		Massage massage = Massage.getSystemNotifyMassage();
		massage.setTargetUsername(task.getReleaseUsername());
		massage.setContent(
				"你的任务：[ " + task.getDemandAbstract() + " ] 已经被用户：[ " + task.getReceiveUsername() + " ] 接受了");
		massage.setSkimed(false);

		return massageDao.insert(massage);
	}
	
	public boolean abandonNotifyForReleaser (Task task, String abandonUsername) throws SQLException {
		
		Massage massage = Massage.getSystemNotifyMassage();
		massage.setTargetUsername(task.getReleaseUsername());
		massage.setContent("你的任务：[ " + task.getDemandAbstract() + " ] 被用户：[ " + abandonUsername + " ] 放弃了");
		massage.setSkimed(false);

		return massageDao.insert(massage);
	}
	
	public boolean finishNotifyForReceiver (Task task) throws SQLException {
		
		Massage massage = Massage.getSystemNotifyMassage();
		massage.setTargetUsername(task.getReceiveUsername());
		massage.setContent("你已完成 [ " + task.getReleaseUsername() + " ] 发布的任务：[ " + task.getDemandAbstract() + " ]");
		massage.setSkimed(false);

		return massageDao.insert(massage);
	}
}