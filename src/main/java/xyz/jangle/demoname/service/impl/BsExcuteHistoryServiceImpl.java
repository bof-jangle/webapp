package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsExcuteHistoryMapper;
import xyz.jangle.demoname.model.BsExcuteHistory;
import xyz.jangle.demoname.service.BsExcuteHistoryService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 执行记录表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsExcuteHistoryServiceImpl extends BaseServiceImpl implements BsExcuteHistoryService {

	@Autowired
	private BsExcuteHistoryMapper bsExcuteHistoryMapper;
	
	
	@Override
	public void insertOrUpdate(BsExcuteHistory record) {
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			bsExcuteHistoryMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			record.setStatus(JConstant.status_1);
			bsExcuteHistoryMapper.insert(record);
		}
	}

	@Override
	public ResultModel<BsExcuteHistory> deleteByPrimaryKey(BsExcuteHistory record) {
		int i = bsExcuteHistoryMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsExcuteHistory>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<BsExcuteHistory>(CME.error);
	}
	
	@Override
	public ResultModel<BsExcuteHistory> updateByPrimaryKey(BsExcuteHistory record) {
		int i = bsExcuteHistoryMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsExcuteHistory>(CME.success);
		}
		return new ResultModel<BsExcuteHistory>(CME.error);
	}
	
	@Override
	public ResultModel<BsExcuteHistory> selectByPrimaryKey(BsExcuteHistory record) {
		return new ResultModel<BsExcuteHistory>(bsExcuteHistoryMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsExcuteHistory> selectByParam(Map<String, Object> param) {
		List<BsExcuteHistory> list = bsExcuteHistoryMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsExcuteHistory> selectAll() {
		List<BsExcuteHistory> list = bsExcuteHistoryMapper.selectAll();
		return new ResultModelList<BsExcuteHistory>(list);
	}

	

	@Override
	public ResultModelList<BsExcuteHistory> selectPage(BsExcuteHistory record) {
		ResultModelList<BsExcuteHistory> resultModelList = new ResultModelList<BsExcuteHistory>(bsExcuteHistoryMapper.selectPage(record));
		resultModelList.setCount(bsExcuteHistoryMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsExcuteHistory> batchDeleteByPrimaryKey(BsExcuteHistory record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsExcuteHistory>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsExcuteHistoryMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsExcuteHistory>(CME.success);
	}

	@Override
	public ResultModel<BsExcuteHistory> batchDeleteByPrimaryKeyActually(BsExcuteHistory record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsExcuteHistory>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsExcuteHistoryMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsExcuteHistory>(CME.success);
	}

	@Override
	public ResultModel<BsExcuteHistory> selectByPrimaryKeyForAnnotation(BsExcuteHistory record) {
		return new ResultModel<BsExcuteHistory>(bsExcuteHistoryMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
