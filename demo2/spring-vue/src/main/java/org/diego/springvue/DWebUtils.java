package org.diego.springvue;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class DWebUtils {
	
	public static final HttpServletResponse getResponse() {
    	return ((ServletRequestAttributes)
    			RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	public static final HttpServletRequest getRequest() {
    	return ((ServletRequestAttributes)
    			RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public static final String getString(String name) {
		return getParameter(name);
	}

	public static final int getInt(String name) {
		String v = getString(name);
		if (isEmpty(v)) {
			return -1;
		};
		return Integer.parseInt(v);
	}

	public static final String getParameter(String name) {
		HttpServletRequest request = getRequest();
		String v = request.getParameter(name);
		if (isEmpty(v) || "undefined".equalsIgnoreCase(v) || "null".equalsIgnoreCase(v)) {
			return "";
		}
		return v;
	}
	
	public static final boolean isEmpty(String v) {
		return v == null || v.trim().equals("");
	}

    
	public static void jsonResult(Object o) {
		HttpServletResponse response = getResponse();
    	try {
			response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 1);
			response.getWriter().write(o.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
		}
    }

}
