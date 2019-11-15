package xyz.jangle.demoname.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import xyz.jangle.demoname.model.BsUser2;
import xyz.jangle.demoname.service.BsUser2Service;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

/**
 * 用户表V2 控制层
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
@Controller
@RequestMapping("/bsUser2Ctrl")
public class BsUser2Ctrl {

	@Autowired
	private BsUser2Service bsUser2Service;

	// 增
	@RequestMapping("/insert.ctrl")
	@ResponseBody
	ResultModel<BsUser2> insert(BsUser2 record) {
		return bsUser2Service.insertOrUpdate(record);
	}

	// 删
	@RequestMapping("/deleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsUser2> deleteByPrimaryKey(BsUser2 record) {
		return bsUser2Service.deleteByPrimaryKey(record);
	}

	// 改
	@RequestMapping("/updateByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsUser2> updateByPrimaryKey(BsUser2 record) {
		return bsUser2Service.updateByPrimaryKey(record);
	}
	
	// 单查
	@RequestMapping("/selectByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsUser2> selectByPrimaryKey(BsUser2 record) {
		return bsUser2Service.selectByPrimaryKey(record);
	}

	// 分查
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsUser2> selectPage(BsUser2 record) {
		return bsUser2Service.selectPage(record);
	}

	// 全查
	@RequestMapping("/selectAll.ctrl")
	@ResponseBody
	ResultModelList<BsUser2> selectAll() {
		return bsUser2Service.selectAll();
	}
		
	// 批删
	@RequestMapping("/batchDeleteByPrimaryKey.ctrl")
	@ResponseBody
	ResultModel<BsUser2> batchDeleteByPrimaryKey(BsUser2 record) {
		return bsUser2Service.batchDeleteByPrimaryKey(record);
	}
	
	/**
	 * 申请用户
	 * @param bsUser
	 * @return
	 */
	@RequestMapping("/applyUser")
	@ResponseBody
	public ResultModel<BsUser2> applyUser(BsUser2 bsUser2) {
		bsUser2.setId(0L);
		bsUser2.setStatus(JConstant.status_9);
		ResultModel<BsUser2> resultModel = bsUser2Service.insertOrUpdate(bsUser2);
		if(resultModel.getCode().equals(CME.exception.getCode())) {
			if(resultModel.getExceptionCause().getClass().equals(MySQLIntegrityConstraintViolationException.class)) {
				if(resultModel.getMessage().contains("idx_bs_user2_jg_apply_ip")) {
					resultModel.setMessage("您已经有一个用户正在申请了");
				}
			}
		}
		return resultModel;
	}
	
	//  审批通过
	@RequestMapping("/passApply")
	@ResponseBody
	public ResultModel<BsUser2> passApply(BsUser2 bsUser2) {
		return bsUser2Service.passApply(bsUser2);
	}
	//  审批不通过
	@RequestMapping("/noPassApply")
	@ResponseBody
	public ResultModel<BsUser2> noPassApply(BsUser2 bsUser2) {
		return bsUser2Service.noPassApply(bsUser2);
	}
	
	//	校验英文帐号是否已使用
	@RequestMapping("/hasCode.ctrl")
	@ResponseBody
	public Map<String, Object> hasCode(BsUser2 bsUser2){
		Map<String, Object> map = new HashMap<String, Object>();
		if(bsUser2.getId() > 0) {
			map.put("valid", true);
			return map;
		}
		ResultModel<BsUser2> selectByCode = bsUser2Service.selectByCode(bsUser2);
		if(selectByCode.getModel() == null) {
			map.put("valid", true);
		}else {
			map.put("valid", false);
		}
		return map;
	}

}
