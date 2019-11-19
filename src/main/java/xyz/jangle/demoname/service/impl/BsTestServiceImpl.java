package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsTestMapper;
import xyz.jangle.demoname.model.BsTest;
import xyz.jangle.demoname.service.BsTestService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 测试表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsTestServiceImpl extends BaseServiceImpl implements BsTestService {

	@Autowired
	private BsTestMapper bsTestMapper;
	
	
	@Override
	public ResultModel<BsTest> insertOrUpdate(BsTest record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsTestMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsTestMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsTest>(record);
		}
		return new ResultModel<BsTest>(CME.error);
	}

	@Override
	public ResultModel<BsTest> deleteByPrimaryKey(BsTest record) {
		int i = bsTestMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsTest>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<BsTest>(CME.error);
	}
	
	@Override
	public ResultModel<BsTest> updateByPrimaryKey(BsTest record) {
		int i = bsTestMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsTest>(CME.success);
		}
		return new ResultModel<BsTest>(CME.error);
	}
	
	@Override
	public ResultModel<BsTest> selectByPrimaryKey(BsTest record) {
		return new ResultModel<BsTest>(bsTestMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsTest> selectByParam(Map<String, Object> param) {
		List<BsTest> list = bsTestMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsTest> selectAll() {
		List<BsTest> list = bsTestMapper.selectAll();
		return new ResultModelList<BsTest>(list);
	}

	

	@Override
	public ResultModelList<BsTest> selectPage(BsTest record) {
		ResultModelList<BsTest> resultModelList = new ResultModelList<BsTest>(bsTestMapper.selectPage(record));
		resultModelList.setCount(bsTestMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsTest> batchDeleteByPrimaryKey(BsTest record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsTest>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsTestMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsTest>(CME.success);
	}

	@Override
	public ResultModel<BsTest> batchDeleteByPrimaryKeyActually(BsTest record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsTest>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsTestMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsTest>(CME.success);
	}
	
	@Override
	public ResultModel<BsTest> selectByPrimaryKeyForAnnotation(BsTest record) {
		return new ResultModel<BsTest>(bsTestMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
