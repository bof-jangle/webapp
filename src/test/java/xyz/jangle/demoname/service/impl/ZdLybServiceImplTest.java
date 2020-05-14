package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.ZdLyb;
import xyz.jangle.demoname.service.ZdLybService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 战队留言板 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class ZdLybServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private ZdLybService zdLybService;
	
	private ZdLyb testZdLyb = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		login();
		ZdLyb record = new ZdLyb();
		record.setDmDesc(testString);
		ResultModel<ZdLyb> resultModel = zdLybService.insertOrUpdate(record );
		testZdLyb = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		login();
		testZdLyb.setId(0L);	//根据UUID更新
		assertEquals(CME.SUCCESS.getCode(), zdLybService.insertOrUpdate(testZdLyb).getCode());
		testZdLyb.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.ERROR.getCode(), zdLybService.insertOrUpdate(testZdLyb).getCode());
		loginByTest();
		testZdLyb.setId(0L);
		testZdLyb.setUuid(null);
		assertEquals(CME.SUCCESS.getCode(), zdLybService.insertOrUpdate(testZdLyb).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(zdLybService.selectByPrimaryKey(testZdLyb).getModel());
		assertEquals(CME.SUCCESS.getCode(), zdLybService.deleteByPrimaryKey(testZdLyb).getCode());
		assertEquals("2", zdLybService.selectByPrimaryKey(testZdLyb).getModel().getStatus().toString());
		testZdLyb.setId(1L);
		assertEquals(CME.ERROR.getCode(), zdLybService.deleteByPrimaryKey(testZdLyb).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(zdLybService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(zdLybService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.SUCCESS.getCode(), zdLybService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, zdLybService.selectByPrimaryKey(testZdLyb).getModel().getDmDesc());
		testZdLyb.setDmDesc("updateDesc");
		zdLybService.updateByPrimaryKey(testZdLyb);
		assertFalse(zdLybService.selectByPrimaryKey(testZdLyb).getModel().getDmDesc().equals(testString));
		testZdLyb.setId(0L);
		testZdLyb.setUuid("");
		zdLybService.updateByPrimaryKey(testZdLyb).getCode().equals(CME.ERROR.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(zdLybService.selectPage(new ZdLyb()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		zdLybService.selectByPrimaryKey(testZdLyb);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		ZdLyb record = new ZdLyb();
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), zdLybService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), zdLybService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testZdLyb.getId().toString());
		zdLybService.batchDeleteByPrimaryKey(record);
		assertEquals("2", zdLybService.selectByPrimaryKey(testZdLyb).getModel().getStatus().toString());
		zdLybService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, zdLybService.selectByPrimaryKey(testZdLyb).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(zdLybService.selectByPrimaryKeyForAnnotation(testZdLyb));
	}

}
