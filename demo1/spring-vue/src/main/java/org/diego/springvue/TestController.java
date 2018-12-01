package org.diego.springvue;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class TestController {

    @Autowired
    private BackUserRepository repository;
    
	void jsonResult(HttpServletResponse response, Object o) {
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
	
    @GetMapping("/test2")
    public void doTest(String account) throws Exception{
    	
    	// mvc4 中获取 response的做法
    	HttpServletResponse response = ((ServletRequestAttributes)
    			RequestContextHolder.getRequestAttributes()).getResponse();

		if(account == null) {
			this.jsonResult(response,  "请输入账号");
			return;
		}
		
		BackUser user = repository.findByAccount(account);
		if(user == null) {
			this.jsonResult(response,  "没有这个用户: " + account);
			return;			
		}
		
		this.jsonResult(response, user);
    }
}
