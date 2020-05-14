package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BaseDemo;
import xyz.jangle.demoname.service.BaseDemoService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 基础框架的基础Demo 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BaseDemoServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BaseDemoService baseDemoService;
	
	private BaseDemo testBaseDemo = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BaseDemo record = new BaseDemo();
		record.setDmDesc(testString);
		ResultModel<BaseDemo> resultModel = baseDemoService.insertOrUpdate(record );
		testBaseDemo = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBaseDemo.setId(0L);	//根据UUID更新
		assertEquals(CME.SUCCESS.getCode(), baseDemoService.insertOrUpdate(testBaseDemo).getCode());
		testBaseDemo.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.ERROR.getCode(), baseDemoService.insertOrUpdate(testBaseDemo).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(baseDemoService.selectByPrimaryKey(testBaseDemo).getModel());
		assertEquals(CME.SUCCESS.getCode(), baseDemoService.deleteByPrimaryKey(testBaseDemo).getCode());
		assertEquals("2", baseDemoService.selectByPrimaryKey(testBaseDemo).getModel().getStatus().toString());
		testBaseDemo.setId(1L);
		assertEquals(CME.ERROR.getCode(), baseDemoService.deleteByPrimaryKey(testBaseDemo).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(baseDemoService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(baseDemoService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.SUCCESS.getCode(), baseDemoService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, baseDemoService.selectByPrimaryKey(testBaseDemo).getModel().getDmDesc());
		testBaseDemo.setDmDesc("updateDesc");
		baseDemoService.updateByPrimaryKey(testBaseDemo);
		assertFalse(baseDemoService.selectByPrimaryKey(testBaseDemo).getModel().getDmDesc().equals(testString));
		testBaseDemo.setId(0L);
		testBaseDemo.setUuid("");
		baseDemoService.updateByPrimaryKey(testBaseDemo).getCode().equals(CME.ERROR.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(baseDemoService.selectPage(new BaseDemo()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		baseDemoService.selectByPrimaryKey(testBaseDemo);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BaseDemo record = new BaseDemo();
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), baseDemoService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), baseDemoService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testBaseDemo.getId().toString());
		baseDemoService.batchDeleteByPrimaryKey(record);
		assertEquals("2", baseDemoService.selectByPrimaryKey(testBaseDemo).getModel().getStatus().toString());
		baseDemoService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, baseDemoService.selectByPrimaryKey(testBaseDemo).getModel());
	}
	
	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(baseDemoService.selectByPrimaryKeyForAnnotation(testBaseDemo));
	}

}
