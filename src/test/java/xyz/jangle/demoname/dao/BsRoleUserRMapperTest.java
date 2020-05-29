package xyz.jangle.demoname.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.vo.BsRoleUserRVo;
import xyz.jangle.test.utils.JUnitRunSupport;

public class BsRoleUserRMapperTest extends JUnitRunSupport {
	
	@Autowired
	BsRoleUserRMapper bsRoleUserRMapper;

	@Test
	@Ignore
	public void testSelectByRoleId() {
		List<BsRoleUserRVo> list = bsRoleUserRMapper.selectByRoleId(9L);
		assertTrue(list.get(0).getBsUserUuid().equals("1"));
		
	}

}
