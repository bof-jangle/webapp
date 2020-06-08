package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.MsPlan;
import xyz.jangle.demoname.service.MsPlanService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 面试安排 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.12020-06-08 11:34:37
* 类说明 
*/
public class MsPlanServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private MsPlanService msPlanService;
	
	private MsPlan testMsPlan = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		MsPlan record = new MsPlan();
		record.setDmDesc(testString);
		ResultModel<MsPlan> resultModel = msPlanService.insertOrUpdate(record );
		testMsPlan = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testMsPlan.setId(0L);	//根据UUID更新
		assertEquals(CME.SUCCESS.getCode(), msPlanService.insertOrUpdate(testMsPlan).getCode());
		testMsPlan.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.ERROR.getCode(), msPlanService.insertOrUpdate(testMsPlan).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(msPlanService.selectByPrimaryKey(testMsPlan).getModel());
		assertEquals(CME.SUCCESS.getCode(), msPlanService.deleteByPrimaryKey(testMsPlan).getCode());
		assertEquals("2", msPlanService.selectByPrimaryKey(testMsPlan).getModel().getStatus().toString());
		testMsPlan.setId(1L);
		assertEquals(CME.ERROR.getCode(), msPlanService.deleteByPrimaryKey(testMsPlan).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(msPlanService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(msPlanService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.SUCCESS.getCode(), msPlanService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, msPlanService.selectByPrimaryKey(testMsPlan).getModel().getDmDesc());
		testMsPlan.setDmDesc("updateDesc");
		msPlanService.updateByPrimaryKey(testMsPlan);
		assertFalse(msPlanService.selectByPrimaryKey(testMsPlan).getModel().getDmDesc().equals(testString));
		testMsPlan.setId(0L);
		testMsPlan.setUuid("");
		msPlanService.updateByPrimaryKey(testMsPlan).getCode().equals(CME.ERROR.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(msPlanService.selectPage(new MsPlan()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		msPlanService.selectByPrimaryKey(testMsPlan);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		MsPlan record = new MsPlan();
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), msPlanService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), msPlanService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testMsPlan.getId().toString());
		msPlanService.batchDeleteByPrimaryKey(record);
		assertEquals("2", msPlanService.selectByPrimaryKey(testMsPlan).getModel().getStatus().toString());
		msPlanService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, msPlanService.selectByPrimaryKey(testMsPlan).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(msPlanService.selectByPrimaryKeyForAnnotation(testMsPlan));
	}

}
