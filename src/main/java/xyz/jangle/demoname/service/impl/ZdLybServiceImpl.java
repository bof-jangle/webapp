package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.ZdLybMapper;
import xyz.jangle.demoname.model.BsUser;
import xyz.jangle.demoname.model.ZdLyb;
import xyz.jangle.demoname.service.BsUserService;
import xyz.jangle.demoname.service.ZdLybService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 战队留言板 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class ZdLybServiceImpl extends BaseServiceImpl implements ZdLybService {

	@Autowired
	private ZdLybMapper zdLybMapper;
	
	@Autowired
	private BsUserService bsUserService;
	
	
	@Override
	public ResultModel<ZdLyb> insertOrUpdate(ZdLyb record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = zdLybMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			BsUser currentUser = bsUserService.currentLoggedIn().getModel();
			if(JConstant.youke.equals(currentUser.getUsrName())) {
				record.setZdLyr(currentUser.getCity()+currentUser.getUsrName()+currentUser.getIp());
			}else {
				record.setZdLyr(currentUser.getUsrName());
			}
			record.setZdLyrUuid("useruuid"+currentUser.getId());
			i = zdLybMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<ZdLyb>(record);
		}
		return new ResultModel<ZdLyb>(CME.error);
	}

	@Override
	public ResultModel<ZdLyb> deleteByPrimaryKey(ZdLyb record) {
		int i = zdLybMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<ZdLyb>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<ZdLyb>(CME.error);
	}
	
	@Override
	public ResultModel<ZdLyb> updateByPrimaryKey(ZdLyb record) {
		int i = zdLybMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<ZdLyb>(CME.success);
		}
		return new ResultModel<ZdLyb>(CME.error);
	}
	
	@Override
	public ResultModel<ZdLyb> selectByPrimaryKey(ZdLyb record) {
		return new ResultModel<ZdLyb>(zdLybMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<ZdLyb> selectByParam(Map<String, Object> param) {
		List<ZdLyb> list = zdLybMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<ZdLyb> selectAll() {
		List<ZdLyb> list = zdLybMapper.selectAll();
		return new ResultModelList<ZdLyb>(list);
	}

	

	@Override
	public ResultModelList<ZdLyb> selectPage(ZdLyb record) {
		ResultModelList<ZdLyb> resultModelList = new ResultModelList<ZdLyb>(zdLybMapper.selectPage(record));
		resultModelList.setCount(zdLybMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<ZdLyb> batchDeleteByPrimaryKey(ZdLyb record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<ZdLyb>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		zdLybMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<ZdLyb>(CME.success);
	}

}
