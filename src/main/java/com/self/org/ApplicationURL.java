package com.self.org;

import javax.servlet.http.*;

public class ApplicationURL{
	private static ApplicationURL instance = new ApplicationURL( );
	private String url;
	private HttpServletRequest requests;
	
	 private ApplicationURL(){ }
	 
	public void setRequests(HttpServletRequest requests) {
		this.requests = requests;
	}
	public HttpServletRequest getRequests() {
		return requests;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	public static ApplicationURL getInstance( ) {
	    return instance;
	}
}