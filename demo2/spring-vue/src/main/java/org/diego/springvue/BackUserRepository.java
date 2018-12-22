package org.diego.springvue;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BackUserRepository extends MongoRepository<BackUser, String>{

	// 这个方法会自动实现
	BackUser findByAccount(String account);
}
