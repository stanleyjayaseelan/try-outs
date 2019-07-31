package com.stanley.autocomplete.autocomplete.controller.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

	private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";

	private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";

	private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";

	private static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		((HttpServletResponse) response).setHeader(ACCESS_CONTROL_ALLOW_ORIGIN,
				"*");
		((HttpServletResponse) response).setHeader(ACCESS_CONTROL_ALLOW_METHODS,
				"OPTIONS, GET, POST, DELETE, PUT, PATCH");
		((HttpServletResponse) response).setHeader(ACCESS_CONTROL_ALLOW_HEADERS,
				"Content-Type, api_key, Authorization");
		((HttpServletResponse) response).setHeader(
				ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition");
		((HttpServletResponse) response)
				.setHeader(ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Length");
		((HttpServletResponse) response).setHeader(
				ACCESS_CONTROL_EXPOSE_HEADERS, ACCESS_CONTROL_ALLOW_METHODS);
		((HttpServletResponse) response).setHeader(
				ACCESS_CONTROL_EXPOSE_HEADERS, ACCESS_CONTROL_ALLOW_ORIGIN);
		((HttpServletResponse) response).setHeader(
				ACCESS_CONTROL_EXPOSE_HEADERS, ACCESS_CONTROL_ALLOW_HEADERS);
		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// Intentionally kept empty because filter implementation needs it.
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// Intentionally kept empty because filter implementation needs it.
	}
}