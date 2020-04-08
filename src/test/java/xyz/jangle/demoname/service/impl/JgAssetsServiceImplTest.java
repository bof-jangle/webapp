package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.JgAssets;
import xyz.jangle.demoname.service.JgAssetsService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 资产管理 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class JgAssetsServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private JgAssetsService jgAssetsService;
	
	private JgAssets testJgAssets = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		JgAssets record = new JgAssets();
		record.setDmDesc(testString);
		ResultModel<JgAssets> resultModel = jgAssetsService.insertOrUpdate(record );
		testJgAssets = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testJgAssets.setId(0L);	//根据UUID更新
		assertEquals(CME.success.getCode(), jgAssetsService.insertOrUpdate(testJgAssets).getCode());
		testJgAssets.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.error.getCode(), jgAssetsService.insertOrUpdate(testJgAssets).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(jgAssetsService.selectByPrimaryKey(testJgAssets).getModel());
		assertEquals(CME.success.getCode(), jgAssetsService.deleteByPrimaryKey(testJgAssets).getCode());
		assertEquals("2", jgAssetsService.selectByPrimaryKey(testJgAssets).getModel().getStatus().toString());
		testJgAssets.setId(1L);
		assertEquals(CME.error.getCode(), jgAssetsService.deleteByPrimaryKey(testJgAssets).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(jgAssetsService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(jgAssetsService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.success.getCode(), jgAssetsService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, jgAssetsService.selectByPrimaryKey(testJgAssets).getModel().getDmDesc());
		testJgAssets.setDmDesc("updateDesc");
		jgAssetsService.updateByPrimaryKey(testJgAssets);
		assertFalse(jgAssetsService.selectByPrimaryKey(testJgAssets).getModel().getDmDesc().equals(testString));
		testJgAssets.setId(0L);
		testJgAssets.setUuid("");
		jgAssetsService.updateByPrimaryKey(testJgAssets).getCode().equals(CME.error.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(jgAssetsService.selectPage(new JgAssets()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		jgAssetsService.selectByPrimaryKey(testJgAssets);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		JgAssets record = new JgAssets();
		assertEquals(CME.unFindIdsToDelete.getCode(), jgAssetsService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.unFindIdsToDelete.getCode(), jgAssetsService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testJgAssets.getId().toString());
		jgAssetsService.batchDeleteByPrimaryKey(record);
		assertEquals("2", jgAssetsService.selectByPrimaryKey(testJgAssets).getModel().getStatus().toString());
		jgAssetsService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, jgAssetsService.selectByPrimaryKey(testJgAssets).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(jgAssetsService.selectByPrimaryKeyForAnnotation(testJgAssets));
	}

}
