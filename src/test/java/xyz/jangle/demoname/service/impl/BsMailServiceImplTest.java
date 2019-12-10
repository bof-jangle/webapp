package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsMail;
import xyz.jangle.demoname.service.BsMailService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 邮件发送记录表 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BsMailServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsMailService bsMailService;
	
	private BsMail testBsMail = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsMail record = new BsMail();
		record.setDmDesc(testString);
		ResultModel<BsMail> resultModel = bsMailService.insertOrUpdate(record );
		testBsMail = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsMail.setId(0L);	//根据UUID更新
		assertEquals(CME.success.getCode(), bsMailService.insertOrUpdate(testBsMail).getCode());
		testBsMail.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.error.getCode(), bsMailService.insertOrUpdate(testBsMail).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsMailService.selectByPrimaryKey(testBsMail).getModel());
		assertEquals(CME.success.getCode(), bsMailService.deleteByPrimaryKey(testBsMail).getCode());
		assertEquals("2", bsMailService.selectByPrimaryKey(testBsMail).getModel().getStatus().toString());
		testBsMail.setId(1L);
		assertEquals(CME.error.getCode(), bsMailService.deleteByPrimaryKey(testBsMail).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsMailService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsMailService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.success.getCode(), bsMailService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsMailService.selectByPrimaryKey(testBsMail).getModel().getDmDesc());
		testBsMail.setDmDesc("updateDesc");
		bsMailService.updateByPrimaryKey(testBsMail);
		assertFalse(bsMailService.selectByPrimaryKey(testBsMail).getModel().getDmDesc().equals(testString));
		testBsMail.setId(0L);
		testBsMail.setUuid("");
		bsMailService.updateByPrimaryKey(testBsMail).getCode().equals(CME.error.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsMailService.selectPage(new BsMail()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsMailService.selectByPrimaryKey(testBsMail);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsMail record = new BsMail();
		assertEquals(CME.unFindIdsToDelete.getCode(), bsMailService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.unFindIdsToDelete.getCode(), bsMailService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testBsMail.getId().toString());
		bsMailService.batchDeleteByPrimaryKey(record);
		assertEquals("2", bsMailService.selectByPrimaryKey(testBsMail).getModel().getStatus().toString());
		bsMailService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, bsMailService.selectByPrimaryKey(testBsMail).getModel());
	}
	
	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsMailService.selectByPrimaryKeyForAnnotation(testBsMail));
	}

}
