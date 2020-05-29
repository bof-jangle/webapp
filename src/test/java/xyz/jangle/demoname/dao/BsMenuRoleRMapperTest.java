package xyz.jangle.demoname.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.vo.BsMenuRoleRVo;
import xyz.jangle.test.utils.JUnitRunSupport;

public class BsMenuRoleRMapperTest extends JUnitRunSupport {
	
	@Autowired
	BsMenuRoleRMapper bsMenuRoleRMapper;

	@Test
	@Ignore
	public void testSelectByRoleId() {
		List<BsMenuRoleRVo> list = bsMenuRoleRMapper.selectByRoleId(9L);
		assertEquals(Long.valueOf(227L), list.get(0).getMenuId());
	}

}
