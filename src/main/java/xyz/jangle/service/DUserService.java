package xyz.jangle.service;

import xyz.jangle.model.DUser;
import xyz.jangle.model.DUserExample;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

public interface DUserService {
	/**
	 * 保存
	 * @return
	 */
	ResultModel<DUser> save(DUser dUser);
	/**
	 * 查询用户信息
	 * @param example
	 * @return
	 */
	ResultModelList<DUser> selectByExample(DUserExample example);

}
