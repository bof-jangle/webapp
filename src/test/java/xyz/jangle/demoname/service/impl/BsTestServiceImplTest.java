package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsTest;
import xyz.jangle.demoname.service.BsTestService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 测试表 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BsTestServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsTestService bsTestService;
	
	private BsTest testBsTest = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsTest record = new BsTest();
		record.setDmDesc(testString);
		ResultModel<BsTest> resultModel = bsTestService.insertOrUpdate(record );
		testBsTest = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsTest.setId(0L);	//根据UUID更新
		assertEquals(CME.SUCCESS.getCode(), bsTestService.insertOrUpdate(testBsTest).getCode());
		testBsTest.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.ERROR.getCode(), bsTestService.insertOrUpdate(testBsTest).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsTestService.selectByPrimaryKey(testBsTest).getModel());
		assertEquals(CME.SUCCESS.getCode(), bsTestService.deleteByPrimaryKey(testBsTest).getCode());
		assertEquals("2", bsTestService.selectByPrimaryKey(testBsTest).getModel().getStatus().toString());
		testBsTest.setId(1L);
		assertEquals(CME.ERROR.getCode(), bsTestService.deleteByPrimaryKey(testBsTest).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsTestService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsTestService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.SUCCESS.getCode(), bsTestService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsTestService.selectByPrimaryKey(testBsTest).getModel().getDmDesc());
		testBsTest.setDmDesc("updateDesc");
		bsTestService.updateByPrimaryKey(testBsTest);
		assertFalse(bsTestService.selectByPrimaryKey(testBsTest).getModel().getDmDesc().equals(testString));
		testBsTest.setId(0L);
		testBsTest.setUuid("");
		bsTestService.updateByPrimaryKey(testBsTest).getCode().equals(CME.ERROR.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsTestService.selectPage(new BsTest()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsTestService.selectByPrimaryKey(testBsTest);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsTest record = new BsTest();
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsTestService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsTestService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testBsTest.getId().toString());
		bsTestService.batchDeleteByPrimaryKey(record);
		assertEquals("2", bsTestService.selectByPrimaryKey(testBsTest).getModel().getStatus().toString());
		bsTestService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, bsTestService.selectByPrimaryKey(testBsTest).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsTestService.selectByPrimaryKeyForAnnotation(testBsTest));
	}

}
