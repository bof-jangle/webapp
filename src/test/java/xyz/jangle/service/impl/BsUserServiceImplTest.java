package xyz.jangle.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.model.BsUser;
import xyz.jangle.service.BsUserService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CodeMessageEnum;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

public class BsUserServiceImplTest extends JUnitRunSupport {

	@Autowired
	private BsUserService BsUserService;

	@Test
	@Ignore
	public void testSave() {

		BsUser BsUser = new BsUser();
		BsUser.setUsrName("5");
		BsUser.setUsrCode("5");
		BsUser.setUsrPassword("5");
		ResultModel<BsUser> resultModel = BsUserService.save(BsUser);
		System.out.println(resultModel.getCode());
		assertEquals(CodeMessageEnum.success.getCode(), resultModel.getCode());
	}

	@Test
	public void testNestedTransactionTest() {
		ResultModelList<BsUser> resultModelList = BsUserService.nestedTransactionTest();
		assertEquals(CodeMessageEnum.success.getCode(), resultModelList.getCode());
	}

	@Test
	public void testSelectByCodeAndPassword() {
		BsUser record = new BsUser();
		record.setUsrCode("jangle");
		record.setUsrPassword("1");
		BsUser user = BsUserService.selectByCodeAndPassword(record).getModel();
		assertEquals(1, user.getUsrId().intValue());
	}

}
