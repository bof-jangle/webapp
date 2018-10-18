package xyz.jangle.demoname.service;

import javax.servlet.http.HttpSession;

import xyz.jangle.demoname.model.BsUser;
import xyz.jangle.demoname.model.BsUserExample;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

public interface BsUserService {
	/**
	 * 保存
	 * @return
	 */
	ResultModel<BsUser> save(BsUser bsUser);
	/**
	 * 查询用户信息
	 * @param example
	 * @return
	 */
	ResultModelList<BsUser> selectByExample(BsUserExample example);
	/**
	 * 嵌套事务的测试
	 * @return
	 */
	ResultModelList<BsUser> nestedTransactionTest();
	/**
	 * 根据code和password查询用户
	 * @param record
	 * @return
	 */
	ResultModel<BsUser> selectByCodeAndPassword(BsUser record);
	/**
	 * 获取当前登陆者信息
	 * @return
	 */
	ResultModel<BsUser> currentLoggedIn();
	/**
	 * 执行登录
	 * @param code
	 * @param password
	 * @param httpSession
	 * @return
	 */
	ResultModel<BsUser> login(String code, String password, HttpSession httpSession);

}
