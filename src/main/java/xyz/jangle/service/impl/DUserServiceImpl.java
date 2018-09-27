package xyz.jangle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.dao.DUserMapper;
import xyz.jangle.model.DUser;
import xyz.jangle.model.DUserExample;
import xyz.jangle.model.User;
import xyz.jangle.service.DUserService;
import xyz.jangle.service.UserService;
import xyz.jangle.utils.CodeMessageEnum;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

@Service
public class DUserServiceImpl implements DUserService {

	@Autowired
	private DUserMapper dUserMapper;
	@Autowired
	private UserService userService;

	@Override
	public ResultModel<DUser> selectByCodeAndPassword(DUser record) {
		return new ResultModel<DUser>(dUserMapper.selectByCodeAndPassword(record));
	}

	@Override
	public ResultModel<DUser> save(DUser dUser) {
		dUserMapper.save(dUser);
//		int i = 1/0;
		return new ResultModel<DUser>(CodeMessageEnum.success);
	}

	@Override
	public ResultModelList<DUser> selectByExample(DUserExample example) {
		ResultModelList<DUser> resultModelList;
		List<DUser> list = dUserMapper.selectByExample(example);
		resultModelList = new ResultModelList<DUser>(list);
		return resultModelList;
	}

	@Override
	public ResultModelList<DUser> nestedTransactionTest() {
		DUser dUser = new DUser();
		dUser.setUsrName("0919");
		dUser.setUsrCode("0919");
		dUser.setUsrPassword("0919");
		ResultModelList<User> resultModelList = userService.save();
		dUserMapper.save(dUser);
		return new ResultModelList<DUser>(resultModelList.getCode(), resultModelList.getMessage());
	}

}
