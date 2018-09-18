package xyz.jangle.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xyz.jangle.model.DUser;
import xyz.jangle.model.DUserExample;
import xyz.jangle.service.DUserService;

@Controller
@RequestMapping("/**/user")
public class User {
	
	@Autowired
	private DUserService dUserService;
	
	@RequestMapping("/selectUsers")
	@ResponseBody
	public Map<String, Object> selectByExample() {
		Map<String, Object> map = new HashMap<>();
		DUserExample dUserExample = new DUserExample();
		List<DUser> list = dUserService.selectByExample(dUserExample );
		map.put("users", list);
		return map;
	}
	
	
}
