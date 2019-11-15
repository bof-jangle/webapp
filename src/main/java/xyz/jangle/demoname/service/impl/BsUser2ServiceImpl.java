package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsUser2Mapper;
import xyz.jangle.demoname.model.BsUser2;
import xyz.jangle.demoname.service.BsUser2Service;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;
import xyz.jangle.utils.UserCacheMap2;

/**
 * 用户表V2 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsUser2ServiceImpl extends BaseServiceImpl implements BsUser2Service {

	@Autowired
	private BsUser2Mapper bsUser2Mapper;
	/*
	 * required=false，当在单元测试时，该session可为null，使其启动不报错。（也可通过mockSession则无需如此设置）
	 * 这应该是个代理对象，对于它的调用，其本身会委托给当前的Session对象执行对应的方法，返回对应的返回值。
	 */
	@Autowired(required = false)
	private HttpSession httpSession; // 这个session由Spring注入，
	
	
	@Override
	public ResultModel<BsUser2> insertOrUpdate(BsUser2 record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsUser2Mapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsUser2Mapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsUser2>(record);
		}
		return new ResultModel<BsUser2>(CME.error);
	}

	@Override
	public ResultModel<BsUser2> deleteByPrimaryKey(BsUser2 record) {
		int i = bsUser2Mapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsUser2>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<BsUser2>(CME.error);
	}
	
	@Override
	public ResultModel<BsUser2> updateByPrimaryKey(BsUser2 record) {
		int i = bsUser2Mapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsUser2>(CME.success);
		}
		return new ResultModel<BsUser2>(CME.error);
	}
	
	@Override
	public ResultModel<BsUser2> selectByPrimaryKey(BsUser2 record) {
		return new ResultModel<BsUser2>(bsUser2Mapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsUser2> selectByParam(Map<String, Object> param) {
		List<BsUser2> list = bsUser2Mapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsUser2> selectAll() {
		List<BsUser2> list = bsUser2Mapper.selectAll();
		return new ResultModelList<BsUser2>(list);
	}

	

	@Override
	public ResultModelList<BsUser2> selectPage(BsUser2 record) {
		ResultModelList<BsUser2> resultModelList = new ResultModelList<BsUser2>(bsUser2Mapper.selectPage(record));
		resultModelList.setCount(bsUser2Mapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsUser2> batchDeleteByPrimaryKey(BsUser2 record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsUser2>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsUser2Mapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsUser2>(CME.success);
	}
	
	@Override
	public ResultModel<BsUser2> selectByPrimaryKeyForAnnotation(BsUser2 record) {
		return new ResultModel<BsUser2>(bsUser2Mapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

	@Override
	public ResultModel<BsUser2> currentLoggedIn() {
		/*
		 * logger.info("当前用户userName:" + httpSession.getAttribute("userName"));
		 * logger.info("当前用户userId:" + httpSession.getAttribute("userId"));
		 * logger.info(this); // 对象是单列的。 logger.info(httpSession); //
		 * 对象的属性却是不一样的。这是个代理对象。
		 */		
		Object code;
		try {
			code = httpSession.getAttribute(JConstant.code);
		} catch (Exception e) {
			logger.error("获取Session的code属性时异常",e);
			return new ResultModel<>(CME.unlogin);
		}
		logger.debug("bsUser2.code:" +  code);
		BsUser2 BsUser2 = UserCacheMap2.get(UserCacheMap2.codePrev + code); // 如果登陆过，则缓存中会有信息。
		return new ResultModel<BsUser2>(BsUser2);
	}

	@Override
	public ResultModel<BsUser2> login(String code, String password,String timeStamp) {
		// 从缓存中获取用户
		BsUser2 model = UserCacheMap2.get(UserCacheMap2.codePrev+code);
		if (model == null) {
			// 缓存中无记录则从数据库获取
			BsUser2 record = new BsUser2();
			record.setJgCode(code);
			model = bsUser2Mapper.selectByCode(record);
		}
		// 数据库校验未通过，则提示错误
		if (model == null || !verifiedPassword(code,password,timeStamp,model)) {
			return new ResultModel<BsUser2>(CME.loginFailed);
		}
//		model.setJgPassword(""); // 将密码置空
		model.setCity((String) httpSession.getAttribute(JConstant.city));
		model.setIp((String) httpSession.getAttribute(JConstant.ip));
		// 数据库校验通过后，将信息进行缓存
//		UserCacheMap2.put("" + model.getId(), model); // 登陆成功后，缓存用户信息
		UserCacheMap2.put(UserCacheMap2.codePrev+model.getJgCode(), model); // 登陆成功后，缓存用户信息
		loginSuccess(httpSession, model);
		return new ResultModel<BsUser2>(model);
	}


	@Override
	public ResultModel<BsUser2> logout() {
		httpSession.removeAttribute(JConstant.code);
		httpSession.removeAttribute(JConstant.name);
		httpSession.removeAttribute(JConstant.id);
		httpSession.invalidate();
		ResultModel<BsUser2> resultModel = new ResultModel<BsUser2>();
		resultModel.setMessage("注销成功");
		return resultModel;
	}

	@Override
	public ResultModel<BsUser2> passApply(BsUser2 bsUser2) {
		bsUser2.setStatus(JConstant.status_1);
		if(bsUser2Mapper.updateStatusById(bsUser2) == 1) {
			return new ResultModel<BsUser2>(CME.success);
		}
		return new ResultModel<>(CME.error);
	}

	@Override
	public ResultModel<BsUser2> noPassApply(BsUser2 bsUser2) {
		bsUser2.setStatus(JConstant.status_4);
		if(bsUser2Mapper.updateStatusById(bsUser2) == 1) {
			return new ResultModel<BsUser2>(CME.success);
		}
		return new ResultModel<>(CME.error);
	}
	
	
	
	@Override
	public ResultModel<BsUser2> selectByCode(BsUser2 bsUser2) {
		return new ResultModel<BsUser2>(bsUser2Mapper.selectByCode(bsUser2));
	}

	/**
	 * 登陆成功执行内容
	 * 
	 * @param httpSession
	 * @param model
	 */
	private void loginSuccess(HttpSession httpSession, BsUser2 model) {
		httpSession.setAttribute(JConstant.code, model.getJgCode());
		httpSession.setAttribute(JConstant.name, model.getJgName());
		httpSession.setAttribute(JConstant.id, model.getId().intValue());
	}

	/**
	 * 校验密码
	 * @param code
	 * @param password
	 * @param timeStamp
	 * @param model
	 * @return true 通过 ， false 不通过
	 */
	private boolean verifiedPassword(String code, String password, String timeStamp, BsUser2 model) {
		// TODO 这里添加密码的加密逻辑，以及判断加密后密码是否一致
		if(model.getJgPassword() != null && model.getJgPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
//		return true;
	}
}
