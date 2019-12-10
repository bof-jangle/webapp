package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsMailConfig;
import xyz.jangle.demoname.service.BsMailConfigService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 邮件配置表 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BsMailConfigServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsMailConfigService bsMailConfigService;
	
	private BsMailConfig testBsMailConfig = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsMailConfig record = new BsMailConfig();
		record.setDmDesc(testString);
		ResultModel<BsMailConfig> resultModel = bsMailConfigService.insertOrUpdate(record );
		testBsMailConfig = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsMailConfig.setId(0L);	//根据UUID更新
		assertEquals(CME.success.getCode(), bsMailConfigService.insertOrUpdate(testBsMailConfig).getCode());
		testBsMailConfig.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.error.getCode(), bsMailConfigService.insertOrUpdate(testBsMailConfig).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsMailConfigService.selectByPrimaryKey(testBsMailConfig).getModel());
		assertEquals(CME.success.getCode(), bsMailConfigService.deleteByPrimaryKey(testBsMailConfig).getCode());
		assertEquals("2", bsMailConfigService.selectByPrimaryKey(testBsMailConfig).getModel().getStatus().toString());
		testBsMailConfig.setId(1L);
		assertEquals(CME.error.getCode(), bsMailConfigService.deleteByPrimaryKey(testBsMailConfig).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsMailConfigService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsMailConfigService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.success.getCode(), bsMailConfigService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsMailConfigService.selectByPrimaryKey(testBsMailConfig).getModel().getDmDesc());
		testBsMailConfig.setDmDesc("updateDesc");
		bsMailConfigService.updateByPrimaryKey(testBsMailConfig);
		assertFalse(bsMailConfigService.selectByPrimaryKey(testBsMailConfig).getModel().getDmDesc().equals(testString));
		testBsMailConfig.setId(0L);
		testBsMailConfig.setUuid("");
		bsMailConfigService.updateByPrimaryKey(testBsMailConfig).getCode().equals(CME.error.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsMailConfigService.selectPage(new BsMailConfig()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsMailConfigService.selectByPrimaryKey(testBsMailConfig);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsMailConfig record = new BsMailConfig();
		assertEquals(CME.unFindIdsToDelete.getCode(), bsMailConfigService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.unFindIdsToDelete.getCode(), bsMailConfigService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testBsMailConfig.getId().toString());
		bsMailConfigService.batchDeleteByPrimaryKey(record);
		assertEquals("2", bsMailConfigService.selectByPrimaryKey(testBsMailConfig).getModel().getStatus().toString());
		bsMailConfigService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, bsMailConfigService.selectByPrimaryKey(testBsMailConfig).getModel());
	}
	
	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsMailConfigService.selectByPrimaryKeyForAnnotation(testBsMailConfig));
	}

}
