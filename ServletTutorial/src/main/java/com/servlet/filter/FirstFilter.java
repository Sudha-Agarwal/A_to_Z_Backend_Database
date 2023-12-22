package com.servlet.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class FirstFilter
 */
public class FirstFilter extends HttpFilter implements Filter {
	private String paramName;
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FirstFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("First Filter - Before Servlet");
		System.out.println("Configured parameter value: " + paramName);

		// pass the request to the next filter or servlet in the chain
		chain.doFilter(request, response);
		System.out.println("First Filter - After Servlet");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		paramName = fConfig.getInitParameter("paramName");
	}

}
