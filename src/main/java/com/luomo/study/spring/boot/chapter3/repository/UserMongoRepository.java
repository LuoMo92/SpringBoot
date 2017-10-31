package com.luomo.study.spring.boot.chapter3.repository;

import com.luomo.study.spring.boot.chapter3.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author LiuMei
 * @date 2017-10-31.
 */
public interface UserMongoRepository extends MongoRepository<User, Long> {

    User findByName(String name);
}
