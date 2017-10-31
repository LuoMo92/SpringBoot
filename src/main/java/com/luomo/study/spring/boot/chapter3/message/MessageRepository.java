package com.luomo.study.spring.boot.chapter3.message;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LiuMei
 * @date 2017-10-31.
 */
public interface MessageRepository extends JpaRepository<Message, Long> {

}
