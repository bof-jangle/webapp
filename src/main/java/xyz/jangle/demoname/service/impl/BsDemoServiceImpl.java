package xyz.jangle.demoname.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.demoname.dao.BsDemoMapper;
import xyz.jangle.demoname.model.BsDemo;
import xyz.jangle.demoname.service.BsDemoService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 基础Demo的业务层实现
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2019年1月15日 下午5:12:19 类说明
 */
@Service
public class BsDemoServiceImpl extends BaseServiceImpl implements BsDemoService {

	@Autowired
	private BsDemoMapper bsDemoMapper;

	@Override
	public ResultModel<BsDemo> deleteByPrimaryKey(BsDemo record) {
		int i = bsDemoMapper.deleteByPrimaryKey(record.getId());
		if (i > 0) {
			return new ResultModel<BsDemo>(CME.success);
		}
		logger.error(CME.error.getMessage());
		return new ResultModel<BsDemo>(CME.error);
	}

	@Override
	public ResultModel<BsDemo> insert(BsDemo record) {
		int i = 0;
		if (Jutils.isGreatThan0(record.getId())) {
			i = bsDemoMapper.updateByPrimaryKey(record);
		} else {
			i = bsDemoMapper.insert(record);
		}
		if (i > 0) {
			return new ResultModel<BsDemo>(record);
		}
		return new ResultModel<BsDemo>(CME.error);
	}

	@Override
	public ResultModel<BsDemo> selectByPrimaryKey(BsDemo record) {
		record = bsDemoMapper.selectByPrimaryKey(record.getId());
		return new ResultModel<BsDemo>(record);
	}

	@Override
	public ResultModelList<BsDemo> selectAll() {
		List<BsDemo> list = bsDemoMapper.selectAll();
		return new ResultModelList<BsDemo>(list);
	}

	@Override
	public ResultModelList<BsDemo> selectByParam(Map<String, Object> param) {
		List<BsDemo> list = bsDemoMapper.selectByParam(param);
		return new ResultModelList<>(list);
	}

	@Override
	public ResultModel<BsDemo> updateByPrimaryKey(BsDemo record) {
		int i = bsDemoMapper.updateByPrimaryKey(record);
		if (i > 0) {
			return new ResultModel<BsDemo>(CME.success);
		}
		return new ResultModel<BsDemo>(CME.error);
	}

	@Override
	public ResultModelList<BsDemo> selectPage(BsDemo record) {
		ResultModelList<BsDemo> resultModelList = new ResultModelList<BsDemo>(bsDemoMapper.selectPage(record));
		resultModelList.setCount(bsDemoMapper.selectPageCount(record));
		return resultModelList;
	}

}
