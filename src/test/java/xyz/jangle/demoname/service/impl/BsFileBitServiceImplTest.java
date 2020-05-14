package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsFileBit;
import xyz.jangle.demoname.service.BsFileBitService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.ResultModel;

/** 
* 文件存储表 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BsFileBitServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsFileBitService bsFileBitService;
	
	private BsFileBit testBsFileBit = null;
	
	private final byte[] testString = new byte[]{'1','2'};

	@Before
	public void setUp() throws Exception {
		BsFileBit record = new BsFileBit();
		record.setBitContent(testString);
		ResultModel<BsFileBit> resultModel = bsFileBitService.insertOrUpdate(record );
		testBsFileBit = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSelectAll() {
		assertFalse(bsFileBitService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsFileBitService.selectPage(new BsFileBit()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsFileBitService.selectByPrimaryKey(testBsFileBit);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsFileBit record = new BsFileBit();
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsFileBitService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testBsFileBit.getId().toString());
		bsFileBitService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, bsFileBitService.selectByPrimaryKey(testBsFileBit).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsFileBitService.selectByPrimaryKeyForAnnotation(testBsFileBit));
	}

}
