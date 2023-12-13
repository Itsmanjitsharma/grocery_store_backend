package com.grocerystore.store;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;

@WebFilter(urlPatterns = "/login", filterName = "customFilter")
@Order(1) 
public class RedirectFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect("http://localhost:5173/login");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
     
    }

    @Override
    public void destroy() {
    }

}
