package xyz.jangle.demoname.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsDemo;
import xyz.jangle.test.utils.JUnitRunSupport;

/** 
* @author jangle E-mail: jangle@jangle.xyz
* @version 2019年1月18日 下午12:38:57 
* 类说明 
*/
public class BsDemoMapperTest extends JUnitRunSupport {
	
	@Autowired
	private BsDemoMapper bsDemoMapper;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAll() {
		bsDemoMapper.selectAll();
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectPage() {
		BsDemo record = new BsDemo();
		record.setPageStart(0L);
		record.setPageNum(1);
		record.setPageSize(10);
		List<BsDemo> page = bsDemoMapper.selectPage(record );
		assertNotNull(page);
	}
	
	@Test
	public void testSelectPageCount() {
		BsDemo record = new BsDemo();
		Long count = bsDemoMapper.selectPageCount(record);
		assertTrue(count>0);
	}

}
