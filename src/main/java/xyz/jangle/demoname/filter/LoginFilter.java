package xyz.jangle.demoname.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import xyz.jangle.utils.JConstant;

/**
 * 
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2018年9月27日 下午2:40:26 类说明
 */
public class LoginFilter implements Filter {

	private static Logger logger = Logger.getLogger(LoginFilter.class);

	private static String loginHtml = "/login.html"; // 登录页面路径

	String[] endWithAtt; // 以此字符串结尾的，不被拦截
	String[] containsAtt; // 包含此字符串的，不被拦截
	String[] notContainsAtt; // 不包含此字符串的，不被拦截
	// 三个规则符合一个即不被拦截，若被拦截，则需要登陆

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		String endWithStr = filterConfig.getInitParameter("endWith");
		String contains = filterConfig.getInitParameter("contains");
		String notContains = filterConfig.getInitParameter("notContains");
//		logger.info(endWithStr);
//		logger.info(contains);
//		logger.info(notContains);
		if (endWithStr != null) {
			endWithAtt = endWithStr.split(",");
		} else {
			endWithAtt = new String[] {};
		}
		if (contains != null && contains != "") {
			containsAtt = contains.split(",");
		} else {
			containsAtt = new String[] { "cjmm" };
		}
		if (notContains != null) {
			notContainsAtt = notContains.split(",");
		} else {
			notContainsAtt = new String[] {};
		}

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		String uri = servletRequest.getRequestURI();
		logger.debug("uri:" + uri);
		// 1、规则判断，是否拦截
		for (String endWith : endWithAtt) {
			if (uri.endsWith(endWith)) {
				chain.doFilter(servletRequest, servletResponse);
				return;
			}
		}
		for (String c : containsAtt) {
			if (uri.contains(c)) {
				// 此处添加访问记录
//				JResumeAccessQueue.add(session, uri);
				chain.doFilter(servletRequest, servletResponse);
				return;
			}
		}
		for (String nc : notContainsAtt) {
			if (!uri.contains(nc)) {
				chain.doFilter(servletRequest, servletResponse);
				return;
			}
		}
		// 以上规则都未通过，则该请求被拦截，需要登陆后才能请求
		// 2、判断是否已经登陆（2与1顺序可以互换。）
		logger.debug("jgName:" + session.getAttribute(JConstant.name));
		if (session.getAttribute(JConstant.name) != null) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// 未登录则跳转到登陆页面
		servletResponse.sendRedirect(loginHtml);
	}

	@Override
	public void destroy() {

	}

}
