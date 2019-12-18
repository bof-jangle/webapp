package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.ZdUserApplyMapper;
import xyz.jangle.demoname.model.BsUser2;
import xyz.jangle.demoname.model.ZdUserApply;
import xyz.jangle.demoname.service.BsMailService;
import xyz.jangle.demoname.service.BsUser2Service;
import xyz.jangle.demoname.service.ZdUserApplyService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 用户申请 业务层
 * 
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class ZdUserApplyServiceImpl extends BaseServiceImpl implements ZdUserApplyService {

	@Autowired
	private ZdUserApplyMapper zdUserApplyMapper;
	@Autowired
	private BsUser2Service BsUser2Service;
	@Autowired
	private BsMailService bsMailService;

	@Override
	public ResultModel<ZdUserApply> insertOrUpdate(ZdUserApply record) {
		if(Jutils.isEmpty(record.getZdUserApplyIp())) {
			return new ResultModel<ZdUserApply>(CME.zdUserApply_ip_unsupport);
		}
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = zdUserApplyMapper.updateByPrimaryKey(record);
		} else {
			// 判断是否已经存在用户申请
			int countByApplyIp = zdUserApplyMapper.countByApplyIp(record);
			if (countByApplyIp > 0) {
				return new ResultModel<ZdUserApply>(CME.zdUserApply_ip_repeat);
			}
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			record.setStatus(JConstant.status_1);
			i = zdUserApplyMapper.insert(record);
			// 发送邮件提醒给管理员
			bsMailService.userApplyMsg(record);
		}
		if (i > 0) {
			return new ResultModel<ZdUserApply>(record);
		}
		return new ResultModel<ZdUserApply>(CME.error);
	}

	@Override
	public ResultModel<ZdUserApply> deleteByPrimaryKey(ZdUserApply record) {
		int i = zdUserApplyMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<ZdUserApply>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<ZdUserApply>(CME.error);
	}

	@Override
	public ResultModel<ZdUserApply> updateByPrimaryKey(ZdUserApply record) {
		int i = zdUserApplyMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<ZdUserApply>(CME.success);
		}
		return new ResultModel<ZdUserApply>(CME.error);
	}

	@Override
	public ResultModel<ZdUserApply> selectByPrimaryKey(ZdUserApply record) {
		return new ResultModel<ZdUserApply>(zdUserApplyMapper.selectByPrimaryKey(record.getId()));
	}

	@Override
	public ResultModelList<ZdUserApply> selectByParam(Map<String, Object> param) {
		List<ZdUserApply> list = zdUserApplyMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}

	@Override
	public ResultModelList<ZdUserApply> selectAll() {
		List<ZdUserApply> list = zdUserApplyMapper.selectAll();
		return new ResultModelList<ZdUserApply>(list);
	}

	@Override
	public ResultModelList<ZdUserApply> selectPage(ZdUserApply record) {
		ResultModelList<ZdUserApply> resultModelList = new ResultModelList<ZdUserApply>(
				zdUserApplyMapper.selectPage(record));
		resultModelList.setCount(zdUserApplyMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<ZdUserApply> batchDeleteByPrimaryKey(ZdUserApply record) {
		if (Jutils.isEmpty(record.getIds())) {
			return new ResultModel<ZdUserApply>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		zdUserApplyMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<ZdUserApply>(CME.success);
	}

	@Override
	public ResultModel<ZdUserApply> selectByPrimaryKeyForAnnotation(ZdUserApply record) {
		return new ResultModel<ZdUserApply>(zdUserApplyMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

	@Override
	public ResultModel<ZdUserApply> pass(ZdUserApply record) {
		ZdUserApply userApply = zdUserApplyMapper.selectByPrimaryKey(record.getId());
		// 1、将信息录入用户表
		BsUser2 bsUser2 = new BsUser2();
		bsUser2.setJgName(userApply.getZdUserName());
		bsUser2.setJgCode(userApply.getZdUserCode());
		bsUser2.setJgApplyIp(userApply.getZdUserApplyIp() + "_apply_" + userApply.getId());
		bsUser2.setJgPassword(Jutils.getUuid());
		bsUser2.setJgApplyReason(userApply.getZdUserApplyReason());
		bsUser2.setStatus(JConstant.status_1);
		ResultModel<BsUser2> resultModel = BsUser2Service.insertOrUpdate(bsUser2);
		if(resultModel.getCode().equals(CME.bsUser2_jgCode_repeat.getCode())) {
			return new ResultModel<ZdUserApply>(CME.bsUser2_jgCode_repeat);
		}
		// 2、更新申请状态为通过
		zdUserApplyMapper.pass(record); // 返回值，更新失败的逻辑待补充
		bsMailService.userApplySuccess(bsUser2);
		return new ResultModel<ZdUserApply>(CME.success);
	}

	@Override
	public ResultModel<ZdUserApply> unPass(ZdUserApply record) {
		// 1、更新申请状态为不通过
		zdUserApplyMapper.unPass(record); // 返回值，更新失败的逻辑待补充
		return new ResultModel<ZdUserApply>(CME.success);
	}

}
