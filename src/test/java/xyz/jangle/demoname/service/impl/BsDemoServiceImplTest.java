package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsDemo;
import xyz.jangle.demoname.service.BsDemoService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* @author jangle E-mail: jangle@jangle.xyz
* @version 2019年3月19日 下午5:14:23 
* 类说明 
*/
public class BsDemoServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsDemoService bsDemoService;
	
	private BsDemo testBsDemo = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsDemo record = new BsDemo();
		record.setDmDesc(testString);
		ResultModel<BsDemo> resultModel = bsDemoService.insert(record );
		testBsDemo = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsDemo.setId(1L);
		assertTrue(bsDemoService.insert(testBsDemo).getCode().equals(CME.error.getCode()));
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsDemoService.selectByPrimaryKey(testBsDemo).getModel());
		assertTrue(bsDemoService.deleteByPrimaryKey(testBsDemo).getCode().equals(CME.success.getCode()));
		assertNull(bsDemoService.selectByPrimaryKey(testBsDemo).getModel());
		testBsDemo.setId(1L);
		assertTrue(bsDemoService.deleteByPrimaryKey(testBsDemo).getCode().equals(CME.error.getCode()));
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsDemoService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsDemoService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertTrue(bsDemoService.selectByParam(param).getCode().equals(CME.success.getCode()));
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertTrue(bsDemoService.selectByPrimaryKey(testBsDemo).getModel().getDmDesc().equals(testString));
		testBsDemo.setDmDesc("updateDesc");
		bsDemoService.updateByPrimaryKey(testBsDemo);
		assertFalse(bsDemoService.selectByPrimaryKey(testBsDemo).getModel().getDmDesc().equals(testString));
		testBsDemo.setId(0L);
		bsDemoService.updateByPrimaryKey(testBsDemo).getCode().equals(CME.error.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsDemoService.selectPage(new BsDemo()).getList().isEmpty());
	}

}
