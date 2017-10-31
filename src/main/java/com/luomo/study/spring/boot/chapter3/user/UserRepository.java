package com.luomo.study.spring.boot.chapter3.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LiuMei on 2017-10-13.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
