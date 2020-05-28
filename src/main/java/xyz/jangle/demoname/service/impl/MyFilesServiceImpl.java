package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.MyFilesMapper;
import xyz.jangle.demoname.model.MyFiles;
import xyz.jangle.demoname.service.BsUser2Service;
import xyz.jangle.demoname.service.MyFilesService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 文件、资料 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class MyFilesServiceImpl extends BaseServiceImpl implements MyFilesService {

	@Autowired
	private MyFilesMapper myFilesMapper;
	@Autowired
	private BsUser2Service bsUser2Service;
	
	@Override
	public ResultModel<MyFiles> insertOrUpdate(MyFiles record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = myFilesMapper.updateByPrimaryKey(record);
		} else {
			record.setCreatorUuid(Jutils.getUserUuid(bsUser2Service));
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = myFilesMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<MyFiles>(record);
		}
		return new ResultModel<MyFiles>(CME.ERROR);
	}

	@Override
	public ResultModel<MyFiles> deleteByPrimaryKey(MyFiles record) {
		int i = myFilesMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<MyFiles>(CME.SUCCESS);
		}
		logger.error(CME.ERROR.getMessage());
		return new ResultModel<MyFiles>(CME.ERROR);
	}
	
	@Override
	public ResultModel<MyFiles> updateByPrimaryKey(MyFiles record) {
		int i = myFilesMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<MyFiles>(CME.SUCCESS);
		}
		return new ResultModel<MyFiles>(CME.ERROR);
	}
	
	@Override
	public ResultModel<MyFiles> selectByPrimaryKey(MyFiles record) {
		return new ResultModel<MyFiles>(myFilesMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<MyFiles> selectByParam(Map<String, Object> param) {
		List<MyFiles> list = myFilesMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<MyFiles> selectAll() {
		List<MyFiles> list = myFilesMapper.selectAll();
		return new ResultModelList<MyFiles>(list);
	}

	

	@Override
	public ResultModelList<MyFiles> selectPage(MyFiles record) {
		record.setCreatorUuid(Jutils.getUserUuid(bsUser2Service));
		ResultModelList<MyFiles> resultModelList = new ResultModelList<MyFiles>(myFilesMapper.selectPage(record));
		resultModelList.setCount(myFilesMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<MyFiles> batchDeleteByPrimaryKey(MyFiles record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<MyFiles>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		myFilesMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<MyFiles>(CME.SUCCESS);
	}

	@Override
	public ResultModel<MyFiles> batchDeleteByPrimaryKeyActually(MyFiles record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<MyFiles>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		myFilesMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<MyFiles>(CME.SUCCESS);
	}

	@Override
	public ResultModel<MyFiles> selectByPrimaryKeyForAnnotation(MyFiles record) {
		return new ResultModel<MyFiles>(myFilesMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
