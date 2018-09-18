package xyz.jangle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.dao.DUserMapper;
import xyz.jangle.model.DUser;
import xyz.jangle.model.DUserExample;
import xyz.jangle.service.DUserService;
import xyz.jangle.utils.CodeMessageEnum;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

@Service
public class DUserServiceImpl implements DUserService {

	@Autowired
	private DUserMapper dUserMapper;

	@Override
	public ResultModel<DUser> save(DUser dUser) {
		dUserMapper.save(dUser);
		return new ResultModel<DUser>(CodeMessageEnum.success);
	}

	@Override
	public ResultModelList<DUser> selectByExample(DUserExample example) {
		ResultModelList<DUser> resultModelList;
		List<DUser> list = dUserMapper.selectByExample(example);
		resultModelList = new ResultModelList<DUser>(list);
		return resultModelList;
	}

}
