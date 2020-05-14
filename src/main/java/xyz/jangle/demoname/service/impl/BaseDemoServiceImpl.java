package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BaseDemoMapper;
import xyz.jangle.demoname.model.BaseDemo;
import xyz.jangle.demoname.service.BaseDemoService;
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
public class BaseDemoServiceImpl extends BaseServiceImpl implements BaseDemoService {

	@Autowired
	private BaseDemoMapper baseDemoMapper;
	
	
	@Override
	public ResultModel<BaseDemo> insertOrUpdate(BaseDemo record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = baseDemoMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = baseDemoMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BaseDemo>(record);
		}
		return new ResultModel<BaseDemo>(CME.ERROR);
	}

	@Override
	public ResultModel<BaseDemo> deleteByPrimaryKey(BaseDemo record) {
		int i = baseDemoMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BaseDemo>(CME.SUCCESS);
		}
		logger.error(CME.ERROR.getMessage());
		return new ResultModel<BaseDemo>(CME.ERROR);
	}
	
	@Override
	public ResultModel<BaseDemo> updateByPrimaryKey(BaseDemo record) {
		int i = baseDemoMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BaseDemo>(CME.SUCCESS);
		}
		return new ResultModel<BaseDemo>(CME.ERROR);
	}
	
	@Override
	public ResultModel<BaseDemo> selectByPrimaryKey(BaseDemo record) {
		return new ResultModel<BaseDemo>(baseDemoMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BaseDemo> selectByParam(Map<String, Object> param) {
		List<BaseDemo> list = baseDemoMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BaseDemo> selectAll() {
		List<BaseDemo> list = baseDemoMapper.selectAll();
		return new ResultModelList<BaseDemo>(list);
	}

	

	@Override
	public ResultModelList<BaseDemo> selectPage(BaseDemo record) {
		ResultModelList<BaseDemo> resultModelList = new ResultModelList<BaseDemo>(baseDemoMapper.selectPage(record));
		resultModelList.setCount(baseDemoMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BaseDemo> batchDeleteByPrimaryKey(BaseDemo record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BaseDemo>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		baseDemoMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BaseDemo>(CME.SUCCESS);
	}

	@Override
	public ResultModel<BaseDemo> batchDeleteByPrimaryKeyActually(BaseDemo record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BaseDemo>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		baseDemoMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BaseDemo>(CME.SUCCESS);
	}
	
	@Override
	public ResultModel<BaseDemo> selectByPrimaryKeyForAnnotation(BaseDemo record) {
		return new ResultModel<BaseDemo>(baseDemoMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
