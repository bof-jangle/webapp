package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsDemo;
import xyz.jangle.demoname.service.BsDemoService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* @author jangle E-mail: jangle@jangle.xyz
* @version 2019年3月19日 下午5:14:23 
* 类说明 
*/
public class BsDemoServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsDemoService bsDemoService;
	
	private BsDemo testBsDemo = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsDemo record = new BsDemo();
		record.setDmDesc(testString);
		ResultModel<BsDemo> resultModel = bsDemoService.insertOrUpdate(record );
		testBsDemo = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsDemo.setId(0L);	//根据UUID更新
		assertEquals(CME.success.getCode(), bsDemoService.insertOrUpdate(testBsDemo).getCode());
		testBsDemo.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.error.getCode(), bsDemoService.insertOrUpdate(testBsDemo).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsDemoService.selectByPrimaryKey(testBsDemo).getModel());
		assertEquals(CME.success.getCode(), bsDemoService.deleteByPrimaryKey(testBsDemo).getCode());
		assertEquals("2", bsDemoService.selectByPrimaryKey(testBsDemo).getModel().getStatus().toString());
		testBsDemo.setId(1L);
		assertEquals(CME.error.getCode(), bsDemoService.deleteByPrimaryKey(testBsDemo).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsDemoService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsDemoService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.success.getCode(), bsDemoService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsDemoService.selectByPrimaryKey(testBsDemo).getModel().getDmDesc());
		testBsDemo.setDmDesc("updateDesc");
		bsDemoService.updateByPrimaryKey(testBsDemo);
		assertFalse(bsDemoService.selectByPrimaryKey(testBsDemo).getModel().getDmDesc().equals(testString));
		testBsDemo.setId(0L);
		testBsDemo.setUuid("");
		bsDemoService.updateByPrimaryKey(testBsDemo).getCode().equals(CME.error.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsDemoService.selectPage(new BsDemo()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsDemoService.selectByPrimaryKeyForAnnotation(testBsDemo));
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsDemoService.selectByPrimaryKey(testBsDemo);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsDemo record = new BsDemo();
		assertEquals(CME.unFindIdsToDelete.getCode(), bsDemoService.batchDeleteByPrimaryKey(record).getCode());
		record.setIds(testBsDemo.getId().toString());
		bsDemoService.batchDeleteByPrimaryKey(record);
		assertEquals("2", bsDemoService.selectByPrimaryKey(testBsDemo).getModel().getStatus().toString());
	}

}
