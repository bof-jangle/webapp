package xyz.jangle.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import xyz.jangle.model.DUser;
import xyz.jangle.service.DUserService;
import xyz.jangle.test.utils.JUnitRunSupport;

public class DUserServiceImplTest extends JUnitRunSupport{
	
	@Autowired
	private DUserService dUserService;

	@Test
	@Rollback(false)
	public void testSave() {
		
		DUser dUser =new DUser();
		dUser.setUsrName("2");
		dUser.setUsrCode("2");
		dUser.setUsrPassword("2");
		dUserService.save(dUser);
		
	}

}
