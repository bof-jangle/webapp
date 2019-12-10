package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsMailMapper;
import xyz.jangle.demoname.model.BsMail;
import xyz.jangle.demoname.service.BsMailService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 邮件发送记录表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsMailServiceImpl extends BaseServiceImpl implements BsMailService {

	@Autowired
	private BsMailMapper bsMailMapper;
	
	
	@Override
	public ResultModel<BsMail> insertOrUpdate(BsMail record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsMailMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsMailMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsMail>(record);
		}
		return new ResultModel<BsMail>(CME.error);
	}

	@Override
	public ResultModel<BsMail> deleteByPrimaryKey(BsMail record) {
		int i = bsMailMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsMail>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<BsMail>(CME.error);
	}
	
	@Override
	public ResultModel<BsMail> updateByPrimaryKey(BsMail record) {
		int i = bsMailMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsMail>(CME.success);
		}
		return new ResultModel<BsMail>(CME.error);
	}
	
	@Override
	public ResultModel<BsMail> selectByPrimaryKey(BsMail record) {
		return new ResultModel<BsMail>(bsMailMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsMail> selectByParam(Map<String, Object> param) {
		List<BsMail> list = bsMailMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsMail> selectAll() {
		List<BsMail> list = bsMailMapper.selectAll();
		return new ResultModelList<BsMail>(list);
	}

	

	@Override
	public ResultModelList<BsMail> selectPage(BsMail record) {
		ResultModelList<BsMail> resultModelList = new ResultModelList<BsMail>(bsMailMapper.selectPage(record));
		resultModelList.setCount(bsMailMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsMail> batchDeleteByPrimaryKey(BsMail record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsMail>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsMailMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsMail>(CME.success);
	}

	@Override
	public ResultModel<BsMail> batchDeleteByPrimaryKeyActually(BsMail record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsMail>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsMailMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsMail>(CME.success);
	}
	
	@Override
	public ResultModel<BsMail> selectByPrimaryKeyForAnnotation(BsMail record) {
		return new ResultModel<BsMail>(bsMailMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
