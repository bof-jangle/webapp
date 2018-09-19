package xyz.jangle.dao;

import java.util.List;

import xyz.jangle.model.User;

public interface UserMapper {
	/**
	 * 
	 * @param user
	 */
	void save(User user);
	
	boolean update(User user);
	boolean delete(int id);
	User findById(int id);
	/**
	 * 获取所有用户信息
	 * @return
	 */
	List<User> getAll();

}
