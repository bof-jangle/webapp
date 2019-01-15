package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsUser;
import xyz.jangle.demoname.service.BsUserService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CodeMessageEnum;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

public class BsUserServiceImplTest extends JUnitRunSupport {

	@Autowired
	private BsUserService BsUserService;
	// 结果保存
	private ResultModel<BsUser> result = null;
	
	@Before
	public void setUp() throws Exception {
		BsUser bsUser = new BsUser();
		bsUser.setUsrName("testName");
		bsUser.setUsrCode("testCode");
		bsUser.setUsrPassword("testPassword");
		result = BsUserService.insert(bsUser);
	}

	@After
	public void tearDown() throws Exception {
		assertEquals(CodeMessageEnum.success.getCode(), result.getCode());
		result = null;
	}

	@Test
	public void testInsert() {
		BsUser bsUser = new BsUser();
		result = BsUserService.insert(bsUser);
		assertEquals(CodeMessageEnum.success.getCode(), result.getCode());
		assertNotNull(result.getModel().getUsrId());
		
	}

	@Test
	public void testDeleteByPrimaryKey() {
		result = BsUserService.deleteByPrimaryKey(result.getModel());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		result = BsUserService.updateByPrimaryKey(result.getModel());
	}

	@Test
	public void testSelectByPrimaryKey() {
		result = BsUserService.selectByPrimaryKey(result.getModel());
	}

	@Test
	public void testNestedTransactionTest() {
		ResultModelList<BsUser> resultModelList = BsUserService.nestedTransactionTest();
		assertEquals(CodeMessageEnum.success.getCode(), resultModelList.getCode());
	}

	@Test
	public void testSelectByCodeAndPassword() {
		result = BsUserService.selectByCodeAndPassword(result.getModel());
		assertTrue(result.getModel().getUsrId() > 0);
	}

}
