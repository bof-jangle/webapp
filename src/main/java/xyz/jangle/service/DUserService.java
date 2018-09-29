package xyz.jangle.service;

import javax.servlet.http.HttpSession;

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
	/**
	 * 嵌套事务的测试
	 * @return
	 */
	ResultModelList<DUser> nestedTransactionTest();
	/**
	 * 根据code和password查询用户
	 * @param record
	 * @return
	 */
	ResultModel<DUser> selectByCodeAndPassword(DUser record);
	/**
	 * 获取当前登陆者信息
	 * @return
	 */
	ResultModel<DUser> currentLoggedIn();
	/**
	 * 执行登录
	 * @param code
	 * @param password
	 * @param httpSession
	 * @return
	 */
	ResultModel<DUser> login(String code, String password, HttpSession httpSession);

}
