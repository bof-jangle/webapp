package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsRole;
import xyz.jangle.demoname.service.BsRoleService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 角色管理 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BsRoleServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsRoleService bsRoleService;
	
	private BsRole testBsRole = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsRole record = new BsRole();
		record.setDmDesc(testString);
		ResultModel<BsRole> resultModel = bsRoleService.insertOrUpdate(record );
		testBsRole = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsRole.setId(0L);	//根据UUID更新
		assertEquals(CME.success.getCode(), bsRoleService.insertOrUpdate(testBsRole).getCode());
		testBsRole.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.error.getCode(), bsRoleService.insertOrUpdate(testBsRole).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsRoleService.selectByPrimaryKey(testBsRole).getModel());
		assertEquals(CME.success.getCode(), bsRoleService.deleteByPrimaryKey(testBsRole).getCode());
		assertEquals("2", bsRoleService.selectByPrimaryKey(testBsRole).getModel().getStatus().toString());
		testBsRole.setId(1L);
		assertEquals(CME.error.getCode(), bsRoleService.deleteByPrimaryKey(testBsRole).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsRoleService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsRoleService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.success.getCode(), bsRoleService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsRoleService.selectByPrimaryKey(testBsRole).getModel().getDmDesc());
		testBsRole.setDmDesc("updateDesc");
		bsRoleService.updateByPrimaryKey(testBsRole);
		assertFalse(bsRoleService.selectByPrimaryKey(testBsRole).getModel().getDmDesc().equals(testString));
		testBsRole.setId(0L);
		testBsRole.setUuid("");
		bsRoleService.updateByPrimaryKey(testBsRole).getCode().equals(CME.error.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsRoleService.selectPage(new BsRole()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsRoleService.selectByPrimaryKey(testBsRole);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsRole record = new BsRole();
		assertEquals(CME.unFindIdsToDelete.getCode(), bsRoleService.batchDeleteByPrimaryKey(record).getCode());
		record.setIds(testBsRole.getId().toString());
		bsRoleService.batchDeleteByPrimaryKey(record);
		assertEquals("2", bsRoleService.selectByPrimaryKey(testBsRole).getModel().getStatus().toString());
	}

}
