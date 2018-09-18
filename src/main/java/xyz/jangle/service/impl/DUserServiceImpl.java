package xyz.jangle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.jangle.dao.DUserMapper;
import xyz.jangle.model.DUser;
import xyz.jangle.model.DUserExample;
import xyz.jangle.service.DUserService;

@Service
public class DUserServiceImpl implements DUserService {

	@Autowired
	private DUserMapper dUserMapper;

	@Override
	public int save(DUser dUser) {
		dUserMapper.save(dUser);
		return 0;
	}

	@Override
	public List<DUser> selectByExample(DUserExample example) {
		List<DUser> list = dUserMapper.selectByExample(example);
		return list;
	}

}
