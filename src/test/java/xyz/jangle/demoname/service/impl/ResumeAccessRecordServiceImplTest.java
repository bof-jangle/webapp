package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.ResumeAccessRecord;
import xyz.jangle.demoname.service.ResumeAccessRecordService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 简历访问记录 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class ResumeAccessRecordServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private ResumeAccessRecordService resumeAccessRecordService;
	
	private ResumeAccessRecord testResumeAccessRecord = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		ResumeAccessRecord record = new ResumeAccessRecord();
		record.setDmDesc(testString);
		ResultModel<ResumeAccessRecord> resultModel = resumeAccessRecordService.insertOrUpdate(record );
		testResumeAccessRecord = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testResumeAccessRecord.setId(0L);	//根据UUID更新
		assertEquals(CME.SUCCESS.getCode(), resumeAccessRecordService.insertOrUpdate(testResumeAccessRecord).getCode());
		testResumeAccessRecord.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.ERROR.getCode(), resumeAccessRecordService.insertOrUpdate(testResumeAccessRecord).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(resumeAccessRecordService.selectByPrimaryKey(testResumeAccessRecord).getModel());
		assertEquals(CME.SUCCESS.getCode(), resumeAccessRecordService.deleteByPrimaryKey(testResumeAccessRecord).getCode());
		assertEquals("2", resumeAccessRecordService.selectByPrimaryKey(testResumeAccessRecord).getModel().getStatus().toString());
		testResumeAccessRecord.setId(1L);
		assertEquals(CME.ERROR.getCode(), resumeAccessRecordService.deleteByPrimaryKey(testResumeAccessRecord).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(resumeAccessRecordService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(resumeAccessRecordService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.SUCCESS.getCode(), resumeAccessRecordService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, resumeAccessRecordService.selectByPrimaryKey(testResumeAccessRecord).getModel().getDmDesc());
		testResumeAccessRecord.setDmDesc("updateDesc");
		resumeAccessRecordService.updateByPrimaryKey(testResumeAccessRecord);
		assertFalse(resumeAccessRecordService.selectByPrimaryKey(testResumeAccessRecord).getModel().getDmDesc().equals(testString));
		testResumeAccessRecord.setId(0L);
		testResumeAccessRecord.setUuid("");
		resumeAccessRecordService.updateByPrimaryKey(testResumeAccessRecord).getCode().equals(CME.ERROR.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(resumeAccessRecordService.selectPage(new ResumeAccessRecord()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		resumeAccessRecordService.selectByPrimaryKey(testResumeAccessRecord);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		ResumeAccessRecord record = new ResumeAccessRecord();
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), resumeAccessRecordService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), resumeAccessRecordService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testResumeAccessRecord.getId().toString());
		resumeAccessRecordService.batchDeleteByPrimaryKey(record);
		assertEquals("2", resumeAccessRecordService.selectByPrimaryKey(testResumeAccessRecord).getModel().getStatus().toString());
		resumeAccessRecordService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, resumeAccessRecordService.selectByPrimaryKey(testResumeAccessRecord).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(resumeAccessRecordService.selectByPrimaryKeyForAnnotation(testResumeAccessRecord));
	}

}
