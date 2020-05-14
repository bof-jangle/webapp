package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.ZpYanImgMapper;
import xyz.jangle.demoname.model.ZpYanImg;
import xyz.jangle.demoname.service.ZpYanImgService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * yan的作品 业务层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Service
public class ZpYanImgServiceImpl extends BaseServiceImpl implements ZpYanImgService {

	@Autowired
	private ZpYanImgMapper zpYanImgMapper;
	
	
	@Override
	public ResultModel<ZpYanImg> insertOrUpdate(ZpYanImg record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId()) || Jutils.isNotEmpty(record.getUuid())) {
			i = zpYanImgMapper.updateByPrimaryKey(record);
		} else {
			record.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			i = zpYanImgMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<ZpYanImg>(record);
		}
		return new ResultModel<ZpYanImg>(CME.ERROR);
	}

	@Override
	public ResultModel<ZpYanImg> deleteByPrimaryKey(ZpYanImg record) {
		int i = zpYanImgMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<ZpYanImg>(CME.SUCCESS);
		}
		logger.error(CME.ERROR.getMessage());
		return new ResultModel<ZpYanImg>(CME.ERROR);
	}
	
	@Override
	public ResultModel<ZpYanImg> updateByPrimaryKey(ZpYanImg record) {
		int i = zpYanImgMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<ZpYanImg>(CME.SUCCESS);
		}
		return new ResultModel<ZpYanImg>(CME.ERROR);
	}
	
	@Override
	public ResultModel<ZpYanImg> selectByPrimaryKey(ZpYanImg record) {
		return new ResultModel<ZpYanImg>(zpYanImgMapper.selectByPrimaryKey(record.getId()));
	}
	
	@Override
	public ResultModelList<ZpYanImg> selectByParam(Map<String, Object> param) {
		List<ZpYanImg> list = zpYanImgMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}


	@Override
	public ResultModelList<ZpYanImg> selectAll() {
		List<ZpYanImg> list = zpYanImgMapper.selectAll();
		return new ResultModelList<ZpYanImg>(list);
	}

	

	@Override
	public ResultModelList<ZpYanImg> selectPage(ZpYanImg record) {
		ResultModelList<ZpYanImg> resultModelList = new ResultModelList<ZpYanImg>(zpYanImgMapper.selectPage(record));
		resultModelList.setCount(zpYanImgMapper.selectPageCount(record));
		return resultModelList;
	}

	@Override
	public ResultModel<ZpYanImg> batchDeleteByPrimaryKey(ZpYanImg record) {
		if(Jutils.isEmpty(record.getIds())) {
			return new ResultModel<ZpYanImg>(CME.UNFIND_IDS_TO_DELETE);
		}
		record.setIdsArray(record.getIds().split(JConstant.ywdh));
		zpYanImgMapper.batchDeleteByPrimaryKey(record);
		return new ResultModel<ZpYanImg>(CME.SUCCESS);
	}

}
