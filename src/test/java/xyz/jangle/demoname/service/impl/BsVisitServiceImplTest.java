package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsVisit;
import xyz.jangle.demoname.service.BsVisitService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 访问记录表 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BsVisitServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsVisitService bsVisitService;
	
	private BsVisit testBsVisit = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsVisit record = new BsVisit();
		record.setDmDesc(testString);
		ResultModel<BsVisit> resultModel = bsVisitService.insertOrUpdate(record );
		testBsVisit = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsVisit.setId(0L);	//根据UUID更新
		assertEquals(CME.SUCCESS.getCode(), bsVisitService.insertOrUpdate(testBsVisit).getCode());
		testBsVisit.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.ERROR.getCode(), bsVisitService.insertOrUpdate(testBsVisit).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsVisitService.selectByPrimaryKey(testBsVisit).getModel());
		assertEquals(CME.SUCCESS.getCode(), bsVisitService.deleteByPrimaryKey(testBsVisit).getCode());
		assertEquals("2", bsVisitService.selectByPrimaryKey(testBsVisit).getModel().getStatus().toString());
		testBsVisit.setId(1L);
		assertEquals(CME.ERROR.getCode(), bsVisitService.deleteByPrimaryKey(testBsVisit).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsVisitService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsVisitService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.SUCCESS.getCode(), bsVisitService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsVisitService.selectByPrimaryKey(testBsVisit).getModel().getDmDesc());
		testBsVisit.setDmDesc("updateDesc");
		bsVisitService.updateByPrimaryKey(testBsVisit);
		assertFalse(bsVisitService.selectByPrimaryKey(testBsVisit).getModel().getDmDesc().equals(testString));
		testBsVisit.setId(0L);
		testBsVisit.setUuid("");
		bsVisitService.updateByPrimaryKey(testBsVisit).getCode().equals(CME.ERROR.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsVisitService.selectPage(new BsVisit()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsVisitService.selectByPrimaryKey(testBsVisit);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsVisit record = new BsVisit();
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsVisitService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsVisitService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testBsVisit.getId().toString());
		bsVisitService.batchDeleteByPrimaryKey(record);
		assertEquals("2", bsVisitService.selectByPrimaryKey(testBsVisit).getModel().getStatus().toString());
		bsVisitService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, bsVisitService.selectByPrimaryKey(testBsVisit).getModel());
	}
	
	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsVisitService.selectByPrimaryKeyForAnnotation(testBsVisit));
	}
	
	@Test
	public void testCount() {
		assertTrue(bsVisitService.count().getCount() > 0);
	}

}
