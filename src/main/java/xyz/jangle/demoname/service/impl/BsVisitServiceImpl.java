package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsVisitMapper;
import xyz.jangle.demoname.model.BsVisit;
import xyz.jangle.demoname.service.BsDictService;
import xyz.jangle.demoname.service.BsMailService;
import xyz.jangle.demoname.service.BsVisitService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 访问记录表 业务层
 * 
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsVisitServiceImpl extends BaseServiceImpl implements BsVisitService {

	@Autowired
	private BsVisitMapper bsVisitMapper;
	@Autowired
	private BsMailService bsMailService;
	@Autowired
	private BsDictService bsDictService;

	@Override
	public ResultModel<BsVisit> insertOrUpdate(BsVisit record) {
		if (bsDictService.noRecordForMyIp(record.getDmDesc())) {
			return new ResultModel<BsVisit>(CME.ERROR);
		}
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsVisitMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsVisitMapper.insert(record);
		}
		if (record.getStatus() != null && record.getStatus() == 2) {
			bsMailService.insertOrUpdate(record);
		}
		if (i > 0) {
			long count = bsVisitMapper.count();
			ResultModel<BsVisit> resultModel = new ResultModel<BsVisit>(record);
			resultModel.setCount(count);
			return resultModel;
		}
		return new ResultModel<BsVisit>(CME.ERROR);
	}

	@Override
	public ResultModel<BsVisit> deleteByPrimaryKey(BsVisit record) {
		int i = bsVisitMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsVisit>(CME.SUCCESS);
		}
		logger.error(CME.ERROR.getMessage());
		return new ResultModel<BsVisit>(CME.ERROR);
	}

	@Override
	public ResultModel<BsVisit> updateByPrimaryKey(BsVisit record) {
		int i = bsVisitMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsVisit>(CME.SUCCESS);
		}
		return new ResultModel<BsVisit>(CME.ERROR);
	}

	@Override
	public ResultModel<BsVisit> selectByPrimaryKey(BsVisit record) {
		return new ResultModel<BsVisit>(bsVisitMapper.selectByPrimaryKey(record.getId()));
	}

	@Override
	public ResultModelList<BsVisit> selectByParam(Map<String, Object> param) {
		List<BsVisit> list = bsVisitMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}

	@Override
	public ResultModelList<BsVisit> selectAll() {
		List<BsVisit> list = bsVisitMapper.selectAll();
		return new ResultModelList<BsVisit>(list);
	}

	@Override
	public ResultModelList<BsVisit> selectPage(BsVisit record) {
		ResultModelList<BsVisit> resultModelList = new ResultModelList<BsVisit>(bsVisitMapper.selectPage(record));
		resultModelList.setCount(bsVisitMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsVisit> batchDeleteByPrimaryKey(BsVisit record) {
		if (Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsVisit>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsVisitMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsVisit>(CME.SUCCESS);
	}

	@Override
	public ResultModel<BsVisit> batchDeleteByPrimaryKeyActually(BsVisit record) {
		if (Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsVisit>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsVisitMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<BsVisit>(CME.SUCCESS);
	}

	@Override
	public ResultModel<BsVisit> selectByPrimaryKeyForAnnotation(BsVisit record) {
		return new ResultModel<BsVisit>(bsVisitMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

	@Override
	public ResultModel<BsVisit> count() {
		long count = bsVisitMapper.count();
		ResultModel<BsVisit> resultModel = new ResultModel<BsVisit>();
		resultModel.setCount(count);
		return resultModel;
	}

}
