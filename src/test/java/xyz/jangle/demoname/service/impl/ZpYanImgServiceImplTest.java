package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.ZpYanImg;
import xyz.jangle.demoname.service.ZpYanImgService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* yan的作品 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class ZpYanImgServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private ZpYanImgService zpYanImgService;
	
	private ZpYanImg testZpYanImg = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		ZpYanImg record = new ZpYanImg();
		record.setDmDesc(testString);
		ResultModel<ZpYanImg> resultModel = zpYanImgService.insertOrUpdate(record );
		testZpYanImg = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testZpYanImg.setId(0L);	//根据UUID更新
		assertEquals(CME.success.getCode(), zpYanImgService.insertOrUpdate(testZpYanImg).getCode());
		testZpYanImg.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.error.getCode(), zpYanImgService.insertOrUpdate(testZpYanImg).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(zpYanImgService.selectByPrimaryKey(testZpYanImg).getModel());
		assertEquals(CME.success.getCode(), zpYanImgService.deleteByPrimaryKey(testZpYanImg).getCode());
		assertEquals("2", zpYanImgService.selectByPrimaryKey(testZpYanImg).getModel().getStatus().toString());
		testZpYanImg.setId(1L);
		assertEquals(CME.error.getCode(), zpYanImgService.deleteByPrimaryKey(testZpYanImg).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(zpYanImgService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(zpYanImgService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.success.getCode(), zpYanImgService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, zpYanImgService.selectByPrimaryKey(testZpYanImg).getModel().getDmDesc());
		testZpYanImg.setDmDesc("updateDesc");
		zpYanImgService.updateByPrimaryKey(testZpYanImg);
		assertFalse(zpYanImgService.selectByPrimaryKey(testZpYanImg).getModel().getDmDesc().equals(testString));
		testZpYanImg.setId(0L);
		testZpYanImg.setUuid("");
		zpYanImgService.updateByPrimaryKey(testZpYanImg).getCode().equals(CME.error.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(zpYanImgService.selectPage(new ZpYanImg()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		zpYanImgService.selectByPrimaryKey(testZpYanImg);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		ZpYanImg record = new ZpYanImg();
		assertEquals(CME.unFindIdsToDelete.getCode(), zpYanImgService.batchDeleteByPrimaryKey(record).getCode());
		record.setIds(testZpYanImg.getId().toString());
		zpYanImgService.batchDeleteByPrimaryKey(record);
		assertEquals("2", zpYanImgService.selectByPrimaryKey(testZpYanImg).getModel().getStatus().toString());
	}

}
