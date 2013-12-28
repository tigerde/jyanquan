package com.anquan.jy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest freq, ServletResponse fres, FilterChain filter) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) freq;
		HttpServletResponse res = (HttpServletResponse) fres;
		String url = req.getRequestURI();
		String[] pattern = url.split("/");
		if (req.getSession().getAttribute("userid") == null) {
			if (pattern.length > 2 && (pattern[2].equals("jifolder") || pattern[2].equals("login.jsp"))) {
				filter.doFilter(req, res);
			} else if (pattern.length > 3 && pattern[2].equals("user") && pattern[3].equals("login")) {
				filter.doFilter(req, res);
			} else {
				res.getWriter().print("<script type='text/javascript'>top.location = '/jyanquan/login.jsp';</script>");
			}
		} else {
			if (url.equals("/jyanquan/")||url.equals("/jyanquan/login.jsp")) {
				res.sendRedirect("/jyanquan/index.jsp");
			}
			filter.doFilter(req, res);
			
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
