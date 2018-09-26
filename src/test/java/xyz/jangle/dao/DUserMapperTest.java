package xyz.jangle.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.model.DUser;
import xyz.jangle.test.utils.JUnitRunSupport;

public class DUserMapperTest extends JUnitRunSupport {

	@Autowired
	private DUserMapper dUserMapper;

	@Test
	public void testInsert() {
		DUser record = new DUser();
		record.setUsrName("3");
		record.setUsrPassword("3");
		record.setUsrCode("3");
		int insert = dUserMapper.insert(record);
		assertEquals(1, insert);
	}

	@Test
	public void testSelectByCodeAndPassword() {
		DUser record = new DUser();
		record.setUsrCode("jangle");
		record.setUsrPassword("1");
		DUser user = dUserMapper.selectByCodeAndPassword(record);
		assertEquals(1, user.getUsrId().intValue());
	}

}
