package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsRoleUserRMapper;
import xyz.jangle.demoname.model.BsRoleUserR;
import xyz.jangle.demoname.service.BsRoleUserRService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 *  业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsRoleUserRServiceImpl extends BaseServiceImpl implements BsRoleUserRService {

	@Autowired
	private BsRoleUserRMapper bsRoleUserRMapper;
	
	
	@Override
	public ResultModel<BsRoleUserR> insertOrUpdate(BsRoleUserR record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsRoleUserRMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsRoleUserRMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsRoleUserR>(record);
		}
		return new ResultModel<BsRoleUserR>(CME.error);
	}

	@Override
	public ResultModel<BsRoleUserR> deleteByPrimaryKey(BsRoleUserR record) {
		int i = bsRoleUserRMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsRoleUserR>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<BsRoleUserR>(CME.error);
	}
	
	@Override
	public ResultModel<BsRoleUserR> updateByPrimaryKey(BsRoleUserR record) {
		int i = bsRoleUserRMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsRoleUserR>(CME.success);
		}
		return new ResultModel<BsRoleUserR>(CME.error);
	}
	
	@Override
	public ResultModel<BsRoleUserR> selectByPrimaryKey(BsRoleUserR record) {
		return new ResultModel<BsRoleUserR>(bsRoleUserRMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsRoleUserR> selectByParam(Map<String, Object> param) {
		List<BsRoleUserR> list = bsRoleUserRMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsRoleUserR> selectAll() {
		List<BsRoleUserR> list = bsRoleUserRMapper.selectAll();
		return new ResultModelList<BsRoleUserR>(list);
	}

	

	@Override
	public ResultModelList<BsRoleUserR> selectPage(BsRoleUserR record) {
		ResultModelList<BsRoleUserR> resultModelList = new ResultModelList<BsRoleUserR>(bsRoleUserRMapper.selectPage(record));
		resultModelList.setCount(bsRoleUserRMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsRoleUserR> batchDeleteByPrimaryKey(BsRoleUserR record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsRoleUserR>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsRoleUserRMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsRoleUserR>(CME.success);
	}

	@Override
	public ResultModel<BsRoleUserR> batchDeleteByPrimaryKeyActually(BsRoleUserR record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsRoleUserR>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsRoleUserRMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsRoleUserR>(CME.success);
	}

	@Override
	public ResultModel<BsRoleUserR> selectByPrimaryKeyForAnnotation(BsRoleUserR record) {
		return new ResultModel<BsRoleUserR>(bsRoleUserRMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
