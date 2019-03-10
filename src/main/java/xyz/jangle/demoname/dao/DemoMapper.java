package xyz.jangle.demoname.dao;

import java.util.List;

import xyz.jangle.demoname.model.DemoModel;

public interface DemoMapper {
	/**
	 * 
	 * @param user
	 */
	void save(DemoModel user);
	
	boolean update(DemoModel user);
	boolean delete(int id);
	DemoModel findById(int id);
	/**
	 * 获取所有用户信息
	 * @return
	 */
	List<DemoModel> getAll();

}
