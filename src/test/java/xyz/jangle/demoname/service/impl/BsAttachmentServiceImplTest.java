package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsAttachment;
import xyz.jangle.demoname.service.BsAttachmentService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 附件上传存放管理 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BsAttachmentServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsAttachmentService bsAttachmentService;
	
	private BsAttachment testBsAttachment = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsAttachment record = new BsAttachment();
		record.setDmDesc(testString);
		record.setAttSourceType(BsAttachment.tableName);
		ResultModel<BsAttachment> resultModel = bsAttachmentService.insertOrUpdate(record );
		testBsAttachment = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsAttachment.setId(0L);	//根据UUID更新
		assertEquals(CME.success.getCode(), bsAttachmentService.insertOrUpdate(testBsAttachment).getCode());
		testBsAttachment.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.error.getCode(), bsAttachmentService.insertOrUpdate(testBsAttachment).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsAttachmentService.selectByPrimaryKey(testBsAttachment).getModel());
		assertEquals(CME.success.getCode(), bsAttachmentService.deleteByPrimaryKey(testBsAttachment).getCode());
		assertEquals(BsAttachment.tableName+"__deleted", bsAttachmentService.selectByPrimaryKey(testBsAttachment).getModel().getAttSourceType().toString());
		testBsAttachment.setId(1L);
		assertEquals(CME.error.getCode(), bsAttachmentService.deleteByPrimaryKey(testBsAttachment).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsAttachmentService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsAttachmentService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.success.getCode(), bsAttachmentService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsAttachmentService.selectByPrimaryKey(testBsAttachment).getModel().getDmDesc());
		testBsAttachment.setDmDesc("updateDesc");
		bsAttachmentService.updateByPrimaryKey(testBsAttachment);
		assertFalse(bsAttachmentService.selectByPrimaryKey(testBsAttachment).getModel().getDmDesc().equals(testString));
		testBsAttachment.setId(0L);
		testBsAttachment.setUuid("");
		bsAttachmentService.updateByPrimaryKey(testBsAttachment).getCode().equals(CME.error.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsAttachmentService.selectPage(new BsAttachment()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsAttachmentService.selectByPrimaryKey(testBsAttachment);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsAttachment record = new BsAttachment();
		assertEquals(CME.unFindIdsToDelete.getCode(), bsAttachmentService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.unFindIdsToDelete.getCode(), bsAttachmentService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testBsAttachment.getId().toString());
		bsAttachmentService.batchDeleteByPrimaryKey(record);
		assertEquals(BsAttachment.tableName+"__deleted", bsAttachmentService.selectByPrimaryKey(testBsAttachment).getModel().getAttSourceType().toString());
		bsAttachmentService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, bsAttachmentService.selectByPrimaryKey(testBsAttachment).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsAttachmentService.selectByPrimaryKeyForAnnotation(testBsAttachment));
	}

}
