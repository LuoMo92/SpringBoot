package com.luomo.study.spring.boot;

import com.luomo.study.spring.boot.chapter3.message.Message;
import com.luomo.study.spring.boot.chapter3.message.MessageRepository;
import com.luomo.study.spring.boot.chapter3.user.UserRepository;
import com.luomo.study.spring.boot.chapter3.user.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author LiuMei
 * @date 2017-10-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MultiDatabaseTests2 {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
        messageRepository.deleteAll();
    }

    @Test
    public void test2() throws Exception {
        userRepository.save(new User("aaa", 10));
        userRepository.save(new User("bbb", 20));
        userRepository.save(new User("ccc", 30));
        userRepository.save(new User("ddd", 40));
        userRepository.save(new User("eee", 50));
        Assert.assertEquals(5, userRepository.findAll().size());
        messageRepository.save(new Message("o1", "aaaaaaaaaa"));
        messageRepository.save(new Message("o2", "bbbbbbbbbb"));
        messageRepository.save(new Message("o3", "cccccccccc"));
        Assert.assertEquals(3, messageRepository.findAll().size());
    }

}
