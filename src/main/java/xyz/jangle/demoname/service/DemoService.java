package xyz.jangle.demoname.service;

import xyz.jangle.demoname.model.DemoModel;
import xyz.jangle.utils.ResultModelList;

public interface DemoService {
	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 */
	public ResultModelList<DemoModel> getAllUser();
	/**
	 * test for nestedTransactionTest
	 * @return
	 */
	public ResultModelList<DemoModel> save();

}
