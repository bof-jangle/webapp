package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsRoleMapper;
import xyz.jangle.demoname.model.BsRole;
import xyz.jangle.demoname.service.BsRoleService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 角色管理 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsRoleServiceImpl extends BaseServiceImpl implements BsRoleService {

	@Autowired
	private BsRoleMapper bsRoleMapper;
	
	
	@Override
	public ResultModel<BsRole> insertOrUpdate(BsRole record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsRoleMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsRoleMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsRole>(record);
		}
		return new ResultModel<BsRole>(CME.error);
	}

	@Override
	public ResultModel<BsRole> deleteByPrimaryKey(BsRole record) {
		int i = bsRoleMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsRole>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<BsRole>(CME.error);
	}
	
	@Override
	public ResultModel<BsRole> updateByPrimaryKey(BsRole record) {
		int i = bsRoleMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsRole>(CME.success);
		}
		return new ResultModel<BsRole>(CME.error);
	}
	
	@Override
	public ResultModel<BsRole> selectByPrimaryKey(BsRole record) {
		return new ResultModel<BsRole>(bsRoleMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsRole> selectByParam(Map<String, Object> param) {
		List<BsRole> list = bsRoleMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsRole> selectAll() {
		List<BsRole> list = bsRoleMapper.selectAll();
		return new ResultModelList<BsRole>(list);
	}

	

	@Override
	public ResultModelList<BsRole> selectPage(BsRole record) {
		ResultModelList<BsRole> resultModelList = new ResultModelList<BsRole>(bsRoleMapper.selectPage(record));
		resultModelList.setCount(bsRoleMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsRole> batchDeleteByPrimaryKey(BsRole record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsRole>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsRoleMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsRole>(CME.success);
	}

}
