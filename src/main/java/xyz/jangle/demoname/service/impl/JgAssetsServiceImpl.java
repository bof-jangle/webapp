package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.JgAssetsMapper;
import xyz.jangle.demoname.model.JgAssets;
import xyz.jangle.demoname.service.BsUser2Service;
import xyz.jangle.demoname.service.JgAssetsService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 资产管理 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class JgAssetsServiceImpl extends BaseServiceImpl implements JgAssetsService {

	@Autowired
	private JgAssetsMapper jgAssetsMapper;
	@Autowired
	private BsUser2Service bsUser2Service;
	
	
	@Override
	public ResultModel<JgAssets> insertOrUpdate(JgAssets record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = jgAssetsMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			record.setCreateUuid(Jutils.getUserUuid(bsUser2Service));
			i = jgAssetsMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<JgAssets>(record);
		}
		return new ResultModel<JgAssets>(CME.error);
	}

	@Override
	public ResultModel<JgAssets> deleteByPrimaryKey(JgAssets record) {
		int i = jgAssetsMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<JgAssets>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<JgAssets>(CME.error);
	}
	
	@Override
	public ResultModel<JgAssets> updateByPrimaryKey(JgAssets record) {
		int i = jgAssetsMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<JgAssets>(CME.success);
		}
		return new ResultModel<JgAssets>(CME.error);
	}
	
	@Override
	public ResultModel<JgAssets> selectByPrimaryKey(JgAssets record) {
		return new ResultModel<JgAssets>(jgAssetsMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<JgAssets> selectByParam(Map<String, Object> param) {
		List<JgAssets> list = jgAssetsMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<JgAssets> selectAll() {
		List<JgAssets> list = jgAssetsMapper.selectAll();
		return new ResultModelList<JgAssets>(list);
	}

	

	@Override
	public ResultModelList<JgAssets> selectPage(JgAssets record) {
		record.setCreateUuid(Jutils.getUserUuid(bsUser2Service));
		ResultModelList<JgAssets> resultModelList = new ResultModelList<JgAssets>(jgAssetsMapper.selectPage(record));
		resultModelList.setCount(jgAssetsMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<JgAssets> batchDeleteByPrimaryKey(JgAssets record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<JgAssets>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		jgAssetsMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<JgAssets>(CME.success);
	}

	@Override
	public ResultModel<JgAssets> batchDeleteByPrimaryKeyActually(JgAssets record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<JgAssets>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		jgAssetsMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<JgAssets>(CME.success);
	}

	@Override
	public ResultModel<JgAssets> selectByPrimaryKeyForAnnotation(JgAssets record) {
		return new ResultModel<JgAssets>(jgAssetsMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
