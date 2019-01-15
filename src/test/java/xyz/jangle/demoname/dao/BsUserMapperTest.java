package xyz.jangle.demoname.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.dao.BsUserMapper;
import xyz.jangle.demoname.model.BsUser;
import xyz.jangle.test.utils.JUnitRunSupport;

public class BsUserMapperTest extends JUnitRunSupport {

	@Autowired
	private BsUserMapper BsUserMapper;

	@Test
	public void testInsert() {
		BsUser record = new BsUser();
		record.setUsrName("3");
		record.setUsrPassword("3");
		record.setUsrCode("3");
		int insert = BsUserMapper.insert(record);
		assertEquals(1, insert);
		System.out.println("usrId:"+record.getUsrId());
	}

	@Test
	public void testSelectByCodeAndPassword() {
		BsUser record = new BsUser();
		record.setUsrCode("jangle");
		record.setUsrPassword("1");
		BsUser user = BsUserMapper.selectByCodeAndPassword(record);
		assertEquals(1, user.getUsrId().intValue());
	}

}
