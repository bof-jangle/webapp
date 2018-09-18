package xyz.jangle.service;

import xyz.jangle.model.User;
import xyz.jangle.utils.ResultModelList;

public interface UserService {
	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 */
	public ResultModelList<User> getAllUser();

}
