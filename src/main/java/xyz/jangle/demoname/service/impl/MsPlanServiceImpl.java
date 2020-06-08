package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.MsPlanMapper;
import xyz.jangle.demoname.model.MsPlan;
import xyz.jangle.demoname.service.MsPlanService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 面试安排 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.12020-06-08 11:34:37
 */
@Service
public class MsPlanServiceImpl extends BaseServiceImpl implements MsPlanService {

	@Autowired
	private MsPlanMapper msPlanMapper;
	
	
	@Override
	public ResultModel<MsPlan> insertOrUpdate(MsPlan record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = msPlanMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = msPlanMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<MsPlan>(record);
		}
		return new ResultModel<MsPlan>(CME.ERROR);
	}

	@Override
	public ResultModel<MsPlan> deleteByPrimaryKey(MsPlan record) {
		int i = msPlanMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<MsPlan>(CME.SUCCESS);
		}
		logger.error(CME.ERROR.getMessage());
		return new ResultModel<MsPlan>(CME.ERROR);
	}
	
	@Override
	public ResultModel<MsPlan> updateByPrimaryKey(MsPlan record) {
		int i = msPlanMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<MsPlan>(CME.SUCCESS);
		}
		return new ResultModel<MsPlan>(CME.ERROR);
	}
	
	@Override
	public ResultModel<MsPlan> selectByPrimaryKey(MsPlan record) {
		return new ResultModel<MsPlan>(msPlanMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<MsPlan> selectByParam(Map<String, Object> param) {
		List<MsPlan> list = msPlanMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<MsPlan> selectAll() {
		List<MsPlan> list = msPlanMapper.selectAll();
		return new ResultModelList<MsPlan>(list);
	}

	

	@Override
	public ResultModelList<MsPlan> selectPage(MsPlan record) {
		ResultModelList<MsPlan> resultModelList = new ResultModelList<MsPlan>(msPlanMapper.selectPage(record));
		resultModelList.setCount(msPlanMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<MsPlan> batchDeleteByPrimaryKey(MsPlan record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<MsPlan>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		msPlanMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<MsPlan>(CME.SUCCESS);
	}

	@Override
	public ResultModel<MsPlan> batchDeleteByPrimaryKeyActually(MsPlan record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<MsPlan>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		msPlanMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<MsPlan>(CME.SUCCESS);
	}

	@Override
	public ResultModel<MsPlan> selectByPrimaryKeyForAnnotation(MsPlan record) {
		return new ResultModel<MsPlan>(msPlanMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
