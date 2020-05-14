package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsMenuRoleR;
import xyz.jangle.demoname.service.BsMenuRoleRService;
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
public class BsMenuRoleRServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsMenuRoleRService bsMenuRoleRService;
	
	private BsMenuRoleR testBsMenuRoleR = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsMenuRoleR record = new BsMenuRoleR();
		record.setDmDesc(testString);
		ResultModel<BsMenuRoleR> resultModel = bsMenuRoleRService.insertOrUpdate(record );
		testBsMenuRoleR = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsMenuRoleR.setId(0L);	//根据UUID更新
		assertEquals(CME.SUCCESS.getCode(), bsMenuRoleRService.insertOrUpdate(testBsMenuRoleR).getCode());
		testBsMenuRoleR.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.ERROR.getCode(), bsMenuRoleRService.insertOrUpdate(testBsMenuRoleR).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsMenuRoleRService.selectByPrimaryKey(testBsMenuRoleR).getModel());
		assertEquals(CME.SUCCESS.getCode(), bsMenuRoleRService.deleteByPrimaryKey(testBsMenuRoleR).getCode());
		assertEquals("2", bsMenuRoleRService.selectByPrimaryKey(testBsMenuRoleR).getModel().getStatus().toString());
		testBsMenuRoleR.setId(1L);
		assertEquals(CME.ERROR.getCode(), bsMenuRoleRService.deleteByPrimaryKey(testBsMenuRoleR).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsMenuRoleRService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsMenuRoleRService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.SUCCESS.getCode(), bsMenuRoleRService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsMenuRoleRService.selectByPrimaryKey(testBsMenuRoleR).getModel().getDmDesc());
		testBsMenuRoleR.setDmDesc("updateDesc");
		bsMenuRoleRService.updateByPrimaryKey(testBsMenuRoleR);
		assertFalse(bsMenuRoleRService.selectByPrimaryKey(testBsMenuRoleR).getModel().getDmDesc().equals(testString));
		testBsMenuRoleR.setId(0L);
		testBsMenuRoleR.setUuid("");
		bsMenuRoleRService.updateByPrimaryKey(testBsMenuRoleR).getCode().equals(CME.ERROR.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsMenuRoleRService.selectPage(new BsMenuRoleR()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsMenuRoleRService.selectByPrimaryKey(testBsMenuRoleR);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsMenuRoleR record = new BsMenuRoleR();
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsMenuRoleRService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsMenuRoleRService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testBsMenuRoleR.getId().toString());
		bsMenuRoleRService.batchDeleteByPrimaryKey(record);
		assertEquals("2", bsMenuRoleRService.selectByPrimaryKey(testBsMenuRoleR).getModel().getStatus().toString());
		bsMenuRoleRService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, bsMenuRoleRService.selectByPrimaryKey(testBsMenuRoleR).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsMenuRoleRService.selectByPrimaryKeyForAnnotation(testBsMenuRoleR));
	}

}
