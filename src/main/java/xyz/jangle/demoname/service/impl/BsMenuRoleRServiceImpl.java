package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsMenuRoleRMapper;
import xyz.jangle.demoname.model.BsMenuRoleR;
import xyz.jangle.demoname.service.BsMenuRoleRService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 基础框架的基础Demo 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsMenuRoleRServiceImpl extends BaseServiceImpl implements BsMenuRoleRService {

	@Autowired
	private BsMenuRoleRMapper bsMenuRoleRMapper;
	
	
	@Override
	public ResultModel<BsMenuRoleR> insertOrUpdate(BsMenuRoleR record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsMenuRoleRMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsMenuRoleRMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsMenuRoleR>(record);
		}
		return new ResultModel<BsMenuRoleR>(CME.error);
	}

	@Override
	public ResultModel<BsMenuRoleR> deleteByPrimaryKey(BsMenuRoleR record) {
		int i = bsMenuRoleRMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsMenuRoleR>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<BsMenuRoleR>(CME.error);
	}
	
	@Override
	public ResultModel<BsMenuRoleR> updateByPrimaryKey(BsMenuRoleR record) {
		int i = bsMenuRoleRMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsMenuRoleR>(CME.success);
		}
		return new ResultModel<BsMenuRoleR>(CME.error);
	}
	
	@Override
	public ResultModel<BsMenuRoleR> selectByPrimaryKey(BsMenuRoleR record) {
		return new ResultModel<BsMenuRoleR>(bsMenuRoleRMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsMenuRoleR> selectByParam(Map<String, Object> param) {
		List<BsMenuRoleR> list = bsMenuRoleRMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsMenuRoleR> selectAll() {
		List<BsMenuRoleR> list = bsMenuRoleRMapper.selectAll();
		return new ResultModelList<BsMenuRoleR>(list);
	}

	

	@Override
	public ResultModelList<BsMenuRoleR> selectPage(BsMenuRoleR record) {
		ResultModelList<BsMenuRoleR> resultModelList = new ResultModelList<BsMenuRoleR>(bsMenuRoleRMapper.selectPage(record));
		resultModelList.setCount(bsMenuRoleRMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsMenuRoleR> batchDeleteByPrimaryKey(BsMenuRoleR record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsMenuRoleR>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsMenuRoleRMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsMenuRoleR>(CME.success);
	}

	@Override
	public ResultModel<BsMenuRoleR> batchDeleteByPrimaryKeyActually(BsMenuRoleR record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsMenuRoleR>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsMenuRoleRMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsMenuRoleR>(CME.success);
	}

	@Override
	public ResultModel<BsMenuRoleR> selectByPrimaryKeyForAnnotation(BsMenuRoleR record) {
		return new ResultModel<BsMenuRoleR>(bsMenuRoleRMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
