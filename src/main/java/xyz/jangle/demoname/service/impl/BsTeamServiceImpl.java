package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsTeamMapper;
import xyz.jangle.demoname.model.BsTeam;
import xyz.jangle.demoname.service.BsTeamService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 队伍管理 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsTeamServiceImpl extends BaseServiceImpl implements BsTeamService {

	@Autowired
	private BsTeamMapper bsTeamMapper;
	
	
	@Override
	public ResultModel<BsTeam> insertOrUpdate(BsTeam record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsTeamMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsTeamMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsTeam>(record);
		}
		return new ResultModel<BsTeam>(CME.ERROR);
	}

	@Override
	public ResultModel<BsTeam> deleteByPrimaryKey(BsTeam record) {
		int i = bsTeamMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsTeam>(CME.SUCCESS);
		}
		logger.error(CME.ERROR.getMessage());
		return new ResultModel<BsTeam>(CME.ERROR);
	}
	
	@Override
	public ResultModel<BsTeam> updateByPrimaryKey(BsTeam record) {
		int i = bsTeamMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsTeam>(CME.SUCCESS);
		}
		return new ResultModel<BsTeam>(CME.ERROR);
	}
	
	@Override
	public ResultModel<BsTeam> selectByPrimaryKey(BsTeam record) {
		return new ResultModel<BsTeam>(bsTeamMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsTeam> selectByParam(Map<String, Object> param) {
		List<BsTeam> list = bsTeamMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsTeam> selectAll() {
		List<BsTeam> list = bsTeamMapper.selectAll();
		return new ResultModelList<BsTeam>(list);
	}

	

	@Override
	public ResultModelList<BsTeam> selectPage(BsTeam record) {
		ResultModelList<BsTeam> resultModelList = new ResultModelList<BsTeam>(bsTeamMapper.selectPage(record));
		resultModelList.setCount(bsTeamMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsTeam> batchDeleteByPrimaryKey(BsTeam record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsTeam>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsTeamMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsTeam>(CME.SUCCESS);
	}

	@Override
	public ResultModel<BsTeam> batchDeleteByPrimaryKeyActually(BsTeam record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsTeam>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsTeamMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsTeam>(CME.SUCCESS);
	}

	@Override
	public ResultModel<BsTeam> selectByPrimaryKeyForAnnotation(BsTeam record) {
		return new ResultModel<BsTeam>(bsTeamMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
