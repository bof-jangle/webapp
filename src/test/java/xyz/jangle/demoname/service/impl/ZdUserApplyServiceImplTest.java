package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.ZdUserApply;
import xyz.jangle.demoname.service.ZdUserApplyService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 用户申请 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class ZdUserApplyServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private ZdUserApplyService zdUserApplyService;
	
	private ZdUserApply testZdUserApply = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		ZdUserApply record = new ZdUserApply();
		record.setDmDesc(testString);
		record.setZdUserApplyIp(testString);
		ResultModel<ZdUserApply> resultModel = zdUserApplyService.insertOrUpdate(record );
		testZdUserApply = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testZdUserApply.setId(0L);	//根据UUID更新
		assertEquals(CME.success.getCode(), zdUserApplyService.insertOrUpdate(testZdUserApply).getCode());
		testZdUserApply.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.error.getCode(), zdUserApplyService.insertOrUpdate(testZdUserApply).getCode());
		testZdUserApply.setId(0L);
		testZdUserApply.setUuid(null);	//同一IP地址重复申请的情况
		assertEquals(CME.zdUserApply_ip_repeat.getCode(), zdUserApplyService.insertOrUpdate(testZdUserApply).getCode());
		
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(zdUserApplyService.selectByPrimaryKey(testZdUserApply).getModel());
		assertEquals(CME.success.getCode(), zdUserApplyService.deleteByPrimaryKey(testZdUserApply).getCode());
		assertEquals("2", zdUserApplyService.selectByPrimaryKey(testZdUserApply).getModel().getStatus().toString());
		testZdUserApply.setId(1L);
		assertEquals(CME.error.getCode(), zdUserApplyService.deleteByPrimaryKey(testZdUserApply).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(zdUserApplyService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(zdUserApplyService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.success.getCode(), zdUserApplyService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, zdUserApplyService.selectByPrimaryKey(testZdUserApply).getModel().getDmDesc());
		testZdUserApply.setDmDesc("updateDesc");
		zdUserApplyService.updateByPrimaryKey(testZdUserApply);
		assertFalse(zdUserApplyService.selectByPrimaryKey(testZdUserApply).getModel().getDmDesc().equals(testString));
		testZdUserApply.setId(0L);
		testZdUserApply.setUuid("");
		zdUserApplyService.updateByPrimaryKey(testZdUserApply).getCode().equals(CME.error.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(zdUserApplyService.selectPage(new ZdUserApply()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		zdUserApplyService.selectByPrimaryKey(testZdUserApply);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		ZdUserApply record = new ZdUserApply();
		assertEquals(CME.unFindIdsToDelete.getCode(), zdUserApplyService.batchDeleteByPrimaryKey(record).getCode());
		record.setIds(testZdUserApply.getId().toString());
		zdUserApplyService.batchDeleteByPrimaryKey(record);
		assertEquals("2", zdUserApplyService.selectByPrimaryKey(testZdUserApply).getModel().getStatus().toString());
	}
	
	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(zdUserApplyService.selectByPrimaryKeyForAnnotation(testZdUserApply));
	}

}
