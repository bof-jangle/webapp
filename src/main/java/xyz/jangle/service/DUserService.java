package xyz.jangle.service;

import java.util.List;

import xyz.jangle.model.DUser;
import xyz.jangle.model.DUserExample;

public interface DUserService {
	/**
	 * 保存
	 * @return
	 */
	int save(DUser dUser);
	/**
	 * 查询用户信息
	 * @param example
	 * @return
	 */
	List<DUser> selectByExample(DUserExample example);

}
