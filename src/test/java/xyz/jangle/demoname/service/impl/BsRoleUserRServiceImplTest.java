package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsRoleUserR;
import xyz.jangle.demoname.service.BsRoleUserRService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
*  单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BsRoleUserRServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsRoleUserRService bsRoleUserRService;
	
	private BsRoleUserR testBsRoleUserR = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsRoleUserR record = new BsRoleUserR();
		record.setDmDesc(testString);
		ResultModel<BsRoleUserR> resultModel = bsRoleUserRService.insertOrUpdate(record );
		testBsRoleUserR = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsRoleUserR.setId(0L);	//根据UUID更新
		assertEquals(CME.success.getCode(), bsRoleUserRService.insertOrUpdate(testBsRoleUserR).getCode());
		testBsRoleUserR.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.error.getCode(), bsRoleUserRService.insertOrUpdate(testBsRoleUserR).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsRoleUserRService.selectByPrimaryKey(testBsRoleUserR).getModel());
		assertEquals(CME.success.getCode(), bsRoleUserRService.deleteByPrimaryKey(testBsRoleUserR).getCode());
		assertEquals("2", bsRoleUserRService.selectByPrimaryKey(testBsRoleUserR).getModel().getStatus().toString());
		testBsRoleUserR.setId(1L);
		assertEquals(CME.error.getCode(), bsRoleUserRService.deleteByPrimaryKey(testBsRoleUserR).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsRoleUserRService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsRoleUserRService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.success.getCode(), bsRoleUserRService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsRoleUserRService.selectByPrimaryKey(testBsRoleUserR).getModel().getDmDesc());
		testBsRoleUserR.setDmDesc("updateDesc");
		bsRoleUserRService.updateByPrimaryKey(testBsRoleUserR);
		assertFalse(bsRoleUserRService.selectByPrimaryKey(testBsRoleUserR).getModel().getDmDesc().equals(testString));
		testBsRoleUserR.setId(0L);
		testBsRoleUserR.setUuid("");
		bsRoleUserRService.updateByPrimaryKey(testBsRoleUserR).getCode().equals(CME.error.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsRoleUserRService.selectPage(new BsRoleUserR()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsRoleUserRService.selectByPrimaryKey(testBsRoleUserR);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsRoleUserR record = new BsRoleUserR();
		assertEquals(CME.unFindIdsToDelete.getCode(), bsRoleUserRService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.unFindIdsToDelete.getCode(), bsRoleUserRService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testBsRoleUserR.getId().toString());
		bsRoleUserRService.batchDeleteByPrimaryKey(record);
		assertEquals("2", bsRoleUserRService.selectByPrimaryKey(testBsRoleUserR).getModel().getStatus().toString());
		bsRoleUserRService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, bsRoleUserRService.selectByPrimaryKey(testBsRoleUserR).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsRoleUserRService.selectByPrimaryKeyForAnnotation(testBsRoleUserR));
	}

}
