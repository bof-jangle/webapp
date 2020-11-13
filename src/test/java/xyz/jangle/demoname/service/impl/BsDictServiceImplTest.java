package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsDict;
import xyz.jangle.demoname.service.BsDictService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 字典表 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BsDictServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsDictService bsDictService;
	
	private BsDict testBsDict = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsDict record = new BsDict();
		record.setDmDesc(testString);
		ResultModel<BsDict> resultModel = bsDictService.insertOrUpdate(record );
		testBsDict = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsDict.setId(0L);	//根据UUID更新
		assertEquals(CME.SUCCESS.getCode(), bsDictService.insertOrUpdate(testBsDict).getCode());
		testBsDict.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.ERROR.getCode(), bsDictService.insertOrUpdate(testBsDict).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsDictService.selectByPrimaryKey(testBsDict).getModel());
		assertEquals(CME.SUCCESS.getCode(), bsDictService.deleteByPrimaryKey(testBsDict).getCode());
		assertEquals("2", bsDictService.selectByPrimaryKey(testBsDict).getModel().getStatus().toString());
		testBsDict.setId(1L);
		assertEquals(CME.ERROR.getCode(), bsDictService.deleteByPrimaryKey(testBsDict).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsDictService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsDictService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.SUCCESS.getCode(), bsDictService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsDictService.selectByPrimaryKey(testBsDict).getModel().getDmDesc());
		testBsDict.setDmDesc("updateDesc");
		bsDictService.updateByPrimaryKey(testBsDict);
		assertFalse(bsDictService.selectByPrimaryKey(testBsDict).getModel().getDmDesc().equals(testString));
		testBsDict.setId(0L);
		testBsDict.setUuid("");
		bsDictService.updateByPrimaryKey(testBsDict).getCode().equals(CME.ERROR.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsDictService.selectPage(new BsDict()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsDictService.selectByPrimaryKey(testBsDict);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsDict record = new BsDict();
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsDictService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsDictService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testBsDict.getId().toString());
		bsDictService.batchDeleteByPrimaryKey(record);
		assertEquals("2", bsDictService.selectByPrimaryKey(testBsDict).getModel().getStatus().toString());
		bsDictService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, bsDictService.selectByPrimaryKey(testBsDict).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsDictService.selectByPrimaryKeyForAnnotation(testBsDict));
	}

}
