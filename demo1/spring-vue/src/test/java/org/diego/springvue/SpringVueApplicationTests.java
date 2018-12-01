package org.diego.springvue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringVueApplicationTests {

	@Autowired
	BackUserRepository repository;

	@Test
	public void test() {
		String account = "diego";
		// 检查并新建一个用户
		BackUser user = repository.findByAccount(account);
		
		if(user == null) {
			user = new BackUser();
			user.setAccount(account);
			repository.insert(user);
			System.out.println("新建用户成功: " + account);
			return;
		}

		System.out.println("用户已存在: " + account);
	}

}
