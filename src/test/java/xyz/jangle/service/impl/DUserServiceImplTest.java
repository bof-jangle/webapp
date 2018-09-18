package xyz.jangle.service.impl;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.model.DUser;
import xyz.jangle.service.DUserService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.ResultModel;

public class DUserServiceImplTest extends JUnitRunSupport{
	
	@Autowired
	private DUserService dUserService;

	@Test
	public void testSave() {
		
		DUser dUser =new DUser();
		dUser.setUsrName("5");
		dUser.setUsrCode("5");
		dUser.setUsrPassword("5");
		ResultModel<DUser> resultModel = dUserService.save(dUser);
		System.out.println(resultModel.getCode());
		assertEquals(resultModel.getCode(), "10001");
	}

}
