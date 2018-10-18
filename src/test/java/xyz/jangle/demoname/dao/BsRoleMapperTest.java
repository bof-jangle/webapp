package xyz.jangle.demoname.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.dao.BsRoleMapper;
import xyz.jangle.demoname.model.BsRole;
import xyz.jangle.test.utils.JUnitRunSupport;

public class BsRoleMapperTest extends JUnitRunSupport {
	
	@Autowired
	private BsRoleMapper bsRoleMapper;

	@Test
	public void testInsert() {
		BsRole record =new BsRole();
		record.setRolName("2");
		int insert = bsRoleMapper.insert(record );
		System.out.println(insert);
		assertEquals(insert, 1);
	}

}
