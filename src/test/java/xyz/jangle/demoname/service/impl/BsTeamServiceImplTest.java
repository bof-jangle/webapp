package xyz.jangle.demoname.service.impl;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.jangle.demoname.model.BsTeam;
import xyz.jangle.demoname.service.BsTeamService;
import xyz.jangle.test.utils.JUnitRunSupport;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.Jutils;
import xyz.jangle.utils.ResultModel;

/** 
* 队伍管理 单元测试
* @author jangle E-mail: jangle@jangle.xyz
* @version Jangle生成工具v1.1
* 类说明 
*/
public class BsTeamServiceImplTest extends JUnitRunSupport {
	
	@Autowired
	private BsTeamService bsTeamService;
	
	private BsTeam testBsTeam = null;
	
	private final String testString = "jangleTest";

	@Before
	public void setUp() throws Exception {
		BsTeam record = new BsTeam();
		record.setDmDesc(testString);
		ResultModel<BsTeam> resultModel = bsTeamService.insertOrUpdate(record );
		testBsTeam = resultModel.getModel();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInsert() {
		testBsTeam.setId(0L);	//根据UUID更新
		assertEquals(CME.SUCCESS.getCode(), bsTeamService.insertOrUpdate(testBsTeam).getCode());
		testBsTeam.setId(1L);	//无对应的主键记录报错
		assertEquals(CME.ERROR.getCode(), bsTeamService.insertOrUpdate(testBsTeam).getCode());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertNotNull(bsTeamService.selectByPrimaryKey(testBsTeam).getModel());
		assertEquals(CME.SUCCESS.getCode(), bsTeamService.deleteByPrimaryKey(testBsTeam).getCode());
		assertEquals("2", bsTeamService.selectByPrimaryKey(testBsTeam).getModel().getStatus().toString());
		testBsTeam.setId(1L);
		assertEquals(CME.ERROR.getCode(), bsTeamService.deleteByPrimaryKey(testBsTeam).getCode());
	}

	@Test
	public void testSelectAll() {
		assertFalse(bsTeamService.selectAll().getList().isEmpty());
	}

	@Test
	public void testSelectByParam() {
		Map<String, Object> param = Jutils.getHashMapSO();
		param.put("dmDesc", testString);
		assertFalse(bsTeamService.selectByParam(param).getList().isEmpty());
		param.put("dmDesc", "&^%$*&");
		assertEquals(CME.SUCCESS.getCode(), bsTeamService.selectByParam(param).getCode());
	}

	@Test
	public void testUpdateByPrimaryKey() {
		assertEquals(testString, bsTeamService.selectByPrimaryKey(testBsTeam).getModel().getDmDesc());
		testBsTeam.setDmDesc("updateDesc");
		bsTeamService.updateByPrimaryKey(testBsTeam);
		assertFalse(bsTeamService.selectByPrimaryKey(testBsTeam).getModel().getDmDesc().equals(testString));
		testBsTeam.setId(0L);
		testBsTeam.setUuid("");
		bsTeamService.updateByPrimaryKey(testBsTeam).getCode().equals(CME.ERROR.getCode());
	}

	@Test
	public void testSelectPage() {
		assertFalse(bsTeamService.selectPage(new BsTeam()).getList().isEmpty());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		bsTeamService.selectByPrimaryKey(testBsTeam);
	}
	
	@Test
	public void testBatchDeleteByPrimaryKey() {
		BsTeam record = new BsTeam();
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsTeamService.batchDeleteByPrimaryKey(record).getCode());
		assertEquals(CME.UNFIND_IDS_TO_DELETE.getCode(), bsTeamService.batchDeleteByPrimaryKeyActually(record).getCode());
		record.setIds(testBsTeam.getId().toString());
		bsTeamService.batchDeleteByPrimaryKey(record);
		assertEquals("2", bsTeamService.selectByPrimaryKey(testBsTeam).getModel().getStatus().toString());
		bsTeamService.batchDeleteByPrimaryKeyActually(record);
		assertEquals(null, bsTeamService.selectByPrimaryKey(testBsTeam).getModel());
	}

	@Test
	public void testSelectByPrimaryKeyForAnnotation(){
		assertNotNull(bsTeamService.selectByPrimaryKeyForAnnotation(testBsTeam));
	}

}
