package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsMenu;
import xyz.jangle.demoname.service.BsMenuService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 菜单表 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BsMenuServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsMenuService bsMenuService;
	
	private BsMenu testBsMenu = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsMenu record = new BsMenu();
		record.setDmDesc(testString);
		ResultModel<BsMenu> resultModel = bsMenuService.insertOrUpdate(record );
		testBsMenu = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsMenu.setId(0L);	//根据UUID更新
		assertEquals(CME.SUCCESS.getCode(), bsMenuService.insertOrUpdate(testBsMenu).getCode());
		testBsMenu.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.ERROR.getCode(), bsMenuService.insertOrUpdate(testBsMenu).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsMenuService.selectByPrimaryKey(testBsMenu).getModel());
		assertEquals(CME.SUCCESS.getCode(), bsMenuService.deleteByPrimaryKey(testBsMenu).getCode());
		assertEquals("2", bsMenuService.selectByPrimaryKey(testBsMenu).getModel().getStatus().toString());
		testBsMenu.setId(1L);
		assertEquals(CME.ERROR.getCode(), bsMenuService.deleteByPrimaryKey(testBsMenu).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsMenuService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsMenuService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.SUCCESS.getCode(), bsMenuService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsMenuService.selectByPrimaryKey(testBsMenu).getModel().getDmDesc());
		testBsMenu.setDmDesc("updateDesc");
		bsMenuService.updateByPrimaryKey(testBsMenu);
		assertFalse(bsMenuService.selectByPrimaryKey(testBsMenu).getModel().getDmDesc().equals(testString));
		testBsMenu.setId(0L);
		testBsMenu.setUuid("");
		bsMenuService.updateByPrimaryKey(testBsMenu).getCode().equals(CME.ERROR.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsMenuService.selectPage(new BsMenu()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsMenuService.selectByPrimaryKey(testBsMenu);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsMenu record = new BsMenu();
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsMenuService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsMenuService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testBsMenu.getId().toString());
		bsMenuService.batchDeleteByPrimaryKey(record);
		assertEquals("2", bsMenuService.selectByPrimaryKey(testBsMenu).getModel().getStatus().toString());
		bsMenuService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, bsMenuService.selectByPrimaryKey(testBsMenu).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsMenuService.selectByPrimaryKeyForAnnotation(testBsMenu));
	}

}
