package com.icss.hr.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 通用过滤器
 * 
 * @author Administrator
 *
 */
@WebFilter("/*")
public class CommonFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		// 转换为子接口类型
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//设置响应报头允许当前应用被跨域请求（CROS）
		response.setHeader("Access-Control-Allow-Origin", "*");

		// 统一设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 登录验证		
		String uri = request.getRequestURI();
		String app = request.getContextPath();
		
		System.out.println("请求uri=" + uri);
						
		if ( !uri.equals(app + "/") 
				&& !uri.equals(app + "/login.html") 
				&& !uri.equals(app + "/logout.html")
				&& !uri.equals(app + "/LoginServlet")
				&& !uri.equals(app + "/404.jsp")
				&& !uri.equals(app + "/error.jsp")
				&& !uri.startsWith(app + "/css")
				&& !uri.startsWith(app + "/js")
				&& !uri.startsWith(app + "/images")) {
			
			HttpSession session = request.getSession();			
			String empLoginName = (String) session.getAttribute("empLoginName");
			
			if (empLoginName == null) {
				
				DbUtil.close();
				
				//判断是否是ajax请求	，在响应报头中设置一个标识			
				if (request.getHeader("x-requested-with") != null && 
				    request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
					response.setHeader("sessionStatus", "timeout");					
				} else {
					response.sendRedirect(app + "/logout.html");
				}				
				
				return;
			}
			
		}				

		// 继续向下执行
		chain.doFilter(request, response);

		// 请求响应结束之后调用统一关闭连接方法
		DbUtil.close();
	}

	@Override
	public void destroy() {

	}

}