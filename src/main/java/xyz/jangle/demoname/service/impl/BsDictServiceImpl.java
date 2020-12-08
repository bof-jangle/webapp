package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsDictMapper;
import xyz.jangle.demoname.model.BsDict;
import xyz.jangle.demoname.service.BsDictService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 字典表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsDictServiceImpl extends BaseServiceImpl implements BsDictService {

	@Autowired
	private BsDictMapper bsDictMapper;
	private volatile List<String> myIps = null;
	
	
	@Override
	public ResultModel<BsDict> insertOrUpdate(BsDict record) {
		int i = 0;
		myIps = null;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsDictMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsDictMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsDict>(record);
		}
		return new ResultModel<BsDict>(CME.ERROR);
	}

	@Override
	public ResultModel<BsDict> deleteByPrimaryKey(BsDict record) {
		int i = bsDictMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsDict>(CME.SUCCESS);
		}
		logger.error(CME.ERROR.getMessage());
		return new ResultModel<BsDict>(CME.ERROR);
	}
	
	@Override
	public ResultModel<BsDict> updateByPrimaryKey(BsDict record) {
		int i = bsDictMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsDict>(CME.SUCCESS);
		}
		return new ResultModel<BsDict>(CME.ERROR);
	}
	
	@Override
	public ResultModel<BsDict> selectByPrimaryKey(BsDict record) {
		return new ResultModel<BsDict>(bsDictMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsDict> selectByParam(Map<String, Object> param) {
		List<BsDict> list = bsDictMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsDict> selectAll() {
		List<BsDict> list = bsDictMapper.selectAll();
		return new ResultModelList<BsDict>(list);
	}

	

	@Override
	public ResultModelList<BsDict> selectPage(BsDict record) {
		ResultModelList<BsDict> resultModelList = new ResultModelList<BsDict>(bsDictMapper.selectPage(record));
		resultModelList.setCount(bsDictMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsDict> batchDeleteByPrimaryKey(BsDict record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsDict>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsDictMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsDict>(CME.SUCCESS);
	}

	@Override
	public ResultModel<BsDict> batchDeleteByPrimaryKeyActually(BsDict record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsDict>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsDictMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsDict>(CME.SUCCESS);
	}

	@Override
	public ResultModel<BsDict> selectByPrimaryKeyForAnnotation(BsDict record) {
		return new ResultModel<BsDict>(bsDictMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}
	
	@Override
	public boolean noRecordForMyIp(String ip) {
		if (myIps  == null) {
			myIps = bsDictMapper.selectValueByKey("myIp");
		}
		if (myIps != null && myIps.contains(ip)) {
			return true;
		}
		return false;
	}

}
