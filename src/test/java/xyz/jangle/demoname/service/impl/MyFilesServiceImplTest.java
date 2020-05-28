package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.MyFiles;
import xyz.jangle.demoname.service.MyFilesService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 文件、资料 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class MyFilesServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private MyFilesService myFilesService;
	
	private MyFiles testMyFiles = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		MyFiles record = new MyFiles();
		record.setDmDesc(testString);
		ResultModel<MyFiles> resultModel = myFilesService.insertOrUpdate(record );
		testMyFiles = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testMyFiles.setId(0L);	//根据UUID更新
		assertEquals(CME.SUCCESS.getCode(), myFilesService.insertOrUpdate(testMyFiles).getCode());
		testMyFiles.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.ERROR.getCode(), myFilesService.insertOrUpdate(testMyFiles).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(myFilesService.selectByPrimaryKey(testMyFiles).getModel());
		assertEquals(CME.SUCCESS.getCode(), myFilesService.deleteByPrimaryKey(testMyFiles).getCode());
		assertEquals("2", myFilesService.selectByPrimaryKey(testMyFiles).getModel().getStatus().toString());
		testMyFiles.setId(1L);
		assertEquals(CME.ERROR.getCode(), myFilesService.deleteByPrimaryKey(testMyFiles).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(myFilesService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(myFilesService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.SUCCESS.getCode(), myFilesService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, myFilesService.selectByPrimaryKey(testMyFiles).getModel().getDmDesc());
		testMyFiles.setDmDesc("updateDesc");
		myFilesService.updateByPrimaryKey(testMyFiles);
		assertFalse(myFilesService.selectByPrimaryKey(testMyFiles).getModel().getDmDesc().equals(testString));
		testMyFiles.setId(0L);
		testMyFiles.setUuid("");
		myFilesService.updateByPrimaryKey(testMyFiles).getCode().equals(CME.ERROR.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(myFilesService.selectPage(new MyFiles()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		myFilesService.selectByPrimaryKey(testMyFiles);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		MyFiles record = new MyFiles();
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), myFilesService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), myFilesService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testMyFiles.getId().toString());
		myFilesService.batchDeleteByPrimaryKey(record);
		assertEquals("2", myFilesService.selectByPrimaryKey(testMyFiles).getModel().getStatus().toString());
		myFilesService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, myFilesService.selectByPrimaryKey(testMyFiles).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(myFilesService.selectByPrimaryKeyForAnnotation(testMyFiles));
	}

}
