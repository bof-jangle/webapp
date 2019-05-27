package xyz.jangle.demoname.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import xyz.jangle.demoname.model.BsUser;
import xyz.jangle.demoname.service.BsUserService;
import xyz.jangle.utils.CME;
import xyz.jangle.utils.JConstant;
import xyz.jangle.utils.ResultModel;
import xyz.jangle.utils.ResultModelList;

@Controller
@RequestMapping("/bsUserCtrl")
public class BsUserCtrl {
	// 养成一种习惯，将项目的控制层对象，对应的视图，视图所用的js文件，三个名称进行统一。用Ctrl+R查找时可以很方便地找到他们
	@Autowired
	private BsUserService bsUserService;

	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam(value = "id", required = false) Integer id) {
//		List<DemoModel> users = bsUserService
		ModelAndView mav = new ModelAndView("hello"); // 参数为试图名称 viewName
//		mav.addObject("users", users); // 添加model用于EL表达式输出值
		return mav;
	}

	/**
	 * 新增记录
	 * 
	 * @param bsUser
	 * @return
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public ResultModel<BsUser> insert(BsUser bsUser) {
		return bsUserService.insertOrUpdate(bsUser);
	}
	
	
	/**
	 * 申请用户
	 * @param bsUser
	 * @return
	 */
	@RequestMapping("/applyUser")
	@ResponseBody
	public ResultModel<BsUser> applyUser(BsUser bsUser) {
		bsUser.setId(0L);
		bsUser.setUsrStatus(JConstant.status_9);
		ResultModel<BsUser> resultModel = bsUserService.insertOrUpdate(bsUser);
		if(resultModel.getCode().equals(CME.exception.getCode())) {
			if(resultModel.getExceptionCause().getClass().equals(MySQLIntegrityConstraintViolationException.class)) {
				if(resultModel.getMessage().contains("idx_bs_user_extends1")) {
					resultModel.setMessage("您已经有一个用户正在申请了");
				}
			}
		}
		return resultModel;
	}
	
	//  审批通过
	@RequestMapping("/passApply")
	@ResponseBody
	public ResultModel<BsUser> passApply(BsUser bsUser) {
		return bsUserService.passApply(bsUser);
	}
	//  审批不通过
	@RequestMapping("/noPassApply")
	@ResponseBody
	public ResultModel<BsUser> noPassApply(BsUser bsUser) {
		return bsUserService.noPassApply(bsUser);
	}
	
	/**
	 * 删除记录
	 * 
	 * @param bsUser
	 * @return
	 */
	@RequestMapping("/deleteByPrimaryKey")
	@ResponseBody
	public ResultModel<BsUser> deleteByPrimaryKey(BsUser bsUser) {
		return bsUserService.deleteByPrimaryKey(bsUser);

	}
	
	
	/**
	 * 批量删除
	 * @param bsUser
	 * @return
	 */
	@RequestMapping("/batchDeleteByPrimaryKey")
	@ResponseBody
	public ResultModel<BsUser> batchDeleteByPrimaryKey(BsUser bsUser) {
		return bsUserService.batchDeleteByPrimaryKey(bsUser);
		
	}
	
	

	/**
	 * 更新记录
	 * 
	 * @param bsUser
	 * @return
	 */
	@RequestMapping("/updateByPrimaryKey")
	@ResponseBody
	public ResultModel<BsUser> updateByPrimaryKey(BsUser bsUser) {
		return bsUserService.updateByPrimaryKey(bsUser);
	}

	/**
	 * 查询记录
	 * 
	 * @param bsUser
	 * @return
	 */
	@RequestMapping("/selectByPrimaryKey")
	@ResponseBody
	public ResultModel<BsUser> selectByPrimaryKey(BsUser bsUser) {
		return bsUserService.selectByPrimaryKey(bsUser);
	}
	
	@RequestMapping("/selectPage.ctrl")
	@ResponseBody
	ResultModelList<BsUser> selectPage(BsUser record) {
		return bsUserService.selectPage(record);
	}

}
