package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsFileBitMapper;
import xyz.jangle.demoname.model.BsFileBit;
import xyz.jangle.demoname.service.BsFileBitService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 文件存储表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsFileBitServiceImpl extends BaseServiceImpl implements BsFileBitService {

	@Autowired
	private BsFileBitMapper bsFileBitMapper;
	
	
	@Override
	public ResultModel<BsFileBit> insertOrUpdate(BsFileBit record) {
		int i = 0;
		i = bsFileBitMapper.insert(record);
		if (i > 0) {
			return new ResultModel<BsFileBit>(record);
		}
		return new ResultModel<BsFileBit>(CME.ERROR);
	}
	
	@Override
	public ResultModel<BsFileBit> selectByPrimaryKey(BsFileBit record) {
		return new ResultModel<BsFileBit>(bsFileBitMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsFileBit> selectByParam(Map<String, Object> param) {
		List<BsFileBit> list = bsFileBitMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsFileBit> selectAll() {
		List<BsFileBit> list = bsFileBitMapper.selectAll();
		return new ResultModelList<BsFileBit>(list);
	}

	@Override
	public ResultModelList<BsFileBit> selectPage(BsFileBit record) {
		ResultModelList<BsFileBit> resultModelList = new ResultModelList<BsFileBit>(bsFileBitMapper.selectPage(record));
		resultModelList.setCount(bsFileBitMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsFileBit> batchDeleteByPrimaryKeyActually(BsFileBit record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsFileBit>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsFileBitMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsFileBit>(CME.SUCCESS);
	}

	@Override
	public ResultModel<BsFileBit> selectByPrimaryKeyForAnnotation(BsFileBit record) {
		return new ResultModel<BsFileBit>(bsFileBitMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
