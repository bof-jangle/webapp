package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsUser2;
import xyz.jangle.demoname.service.BsUser2Service;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 用户表V2 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BsUser2ServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsUser2Service bsUser2Service;
	
	private BsUser2 testBsUser2 = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsUser2 record = new BsUser2();
		record.setDmDesc(testString);
		record.setJgCode(testString);
		record.setJgPassword(testString);
		ResultModel<BsUser2> resultModel = bsUser2Service.insertOrUpdate(record );
		testBsUser2 = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsUser2.setId(0L);	//根据UUID更新
		assertEquals(CME.success.getCode(), bsUser2Service.insertOrUpdate(testBsUser2).getCode());
		testBsUser2.setId(3L);	//无对应的主键记录报错
		assertEquals(CME.error.getCode(), bsUser2Service.insertOrUpdate(testBsUser2).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsUser2Service.selectByPrimaryKey(testBsUser2).getModel());
		assertEquals(CME.success.getCode(), bsUser2Service.deleteByPrimaryKey(testBsUser2).getCode());
		assertEquals("2", bsUser2Service.selectByPrimaryKey(testBsUser2).getModel().getStatus().toString());
		testBsUser2.setId(3L);
		assertEquals(CME.error.getCode(), bsUser2Service.deleteByPrimaryKey(testBsUser2).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsUser2Service.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsUser2Service.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.success.getCode(), bsUser2Service.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsUser2Service.selectByPrimaryKey(testBsUser2).getModel().getDmDesc());
		testBsUser2.setDmDesc("updateDesc");
		bsUser2Service.updateByPrimaryKey(testBsUser2);
		assertFalse(bsUser2Service.selectByPrimaryKey(testBsUser2).getModel().getDmDesc().equals(testString));
		testBsUser2.setId(0L);
		testBsUser2.setUuid("");
		bsUser2Service.updateByPrimaryKey(testBsUser2).getCode().equals(CME.error.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsUser2Service.selectPage(new BsUser2()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsUser2Service.selectByPrimaryKey(testBsUser2);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsUser2 record = new BsUser2();
		assertEquals(CME.unFindIdsToDelete.getCode(), bsUser2Service.batchDeleteByPrimaryKey(record).getCode());
		record.setIds(testBsUser2.getId().toString());
		bsUser2Service.batchDeleteByPrimaryKey(record);
		assertEquals("2", bsUser2Service.selectByPrimaryKey(testBsUser2).getModel().getStatus().toString());
	}
	
	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsUser2Service.selectByPrimaryKeyForAnnotation(testBsUser2));
	}
	
	@Test
	public void testPassApply() {
		assertEquals(CME.success.getCode(), bsUser2Service.passApply(testBsUser2).getCode());
		assertEquals(CME.success.getCode(), bsUser2Service.noPassApply(testBsUser2).getCode());
		assertEquals(CME.error.getCode(), bsUser2Service.passApply(new BsUser2()).getCode());
		assertEquals(CME.error.getCode(), bsUser2Service.noPassApply(new BsUser2()).getCode());
	}
	
	@Test
	public void testLogin() {
		assertEquals(CME.success.getCode(), bsUser2Service.login(testString, testString, "123").getCode());
		assertEquals(CME.success.getCode(), bsUser2Service.currentLoggedIn().getCode());
		assertEquals(CME.loginFailed.getCode(), bsUser2Service.login(testString, "12", "123").getCode());
	}
	
	@Test
	public void testLogout() {
		assertEquals(CME.success.getCode(), bsUser2Service.logout().getCode());
		assertEquals(CME.unlogin.getCode(), bsUser2Service.currentLoggedIn().getCode());
	}

}
