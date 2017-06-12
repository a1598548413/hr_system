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
 * ͨ�ù�����
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

		// ת��Ϊ�ӽӿ�����
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//������Ӧ��ͷ����ǰӦ�ñ���������CROS��
		response.setHeader("Access-Control-Allow-Origin", "*");

		// ͳһ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// ��¼��֤		
		String uri = request.getRequestURI();
		String app = request.getContextPath();
		
		System.out.println("����uri=" + uri);
						
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
				
				//�ж��Ƿ���ajax����	������Ӧ��ͷ������һ����ʶ			
				if (request.getHeader("x-requested-with") != null && 
				    request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
					response.setHeader("sessionStatus", "timeout");					
				} else {
					response.sendRedirect(app + "/logout.html");
				}				
				
				return;
			}
			
		}				

		// ��������ִ��
		chain.doFilter(request, response);

		// ������Ӧ����֮�����ͳһ�ر����ӷ���
		DbUtil.close();
	}

	@Override
	public void destroy() {

	}

}