package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.ResumeAccessRecordMapper;
import xyz.jangle.demoname.model.ResumeAccessRecord;
import xyz.jangle.demoname.service.ResumeAccessRecordService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.JResumeAccessQueue;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 简历访问记录 业务层
 * 
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class ResumeAccessRecordServiceImpl extends BaseServiceImpl implements ResumeAccessRecordService {

	@Autowired
	private ResumeAccessRecordMapper resumeAccessRecordMapper;

	@Override
	public ResultModel<ResumeAccessRecord> insertOrUpdate(ResumeAccessRecord record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = resumeAccessRecordMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = resumeAccessRecordMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<ResumeAccessRecord>(record);
		}
		return new ResultModel<ResumeAccessRecord>(CME.ERROR);
	}

	@Override
	public void doInsertRecordByQueue() {
		logger.info("开始添加resume访问记录");
		while(!JResumeAccessQueue.isEmpty()) {
			ResumeAccessRecord record = JResumeAccessQueue.poll();
			if(record.getResumeUri() == null || record.getResumeUri().contains("Access")) {
				continue;
			}
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			resumeAccessRecordMapper.insert(record);
		}
		logger.info("完成添加resume访问记录");
	}

	@Override
	public ResultModel<ResumeAccessRecord> deleteByPrimaryKey(ResumeAccessRecord record) {
		int i = resumeAccessRecordMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<ResumeAccessRecord>(CME.SUCCESS);
		}
		logger.error(CME.ERROR.getMessage());
		return new ResultModel<ResumeAccessRecord>(CME.ERROR);
	}

	@Override
	public ResultModel<ResumeAccessRecord> updateByPrimaryKey(ResumeAccessRecord record) {
		int i = resumeAccessRecordMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<ResumeAccessRecord>(CME.SUCCESS);
		}
		return new ResultModel<ResumeAccessRecord>(CME.ERROR);
	}

	@Override
	public ResultModel<ResumeAccessRecord> selectByPrimaryKey(ResumeAccessRecord record) {
		return new ResultModel<ResumeAccessRecord>(resumeAccessRecordMapper.selectByPrimaryKey(record.getId()));
	}

	@Override
	public ResultModelList<ResumeAccessRecord> selectByParam(Map<String, Object> param) {
		List<ResumeAccessRecord> list = resumeAccessRecordMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}

	@Override
	public ResultModelList<ResumeAccessRecord> selectAll() {
		List<ResumeAccessRecord> list = resumeAccessRecordMapper.selectAll();
		return new ResultModelList<ResumeAccessRecord>(list);
	}

	@Override
	public ResultModelList<ResumeAccessRecord> selectPage(ResumeAccessRecord record) {
		ResultModelList<ResumeAccessRecord> resultModelList = new ResultModelList<ResumeAccessRecord>(
				resumeAccessRecordMapper.selectPage(record));
		resultModelList.setCount(resumeAccessRecordMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<ResumeAccessRecord> batchDeleteByPrimaryKey(ResumeAccessRecord record) {
		if (Jutils.isEmpty(record.getIds())) {
			return new ResultModel<ResumeAccessRecord>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		resumeAccessRecordMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<ResumeAccessRecord>(CME.SUCCESS);
	}

	@Override
	public ResultModel<ResumeAccessRecord> batchDeleteByPrimaryKeyActually(ResumeAccessRecord record) {
		if (Jutils.isEmpty(record.getIds())) {
			return new ResultModel<ResumeAccessRecord>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		resumeAccessRecordMapper.batchDeleteByPrimaryKeyActually(record);
		return new ResultModel<ResumeAccessRecord>(CME.SUCCESS);
	}

	@Override
	public ResultModel<ResumeAccessRecord> selectByPrimaryKeyForAnnotation(ResumeAccessRecord record) {
		return new ResultModel<ResumeAccessRecord>(
				resumeAccessRecordMapper.selectByPrimaryKeyForAnnotation(record.getId()));
	}

}
