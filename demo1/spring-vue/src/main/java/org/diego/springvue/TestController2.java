package org.diego.springvue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {

    @Autowired
    private BackUserRepository repository;
        
    @GetMapping("/v2")
    public void doTest() throws Exception{
    	
    	String account = DWebUtils.getString("account");

		if(account == null) {
			DWebUtils.jsonResult("请输入账号");
			return;
		}
		
		BackUser user = repository.findByAccount(account);
		if(user == null) {
			DWebUtils.jsonResult("没有这个用户: " + account);
			return;			
		}
		
		DWebUtils.jsonResult(user);
    }
}
