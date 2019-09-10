package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsAttachmentMapper;
import xyz.jangle.demoname.model.BsAttachment;
import xyz.jangle.demoname.service.BsAttachmentService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 附件上传存放管理 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class BsAttachmentServiceImpl extends BaseServiceImpl implements BsAttachmentService {

	@Autowired
	private BsAttachmentMapper bsAttachmentMapper;
	
	
	@Override
	public ResultModel<BsAttachment> insertOrUpdate(BsAttachment record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = bsAttachmentMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = bsAttachmentMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsAttachment>(record);
		}
		return new ResultModel<BsAttachment>(CME.error);
	}

	@Override
	public ResultModel<BsAttachment> deleteByPrimaryKey(BsAttachment record) {
		int i = bsAttachmentMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsAttachment>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<BsAttachment>(CME.error);
	}
	
	@Override
	public ResultModel<BsAttachment> updateByPrimaryKey(BsAttachment record) {
		int i = bsAttachmentMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsAttachment>(CME.success);
		}
		return new ResultModel<BsAttachment>(CME.error);
	}
	
	@Override
	public ResultModel<BsAttachment> selectByPrimaryKey(BsAttachment record) {
		return new ResultModel<BsAttachment>(bsAttachmentMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<BsAttachment> selectByParam(Map<String, Object> param) {
		List<BsAttachment> list = bsAttachmentMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<BsAttachment> selectAll() {
		List<BsAttachment> list = bsAttachmentMapper.selectAll();
		return new ResultModelList<BsAttachment>(list);
	}

	

	@Override
	public ResultModelList<BsAttachment> selectPage(BsAttachment record) {
		ResultModelList<BsAttachment> resultModelList = new ResultModelList<BsAttachment>(bsAttachmentMapper.selectPage(record));
		resultModelList.setCount(bsAttachmentMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<BsAttachment> batchDeleteByPrimaryKey(BsAttachment record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<BsAttachment>(CME.unFindIdsToDelete);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		bsAttachmentMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<BsAttachment>(CME.success);
	}

}
