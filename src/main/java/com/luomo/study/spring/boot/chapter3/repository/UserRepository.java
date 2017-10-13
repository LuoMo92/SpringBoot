package com.luomo.study.spring.boot.chapter3.repository;

import com.luomo.study.spring.boot.chapter3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by LiuMei on 2017-10-13.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("SELECT age FROM User u where u.name=:name")
    Integer findAge(@Param("name") String name);

}
