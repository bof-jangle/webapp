package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsUser;
import xyz.jangle.demoname.service.BsUserService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

public class BsUserServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsUserService bsUserService;
	
	private BsUser testBsUser = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsUser record = new BsUser();
		record.setUsrName(testString);
		ResultModel<BsUser> resultModel = bsUserService.insertOrUpdate(record );
		testBsUser = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsUser.setId(1L);
		assertTrue(bsUserService.insertOrUpdate(testBsUser).getCode().equals(CME.error.getCode()));
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsUserService.selectByPrimaryKey(testBsUser).getModel());
		assertTrue(bsUserService.deleteByPrimaryKey(testBsUser).getCode().equals(CME.success.getCode()));
		assertNull(bsUserService.selectByPrimaryKey(testBsUser).getModel());
		testBsUser.setId(1L);
		assertTrue(bsUserService.deleteByPrimaryKey(testBsUser).getCode().equals(CME.error.getCode()));
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsUserService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsUserService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertTrue(bsUserService.selectByParam(param).getCode().equals(CME.success.getCode()));
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertTrue(bsUserService.selectByPrimaryKey(testBsUser).getModel().getUsrName().equals(testString));
		testBsUser.setUsrName("updateDesc");
		bsUserService.updateByPrimaryKey(testBsUser);
		assertFalse(bsUserService.selectByPrimaryKey(testBsUser).getModel().getUsrName().equals(testString));
		testBsUser.setUsrId(0);
		bsUserService.updateByPrimaryKey(testBsUser).getCode().equals(CME.error.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsUserService.selectPage(new BsUser()).getList().isEmpty());
	}

}
