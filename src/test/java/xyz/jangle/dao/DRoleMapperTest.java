package xyz.jangle.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.model.DRole;
import xyz.jangle.test.utils.JUnitRunSupport;

public class DRoleMapperTest extends JUnitRunSupport {
	
	@Autowired
	private DRoleMapper dRoleMapper;

	@Test
	public void testInsert() {
		DRole record =new DRole();
		record.setRolName("2");
		int insert = dRoleMapper.insert(record );
		System.out.println(insert);
		assertEquals(insert, 1);
	}

}
