package com.wwh.pay.unionpay.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.wwh.pay.unionpay.config.BaseProperties;


@WebFilter(filterName="CharsetEncodingFilter",urlPatterns="/*")
public class CharsetEncodingFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding(BaseProperties.encoding_UTF8);
		response.setContentType("text/html; charset="+ BaseProperties.encoding_UTF8);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
