package xyz.jangle.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.dao.DUserMapper;
import xyz.jangle.model.DUser;
import xyz.jangle.model.DUserExample;
import xyz.jangle.model.DemoModel;
import xyz.jangle.service.BaseService;
import xyz.jangle.service.DUserService;
import xyz.jangle.service.DemoService;
import xyz.jangle.utils.CodeMessageEnum;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;
import xyz.jangle.utils.UserCacheMap;

@Service
public class DUserServiceImpl extends BaseService implements DUserService {

	@Autowired
	private DUserMapper dUserMapper;
	@Autowired
	private DemoService demoService;
	@Autowired
	private HttpSession httpSession;		//这个session由Spring注入
	//这应该是个代理对象，对于它的调用，其本身会委托给当前的Session对象执行对应的方法，返回对应的返回值。

	@Override
	public ResultModel<DUser> login(String code, String password, HttpSession httpSession2) {
		// 从缓存中校验用户
		DUser dUserCache = UserCacheMap.get(code + "&" + password);
		if (dUserCache != null) {
			// 登陆成功
			loginSuccess(httpSession, dUserCache);
			return new ResultModel<DUser>(dUserCache);
		}
		// 缓存中未通过则从数据库校验
		DUser record = new DUser();
		record.setUsrCode(code);
		record.setUsrPassword(password);
		DUser model = dUserMapper.selectByCodeAndPassword(record);
		// 数据库校验未通过，则提示错误
		if (model == null) {
			return new ResultModel<DUser>(CodeMessageEnum.loginFailed);
		}
		model.setUsrPassword(""); // 将密码置空
		// 数据库校验通过后，将信息进行缓存
		UserCacheMap.put("" + model.getUsrId(), model); // 登陆成功后，缓存用户信息
		UserCacheMap.put(model.getUsrCode() + "&" + password, model); // 登陆成功后，缓存用户信息
		loginSuccess(httpSession, model);
		return new ResultModel<DUser>(model);
	}

	@Override
	public ResultModel<DUser> currentLoggedIn() {
		System.out.println("当前用户userName:" + httpSession.getAttribute("userName"));
		System.out.println("当前用户userId:" + httpSession.getAttribute("userId"));
		System.out.println(this);				//对象是单列的。
		System.out.println(httpSession);		//对象的属性却是不一样的。这是个代理对象。
		Object userId = httpSession.getAttribute("userId");
		if (userId == null) {
			// 未登录或者session失效
			return new ResultModel<>(CodeMessageEnum.unlogin);
		}
		logger.debug("userId:" + Integer.valueOf("" + userId));
//		DUser dUser = dUserMapper.selectByPrimaryKey(Integer.valueOf(""+userId));
		DUser dUser = UserCacheMap.get("" + userId); // 如果登陆过，则缓存中会有信息。
		return new ResultModel<DUser>(dUser);
	}

	@Override
	public ResultModel<DUser> selectByCodeAndPassword(DUser record) {
		return new ResultModel<DUser>(dUserMapper.selectByCodeAndPassword(record));
	}

	@Override
	public ResultModel<DUser> save(DUser dUser) {
		dUserMapper.save(dUser);
//		int i = 1/0;
		return new ResultModel<DUser>(CodeMessageEnum.success);
	}

	@Override
	public ResultModelList<DUser> selectByExample(DUserExample example) {
		ResultModelList<DUser> resultModelList;
		List<DUser> list = dUserMapper.selectByExample(example);
		resultModelList = new ResultModelList<DUser>(list);
		return resultModelList;
	}

	@Override
	public ResultModelList<DUser> nestedTransactionTest() {
		DUser dUser = new DUser();
		dUser.setUsrName("0919");
		dUser.setUsrCode("0919");
		dUser.setUsrPassword("0919");
		ResultModelList<DemoModel> resultModelList = demoService.save();
		dUserMapper.save(dUser);
		return new ResultModelList<DUser>(resultModelList.getCode(), resultModelList.getMessage());
	}

	/**
	 * 登陆成功执行内容
	 * @param httpSession
	 * @param model
	 */
	private void loginSuccess(HttpSession httpSession, DUser model) {
		httpSession.setAttribute("userName", model.getUsrName());
		httpSession.setAttribute("userId", model.getUsrId().intValue());
	}

}
