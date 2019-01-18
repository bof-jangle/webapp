package xyz.jangle.demoname.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.DemoMapper;
import xyz.jangle.demoname.model.DemoModel;
import xyz.jangle.demoname.service.DemoService;
import xyz.jangle.utils.ResultModelList;

@Service
public class DemoServiceImpl extends BaseServiceImpl implements DemoService {

	@Autowired
	DemoMapper demoMapper;

	@Override
	public ResultModelList<DemoModel> save() {
		DemoModel user = new DemoModel();
		user.setUserName("0919-c");
		user.setUserAge("19");
		demoMapper.save(user);
//		int i=1/0;	//用于创建异常
		return new ResultModelList<DemoModel>();
	}

	@Override
	public ResultModelList<DemoModel> getAllUser() {
		ResultModelList<DemoModel> res;
		logger.info("UserServiceImpl Method.");
		logger.info("这是一段中文");
		System.out.println("这也是一段中文");
		List<DemoModel> userList = demoMapper.getAll();
		/*
		 * for (User user : userList) { System.out.println("id:" + user.getUserId());
		 * System.out.println("age:" + user.getUserAge()); System.out.println("name:" +
		 * user.getUserName()); }
		 */
//		User user = demoMapper.findById(1);
//		System.out.println("单用户信息查询，Name:" + user.getUserName());
		res = new ResultModelList<DemoModel>(userList);
		return res;
	}

}
