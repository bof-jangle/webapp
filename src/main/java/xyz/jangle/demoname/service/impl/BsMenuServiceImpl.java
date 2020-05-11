package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsMenuMapper;
import xyz.jangle.demoname.model.BsMenu;
import xyz.jangle.demoname.service.BsMenuService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 菜单表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsMenuServiceImpl extends BaseServiceImpl implements BsMenuService {

	@Autowired
	private BsMenuMapper bsMenuMapper;
	
	
	@Override
	public ResultModel<BsMenu> insertOrUpdate(BsMenu record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsMenuMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsMenuMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsMenu>(record);
		}
		return new ResultModel<BsMenu>(CME.error);
	}

	@Override
	public ResultModel<BsMenu> deleteByPrimaryKey(BsMenu record) {
		int i = bsMenuMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsMenu>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<BsMenu>(CME.error);
	}
	
	@Override
	public ResultModel<BsMenu> updateByPrimaryKey(BsMenu record) {
		int i = bsMenuMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsMenu>(CME.success);
		}
		return new ResultModel<BsMenu>(CME.error);
	}
	
	@Override
	public ResultModel<BsMenu> selectByPrimaryKey(BsMenu record) {
		return new ResultModel<BsMenu>(bsMenuMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsMenu> selectByParam(Map<String, Object> param) {
		List<BsMenu> list = bsMenuMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsMenu> selectAll() {
		List<BsMenu> list = bsMenuMapper.selectAll();
		return new ResultModelList<BsMenu>(list);
	}
	
	@Override
	public ResultModelList<BsMenu> selectAllRootMenu() {
		List<BsMenu> list = bsMenuMapper.selectAllRootMenu();
		return new ResultModelList<BsMenu>(list);
	}

	

	@Override
	public ResultModelList<BsMenu> selectPage(BsMenu record) {
		ResultModelList<BsMenu> resultModelList = new ResultModelList<BsMenu>(bsMenuMapper.selectPage(record));
		resultModelList.setCount(bsMenuMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsMenu> batchDeleteByPrimaryKey(BsMenu record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsMenu>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsMenuMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsMenu>(CME.success);
	}

	@Override
	public ResultModel<BsMenu> batchDeleteByPrimaryKeyActually(BsMenu record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsMenu>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsMenuMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsMenu>(CME.success);
	}

	@Override
	public ResultModel<BsMenu> selectByPrimaryKeyForAnnotation(BsMenu record) {
		return new ResultModel<BsMenu>(bsMenuMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
