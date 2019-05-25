package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsUserMapper;
import xyz.jangle.demoname.model.BsUser;
import xyz.jangle.demoname.model.BsUserExample;
import xyz.jangle.demoname.model.DemoModel;
import xyz.jangle.demoname.service.BsUserService;
import xyz.jangle.demoname.service.DemoService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;
import xyz.jangle.utils.UserCacheMap;

@Service
public class BsUserServiceImpl extends BaseServiceImpl implements BsUserService {

	@Autowired
	private BsUserMapper bsUserMapper;
	@Autowired
	private DemoService demoService;
	@Autowired(required = false)
	private HttpSession httpSession; // 这个session由Spring注入，
	// required=false，当在单元测试时，该session可为null，使其启动不报错。
	// 这应该是个代理对象，对于它的调用，其本身会委托给当前的Session对象执行对应的方法，返回对应的返回值。

	@Override
	public ResultModel<BsUser> login(String code, String password, HttpSession httpSession2) {
		// 从缓存中校验用户
		BsUser BsUserCache = UserCacheMap.get(code + "&" + password);
		if (BsUserCache != null) {
			// 登陆成功
			loginSuccess(httpSession, BsUserCache);
			return new ResultModel<BsUser>(BsUserCache);
		}
		// 缓存中未通过则从数据库校验
		BsUser record = new BsUser();
		record.setUsrCode(code);
		record.setUsrPassword(password);
		BsUser model = bsUserMapper.selectByCodeAndPassword(record);
		// 数据库校验未通过，则提示错误
		if (model == null) {
			return new ResultModel<BsUser>(CME.loginFailed);
		}
		model.setUsrPassword(""); // 将密码置空
		model.setCity((String) httpSession.getAttribute(JConstant.city));
		model.setIp((String) httpSession.getAttribute(JConstant.ip));
		// 数据库校验通过后，将信息进行缓存
		UserCacheMap.put("" + model.getUsrId(), model); // 登陆成功后，缓存用户信息
		UserCacheMap.put(model.getUsrCode() + "&" + password, model); // 登陆成功后，缓存用户信息
		loginSuccess(httpSession, model);
		return new ResultModel<BsUser>(model);
	}

	@Override
	public ResultModel<BsUser> currentLoggedIn() {
		logger.info("当前用户userName:" + httpSession.getAttribute("userName"));
		logger.info("当前用户userId:" + httpSession.getAttribute("userId"));
		logger.info(this); // 对象是单列的。
		logger.info(httpSession); // 对象的属性却是不一样的。这是个代理对象。
		Object userId = httpSession.getAttribute("userId");
		if (userId == null) {
			// 未登录或者session失效
			return new ResultModel<>(CME.unlogin);
		}
		logger.debug("userId:" + Integer.valueOf("" + userId));
//		BsUser BsUser = BsUserMapper.selectByPrimaryKey(Integer.valueOf(""+userId));
		BsUser BsUser = UserCacheMap.get("" + userId); // 如果登陆过，则缓存中会有信息。
		return new ResultModel<BsUser>(BsUser);
	}

	@Override
	public ResultModel<BsUser> selectByCodeAndPassword(BsUser record) {
		return new ResultModel<BsUser>(bsUserMapper.selectByCodeAndPassword(record));
	}

	@Override
	public ResultModel<BsUser> save(BsUser bsUser) {
		bsUserMapper.save(bsUser);
//		int i = 1/0;
		return new ResultModel<BsUser>(CME.success);
	}

	@Override
	public ResultModelList<BsUser> selectByExample(BsUserExample example) {
		ResultModelList<BsUser> resultModelList;
		List<BsUser> list = bsUserMapper.selectByExample(example);
		resultModelList = new ResultModelList<BsUser>(list);
		return resultModelList;
	}

	@Override
	public ResultModelList<BsUser> nestedTransactionTest() {
		BsUser BsUser = new BsUser();
		BsUser.setUsrName("0919");
		BsUser.setUsrCode("0919");
		BsUser.setUsrPassword("0919");
		ResultModelList<DemoModel> resultModelList = demoService.save();
		bsUserMapper.save(BsUser);
		return new ResultModelList<BsUser>(resultModelList.getCode(), resultModelList.getMessage());
	}

	/**
	 * 登陆成功执行内容
	 * 
	 * @param httpSession
	 * @param model
	 */
	private void loginSuccess(HttpSession httpSession, BsUser model) {
		httpSession.setAttribute("userName", model.getUsrName());
		httpSession.setAttribute("userId", model.getUsrId().intValue());
	}

	@Override
	public ResultModel<BsUser> insertOrUpdate(BsUser record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getUsrId())) {
			i = bsUserMapper.updateByPrimaryKeySelective(record);
		} else {
			i = bsUserMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsUser>(record);
		}
		return new ResultModel<BsUser>(CME.error);
	}

	@Override
	public ResultModel<BsUser> deleteByPrimaryKey(BsUser bsUser) {
		bsUserMapper.deleteByPrimaryKey(bsUser.getUsrId());
		return new ResultModel<BsUser>(bsUser);
	}

	@Override
	public ResultModel<BsUser> updateByPrimaryKey(BsUser bsUser) {
		bsUserMapper.updateByPrimaryKey(bsUser);
		return new ResultModel<BsUser>(bsUser);
	}

	@Override
	public ResultModel<BsUser> selectByPrimaryKey(BsUser bsUser) {
		BsUser byPrimaryKey = bsUserMapper.selectByPrimaryKey(bsUser.getUsrId());
		return new ResultModel<BsUser>(byPrimaryKey);
	}

	@Override
	public ResultModelList<BsUser> selectByParam(Map<String, Object> param) {
		List<BsUser> list = bsUserMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}

	@Override
	public ResultModelList<BsUser> selectPage(BsUser record) {
		ResultModelList<BsUser> resultModelList = new ResultModelList<BsUser>(bsUserMapper.selectPage(record));
		resultModelList.setCount(bsUserMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModelList<BsUser> selectAll() {
		List<BsUser> list = bsUserMapper.selectAll();
		return new ResultModelList<BsUser>(list);
	}

	@Override
	public ResultModel<BsUser> batchDeleteByPrimaryKey(BsUser record) {
		// TODO Auto-generated method stub 
		return null;
	}

}
