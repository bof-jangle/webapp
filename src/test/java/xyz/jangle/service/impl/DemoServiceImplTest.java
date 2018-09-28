package xyz.jangle.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.model.DemoModel;
import xyz.jangle.service.DemoService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CodeMessageEnum;
import xyz.jangle.utils.ResultModelList;

/** 
* @author jangle E-mail: jangle@jangle.xyz
* @version 2018年9月19日 上午9:00:05 
* 类说明 
*/
public class DemoServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private DemoService demoService;

	@Test
	public void testSave() {
		ResultModelList<DemoModel> resultModelList = demoService.save();
		assertEquals(CodeMessageEnum.exception.getCode(), resultModelList.getCode());
	}
	
	@Test
	public void testGetAll() {
		ResultModelList<DemoModel> allUser = demoService.getAllUser();
		assertEquals(CodeMessageEnum.success.getCode(), allUser.getCode());
	}

}
