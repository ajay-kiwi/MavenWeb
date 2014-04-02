package com.self.org;
 
import com.self.org.ApplicationURL;

import java.io.IOException;
import java.util.Date;
 

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
 
public class OpenIdFilter implements Filter {
 
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest request = (HttpServletRequest) req;
		String url = request.getRequestURL().toString();
		ApplicationURL.getInstance().setUrl(url);
        chain.doFilter(req, res);
    }
    
    public void init(FilterConfig config) throws ServletException {
        //Print the init parameter
        System.out.println("Init Filter================ ");
    }
    public void destroy() {
        //add code to release any resource
    }
}