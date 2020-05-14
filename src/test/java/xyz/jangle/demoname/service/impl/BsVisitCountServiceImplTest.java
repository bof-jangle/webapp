package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsVisitCount;
import xyz.jangle.demoname.service.BsVisitCountService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 访客统计 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BsVisitCountServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsVisitCountService bsVisitCountService;
	
	private BsVisitCount testBsVisitCount = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsVisitCount record = new BsVisitCount();
		record.setDmDesc(testString);
		ResultModel<BsVisitCount> resultModel = bsVisitCountService.insertOrUpdate(record );
		testBsVisitCount = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsVisitCount.setId(0L);	//根据UUID更新
		assertEquals(CME.SUCCESS.getCode(), bsVisitCountService.insertOrUpdate(testBsVisitCount).getCode());
		testBsVisitCount.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.ERROR.getCode(), bsVisitCountService.insertOrUpdate(testBsVisitCount).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsVisitCountService.selectByPrimaryKey(testBsVisitCount).getModel());
		assertEquals(CME.SUCCESS.getCode(), bsVisitCountService.deleteByPrimaryKey(testBsVisitCount).getCode());
		assertEquals("2", bsVisitCountService.selectByPrimaryKey(testBsVisitCount).getModel().getStatus().toString());
		testBsVisitCount.setId(1L);
		assertEquals(CME.ERROR.getCode(), bsVisitCountService.deleteByPrimaryKey(testBsVisitCount).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsVisitCountService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsVisitCountService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.SUCCESS.getCode(), bsVisitCountService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsVisitCountService.selectByPrimaryKey(testBsVisitCount).getModel().getDmDesc());
		testBsVisitCount.setDmDesc("updateDesc");
		bsVisitCountService.updateByPrimaryKey(testBsVisitCount);
		assertFalse(bsVisitCountService.selectByPrimaryKey(testBsVisitCount).getModel().getDmDesc().equals(testString));
		testBsVisitCount.setId(0L);
		testBsVisitCount.setUuid("");
		bsVisitCountService.updateByPrimaryKey(testBsVisitCount).getCode().equals(CME.ERROR.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsVisitCountService.selectPage(new BsVisitCount()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsVisitCountService.selectByPrimaryKey(testBsVisitCount);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsVisitCount record = new BsVisitCount();
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsVisitCountService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsVisitCountService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testBsVisitCount.getId().toString());
		bsVisitCountService.batchDeleteByPrimaryKey(record);
		assertEquals("2", bsVisitCountService.selectByPrimaryKey(testBsVisitCount).getModel().getStatus().toString());
		bsVisitCountService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, bsVisitCountService.selectByPrimaryKey(testBsVisitCount).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsVisitCountService.selectByPrimaryKeyForAnnotation(testBsVisitCount));
	}

}
