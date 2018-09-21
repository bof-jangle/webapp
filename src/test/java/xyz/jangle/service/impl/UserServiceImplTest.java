package xyz.jangle.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import xyz.jangle.model.User;
import xyz.jangle.service.UserService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CodeMessageEnum;
import xyz.jangle.utils.ResultModelList;

/** 
* @author jangle E-mail: jangle@jangle.xyz
* @version 2018年9月19日 上午9:00:05 
* 类说明 
*/
public class UserServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private UserService userService;

	@Test
	public void testSave() {
		ResultModelList<User> resultModelList = userService.save();
		assertEquals(CodeMessageEnum.exception.getCode(), resultModelList.getCode());
	}
	
	@Test
	public void testGetAll() {
		ResultModelList<User> allUser = userService.getAllUser();
		assertEquals(CodeMessageEnum.success.getCode(), allUser.getCode());
	}

}
