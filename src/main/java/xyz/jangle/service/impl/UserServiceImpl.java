package xyz.jangle.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.dao.UserMapper;
import xyz.jangle.model.User;
import xyz.jangle.service.UserService;
import xyz.jangle.utils.ResultModelList;

@Service
public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	UserMapper userMapper;

	@Override
	public ResultModelList<User> save() {
		User user = new User();
		user.setUserName("0919-c");
		user.setUserAge("19");
		userMapper.save(user);
		int i=1/0;	//用于创建异常
		return new ResultModelList<User>();
	}

	@Override
	public ResultModelList<User> getAllUser() {
		ResultModelList<User> res;
		logger.info("UserServiceImpl Method.");
		logger.info("这是一段中文");
		System.out.println("这也是一段中文");
		List<User> userList = userMapper.getAll();
		/*
		 * for (User user : userList) { System.out.println("id:" + user.getUserId());
		 * System.out.println("age:" + user.getUserAge()); System.out.println("name:" +
		 * user.getUserName()); }
		 */
//		User user = userMapper.findById(1);
//		System.out.println("单用户信息查询，Name:" + user.getUserName());
		res = new ResultModelList<User>(userList);
		return res;
	}

}
