//package xyz.jangle.demoname.service.impl;
//
//import static org.junit.Assert.*;
//
//import java.util.Map;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import xyz.jangle.demoname.model.BsExcuteHistory;
//import xyz.jangle.demoname.service.BsExcuteHistoryService;
//import xyz.jangle.test.utils.JUnitRunSupport;
//import xyz.jangle.utils.CME;
//import xyz.jangle.utils.Jutils;
//
///** 
//* 执行记录表 单元测试
//* @author jangle E-mail: jangle@jangle.xyz
//* @version Jangle生成工具v1.1
//* 类说明 
//*/
//public class BsExcuteHistoryServiceImplTest extends JUnitRunSupport {
//	
//	@Autowired
//	private BsExcuteHistoryService bsExcuteHistoryService;
//	
//	private BsExcuteHistory testBsExcuteHistory = null;
//	
//	private final String testString = "jangleTest";
//
//	@Before
//	public void setUp() throws Exception {
//		BsExcuteHistory record = new BsExcuteHistory();
//		record.setDmDesc(testString);
//		bsExcuteHistoryService.insertOrUpdate(record );
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//	
//	@Test
//	public void testInsert() {
//		testBsExcuteHistory.setId(0L);	//根据UUID更新
//		bsExcuteHistoryService.insertOrUpdate(testBsExcuteHistory);
//		testBsExcuteHistory.setId(1L);	//无对应的主键记录报错
//		bsExcuteHistoryService.insertOrUpdate(testBsExcuteHistory);
//	}
//
//	@Test
//	public void testDeleteByPrimaryKey() {
//		assertNotNull(bsExcuteHistoryService.selectByPrimaryKey(testBsExcuteHistory).getModel());
//		assertEquals(CME.success.getCode(), bsExcuteHistoryService.deleteByPrimaryKey(testBsExcuteHistory).getCode());
//		assertEquals("2", bsExcuteHistoryService.selectByPrimaryKey(testBsExcuteHistory).getModel().getStatus().toString());
//		testBsExcuteHistory.setId(1L);
//		assertEquals(CME.error.getCode(), bsExcuteHistoryService.deleteByPrimaryKey(testBsExcuteHistory).getCode());
//	}
//
//	@Test
//	public void testSelectAll() {
//		assertFalse(bsExcuteHistoryService.selectAll().getList().isEmpty());
//	}
//
//	@Test
//	public void testSelectByParam() {
//		Map<String, Object> param = Jutils.getHashMapSO();
//		param.put("dmDesc", testString);
//		assertFalse(bsExcuteHistoryService.selectByParam(param).getList().isEmpty());
//		param.put("dmDesc", "&^%$*&");
//		assertEquals(CME.success.getCode(), bsExcuteHistoryService.selectByParam(param).getCode());
//	}
//
//	@Test
//	public void testUpdateByPrimaryKey() {
//		assertEquals(testString, bsExcuteHistoryService.selectByPrimaryKey(testBsExcuteHistory).getModel().getDmDesc());
//		testBsExcuteHistory.setDmDesc("updateDesc");
//		bsExcuteHistoryService.updateByPrimaryKey(testBsExcuteHistory);
//		assertFalse(bsExcuteHistoryService.selectByPrimaryKey(testBsExcuteHistory).getModel().getDmDesc().equals(testString));
//		testBsExcuteHistory.setId(0L);
//		testBsExcuteHistory.setUuid("");
//		bsExcuteHistoryService.updateByPrimaryKey(testBsExcuteHistory).getCode().equals(CME.error.getCode());
//	}
//
//	@Test
//	public void testSelectPage() {
//		assertFalse(bsExcuteHistoryService.selectPage(new BsExcuteHistory()).getList().isEmpty());
//	}
//	
//	@Test
//	public void testSelectByPrimaryKey() {
//		bsExcuteHistoryService.selectByPrimaryKey(testBsExcuteHistory);
//	}
//	
//	@Test
//	public void testBatchDeleteByPrimaryKey() {
//		BsExcuteHistory record = new BsExcuteHistory();
//		assertEquals(CME.unFindIdsToDelete.getCode(), bsExcuteHistoryService.batchDeleteByPrimaryKey(record).getCode());
//		assertEquals(CME.unFindIdsToDelete.getCode(), bsExcuteHistoryService.batchDeleteByPrimaryKeyActually(record).getCode());
//		record.setIds(testBsExcuteHistory.getId().toString());
//		bsExcuteHistoryService.batchDeleteByPrimaryKey(record);
//		assertEquals("2", bsExcuteHistoryService.selectByPrimaryKey(testBsExcuteHistory).getModel().getStatus().toString());
//		bsExcuteHistoryService.batchDeleteByPrimaryKeyActually(record);
//		assertEquals(null, bsExcuteHistoryService.selectByPrimaryKey(testBsExcuteHistory).getModel());
//	}
//
//	@Test
//	public void testSelectByPrimaryKeyForAnnotation(){
//		assertNotNull(bsExcuteHistoryService.selectByPrimaryKeyForAnnotation(testBsExcuteHistory));
//	}
//
//}
