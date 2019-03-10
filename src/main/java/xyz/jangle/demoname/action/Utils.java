package xyz.jangle.demoname.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/**/utils")
public class Utils {
	
	@RequestMapping("/getEasyUIList")
	@ResponseBody
	public List<String> getEasyUIList(HttpServletRequest request,HttpServletResponse response, HttpSession session) {
		System.out.println(request.toString());
		System.out.println(response.toString());
		List<String> list = new ArrayList<String>();
		String path = session.getServletContext().getRealPath("/");
		path += "easyui/demo";
		File file = new File(path);
		File[] tempArray = file.listFiles();
//		System.out.println("该目录下对象个数：" + tempArray.length);
		for (int i = 0; i < tempArray.length; i++) {
			if (tempArray[i].isDirectory()) {
				list.add(tempArray[i].getName());
			}
		}
		return list;
	}

}
