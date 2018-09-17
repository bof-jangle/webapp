package xyz.jangle.service;

import java.util.List;

import xyz.jangle.model.User;

public interface UserService {
	/**
	 * 获取所有用户信息
	 * @return
	 */
	public List<User> getAllUser();

}
