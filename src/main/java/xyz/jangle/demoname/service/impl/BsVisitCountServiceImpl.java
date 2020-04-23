package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsVisitCountMapper;
import xyz.jangle.demoname.model.BsVisitCount;
import xyz.jangle.demoname.service.BsVisitCountService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 访客统计 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsVisitCountServiceImpl extends BaseServiceImpl implements BsVisitCountService {

	@Autowired
	private BsVisitCountMapper bsVisitCountMapper;
	
	
	@Override
	public ResultModel<BsVisitCount> insertOrUpdate(BsVisitCount record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsVisitCountMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsVisitCountMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsVisitCount>(record);
		}
		return new ResultModel<BsVisitCount>(CME.error);
	}

	@Override
	public ResultModel<BsVisitCount> deleteByPrimaryKey(BsVisitCount record) {
		int i = bsVisitCountMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsVisitCount>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<BsVisitCount>(CME.error);
	}
	
	@Override
	public ResultModel<BsVisitCount> updateByPrimaryKey(BsVisitCount record) {
		int i = bsVisitCountMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsVisitCount>(CME.success);
		}
		return new ResultModel<BsVisitCount>(CME.error);
	}
	
	@Override
	public ResultModel<BsVisitCount> selectByPrimaryKey(BsVisitCount record) {
		return new ResultModel<BsVisitCount>(bsVisitCountMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsVisitCount> selectByParam(Map<String, Object> param) {
		List<BsVisitCount> list = bsVisitCountMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsVisitCount> selectAll() {
		List<BsVisitCount> list = bsVisitCountMapper.selectAll();
		return new ResultModelList<BsVisitCount>(list);
	}

	

	@Override
	public ResultModelList<BsVisitCount> selectPage(BsVisitCount record) {
		ResultModelList<BsVisitCount> resultModelList = new ResultModelList<BsVisitCount>(bsVisitCountMapper.selectPage(record));
		resultModelList.setCount(bsVisitCountMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsVisitCount> batchDeleteByPrimaryKey(BsVisitCount record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsVisitCount>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsVisitCountMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsVisitCount>(CME.success);
	}

	@Override
	public ResultModel<BsVisitCount> batchDeleteByPrimaryKeyActually(BsVisitCount record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsVisitCount>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsVisitCountMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsVisitCount>(CME.success);
	}

	@Override
	public ResultModel<BsVisitCount> selectByPrimaryKeyForAnnotation(BsVisitCount record) {
		return new ResultModel<BsVisitCount>(bsVisitCountMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
