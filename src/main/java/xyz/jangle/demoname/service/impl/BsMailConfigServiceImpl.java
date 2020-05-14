package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsMailConfigMapper;
import xyz.jangle.demoname.model.BsMailConfig;
import xyz.jangle.demoname.service.BsMailConfigService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;
import xyz.jangle.utils.ResultModelMap;

/**
 * 邮件配置表 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsMailConfigServiceImpl extends BaseServiceImpl implements BsMailConfigService {

	@Autowired
	private BsMailConfigMapper bsMailConfigMapper;
	
	@Override
	public ResultModel<BsMailConfig> insertOrUpdate(BsMailConfig record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsMailConfigMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsMailConfigMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsMailConfig>(record);
		}
		return new ResultModel<BsMailConfig>(CME.ERROR);
	}

	@Override
	public ResultModel<BsMailConfig> deleteByPrimaryKey(BsMailConfig record) {
		int i = bsMailConfigMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsMailConfig>(CME.SUCCESS);
		}
		logger.error(CME.ERROR.getMessage());
		return new ResultModel<BsMailConfig>(CME.ERROR);
	}
	
	@Override
	public ResultModel<BsMailConfig> updateByPrimaryKey(BsMailConfig record) {
		int i = bsMailConfigMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsMailConfig>(CME.SUCCESS);
		}
		return new ResultModel<BsMailConfig>(CME.ERROR);
	}
	
	@Override
	public ResultModel<BsMailConfig> selectByPrimaryKey(BsMailConfig record) {
		return new ResultModel<BsMailConfig>(bsMailConfigMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsMailConfig> selectByParam(Map<String, Object> param) {
		List<BsMailConfig> list = bsMailConfigMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsMailConfig> selectAll() {
		List<BsMailConfig> list = bsMailConfigMapper.selectAll();
		return new ResultModelList<BsMailConfig>(list);
	}

	

	@Override
	public ResultModelList<BsMailConfig> selectPage(BsMailConfig record) {
		ResultModelList<BsMailConfig> resultModelList = new ResultModelList<BsMailConfig>(bsMailConfigMapper.selectPage(record));
		resultModelList.setCount(bsMailConfigMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsMailConfig> batchDeleteByPrimaryKey(BsMailConfig record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsMailConfig>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsMailConfigMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsMailConfig>(CME.SUCCESS);
	}

	@Override
	public ResultModel<BsMailConfig> batchDeleteByPrimaryKeyActually(BsMailConfig record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsMailConfig>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsMailConfigMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsMailConfig>(CME.SUCCESS);
	}
	
	@Override
	public ResultModel<BsMailConfig> selectByPrimaryKeyForAnnotation(BsMailConfig record) {
		return new ResultModel<BsMailConfig>(bsMailConfigMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

	@Override
	public ResultModelMap<BsMailConfig> getConfigMap() {
		Map<String, Object> map = Jutils.getHashMapSO();
		List<BsMailConfig> all = bsMailConfigMapper.selectAll();
		for(BsMailConfig conf :all) {
			map.put(conf.getMailProperty(), conf.getMailValue());
		}
		return new ResultModelMap<>(map);
	}

}
